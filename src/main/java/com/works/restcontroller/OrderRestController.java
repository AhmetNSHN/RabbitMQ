package com.works.restcontroller;

import com.works.entities.IOrder;
import com.works.entities.StatusOrder;
import com.works.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OrderRestController {

    final OrderProducer orderProducer;

    public OrderRestController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order")
    public Map<String, Object> order(@RequestBody IOrder order)
    {
        Map<String, Object> hm = new LinkedHashMap<>();
        orderProducer.sendToQueue(order);
        return hm;
    }

    @PostMapping("/messageOrder")
    public Map<String, Object> order(@RequestBody StatusOrder order)
    {
        Map<String, Object> hm = new LinkedHashMap<>();
        orderProducer.sendToQueue(order);
        return hm;
    }

}
