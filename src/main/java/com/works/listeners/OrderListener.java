package com.works.listeners;

import com.works.entities.IOrder;
import com.works.entities.ProOrder;
import com.works.entities.StatusOrder;
import com.works.repositories.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.works.entities.UserOrder;

@Service
public class OrderListener {

    private OrderRepository oRepo;
    public OrderListener(OrderRepository oRepo) {
        this.oRepo = oRepo;
    }

    @RabbitListener(queues = "bilgeadam-queue")
    public void handleOrder(IOrder order) {
        try {
            if ( order instanceof UserOrder) {
                UserOrder u = (UserOrder) order;
                ProOrder p = new ProOrder();
                p.setPid(u.getPid());
                p.setTotal(u.getTotal());
                oRepo.save(p);
            }
            if ( order instanceof StatusOrder) {
                StatusOrder s = (StatusOrder) order;
                System.out.println(s.getOid());
                System.out.println(s.getMessage());
            }
        }catch (Exception ex) {
            System.err.println("handleOrder Error : " + ex);
        }
    }

}