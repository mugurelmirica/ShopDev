package com.mmugur81.REST_controller;

import com.mmugur81.REST_model.RestOrder;
import com.mmugur81.model.Order;
import com.mmugur81.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mugurel on 14.09.2016.
 * REST controller for orders
 */

@RestController
@RequestMapping("/api/order")
public class RestOrderController {

    private OrderService orderService;

    @Autowired
    public RestOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestOrder get(@PathVariable("id") long id) {
        Order order = this.orderService.get(id);
        return order.getRestOrder();
    }

}
