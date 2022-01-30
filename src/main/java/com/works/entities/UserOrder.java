package com.works.entities;

import lombok.Data;

@Data
public class UserOrder implements IOrder{

    private Integer pid;
    private Integer total;

}
