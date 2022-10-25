package com.ecommerce.pim.repositories;

import com.ecommerce.pim.models.Category;
import com.ecommerce.pim.models.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.id = :id and p.status ='1' and p.locked= '0'")
    List<Price> findById(long id);

    @Query("SELECT p FROM Price p WHERE p.status ='1' and p.locked= '0'")
    Page<Price> findAll(Pageable pageable);

    Price findByIdAndStatusAndLocked(long id, boolean status, boolean locked);

    @Query("SELECT p FROM Price p WHERE p.active='0' and p.status ='1' and p.locked= '0'")
    Page<Price> findNonActiveAll(Pageable pageable);

    @Query("SELECT p FROM Price p WHERE p.active='1' and p.status ='1' and p.locked= '0'")
    Page<Price> findActiveAll(Pageable pageable);

    Price findByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsPriceByIdAndStatusAndLocked(Long id, char status, char locked);

}
