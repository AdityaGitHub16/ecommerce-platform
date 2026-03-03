package com.project.microservices.order.controller;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("Receiving order for SKU: {}", orderRequest.skuCode());
        orderService.placeOrder(orderRequest);
        return "Order Place SuccessFully!!!";
    }
}
