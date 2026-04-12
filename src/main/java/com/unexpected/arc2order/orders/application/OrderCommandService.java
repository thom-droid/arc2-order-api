package com.unexpected.arc2order.orders.application;

import com.unexpected.arc2order.customer.application.CustomerQueryService;
import com.unexpected.arc2order.customer.domain.Customer;
import com.unexpected.arc2order.orders.api.request.CreateOrderRequest;
import com.unexpected.arc2order.orders.api.response.CreateOrderResponse;
import com.unexpected.arc2order.orders.api.response.OrderStatusUpdateResponse;
import com.unexpected.arc2order.orders.application.exception.OrderNotFoundException;
import com.unexpected.arc2order.orders.domain.OrderEntity;
import com.unexpected.arc2order.orders.domain.OrderItemEntity;
import com.unexpected.arc2order.orders.domain.OrderStatus;
import com.unexpected.arc2order.orders.infrastructure.OrderItemRepository;
import com.unexpected.arc2order.orders.infrastructure.OrderRepository;
import com.unexpected.arc2order.product.application.ProductQueryService;
import com.unexpected.arc2order.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderCommandService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerQueryService customerQueryService;
    private final ProductQueryService productQueryService;

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Long customerId = createOrderRequest.customerId();
        Customer customer = customerQueryService.findById(customerId);

        List<OrderItemEntity> orderItemEntities = createOrderRequest.items().stream()
                .map(itemRequest -> {
                    OrderItemEntity oi = new OrderItemEntity();
                    Product p = productQueryService.findById(itemRequest.productId());
                    oi.setProduct(p);
                    oi.setUnitPrice(p.getPrice());
                    oi.setQuantity(itemRequest.quantity());
                    return oi;
                })
                .toList();

        BigDecimal amount = orderItemEntities.stream()
                .map(oi -> {
                    return oi.getUnitPrice().multiply(BigDecimal.valueOf(oi.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.CREATED);
        order.setAmount(amount);
        order.setCreatedAt(LocalDateTime.now());
        OrderEntity savedOrder = orderRepository.save(order);

        orderItemEntities.forEach(oi -> oi.setOrderEntity(savedOrder));
        orderItemRepository.saveAll(orderItemEntities);

        return CreateOrderResponse.from(savedOrder);
    }

    @Transactional
    public OrderStatusUpdateResponse confirmOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.markAsConfirmed();
        OrderEntity savedOrder = orderRepository.save(order);
        return OrderStatusUpdateResponse.from(savedOrder);
    }

    @Transactional
    public OrderStatusUpdateResponse cancelOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.markAsCancelled();
        OrderEntity savedOrder = orderRepository.save(order);
        return OrderStatusUpdateResponse.from(savedOrder);
    }

}
