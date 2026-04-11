package com.unexpected.arc2order.orders.api;

import com.unexpected.arc2order.orders.domain.OrderEntity;
import com.unexpected.arc2order.orders.application.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderQueryService orderQueryService;

    @GetMapping("/{orderId}")
    public OrderDetailResponse getOrderDetailById(@PathVariable Long orderId) {
        OrderEntity order = orderQueryService.getOrderById(orderId);
        return new OrderDetailResponse(
                order.getId(),
                order.getCustomerId(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getAmount()
        );
    }

    @GetMapping
    public OrderPageResponse getOrderEntities(@RequestParam(defaultValue = "0") int pageNumber,
                                                      @RequestParam(defaultValue = "20") int pageSize,
                                                      @RequestParam(required = false) String status,
                                                      @RequestParam Long customerId) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("createdAt").descending());
        return OrderPageResponse.from(orderQueryService.getOrders(customerId, status, pageable));
    }

}
