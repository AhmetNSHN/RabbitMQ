package com.works.repositories;

import com.works.entities.ProOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProOrder, Integer> {
}
