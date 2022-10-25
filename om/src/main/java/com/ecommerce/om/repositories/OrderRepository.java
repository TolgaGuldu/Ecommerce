package com.ecommerce.om.repositories;

import com.ecommerce.om.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    @Query("SELECT o FROM Order o WHERE o.id = :id and o.status ='1' and o.locked= '0'")
    List<Order> findById(long id);

    @Query("SELECT o FROM Order o WHERE o.status ='1' and o.locked= '0'")
    Page<Order> findAll(Pageable oageable);

    Order findByIdAndStatusAndLocked(long id, boolean status, boolean locked);

    @Query("SELECT o FROM Order o WHERE o.active='0' and o.status ='1' and o.locked= '0'")
    Page<Order> findNonActiveAll(Pageable oageable);

    @Query("SELECT o FROM Order o WHERE o.active='1' and o.status ='1' and o.locked= '0'")
    Page<Order> findActiveAll(Pageable oageable);

    Order findByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsOrderByIdAndStatusAndLocked(Long id, char status, char locked);
    
}
