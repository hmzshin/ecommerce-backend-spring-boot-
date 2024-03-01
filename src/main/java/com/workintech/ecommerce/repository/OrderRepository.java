
package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
