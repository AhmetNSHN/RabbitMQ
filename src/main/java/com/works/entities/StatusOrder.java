package com.works.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusOrder implements Serializable, IOrder {
    private Integer oid;
    private Integer message;
}
