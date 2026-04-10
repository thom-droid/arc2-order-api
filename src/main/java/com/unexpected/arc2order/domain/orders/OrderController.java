package com.unexpected.arc2order.domain.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public OrderDetailResponse getOrderDetailById(@PathVariable Long orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
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
        return OrderPageResponse.from(orderService.getOrders(customerId, status, pageable));
    }

}
