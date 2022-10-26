package com.ecommerce.pim.repositories;

import com.ecommerce.pim.models.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s WHERE s.id = :id and s.status ='1' and s.locked= '0'")
    List<Stock> findById(long id);

    @Query("SELECT s FROM Stock s WHERE s.status ='1' and s.locked= '0'")
    Page<Stock> findAll(Pageable pageable);

    Stock findByIdAndStatusAndLocked(long id, boolean status, boolean locked);

    @Query("SELECT s FROM Stock s WHERE s.active='0' and s.status ='1' and s.locked= '0'")
    Page<Stock> findNonActiveAll(Pageable pageable);

    @Query("SELECT s FROM Stock s WHERE s.active='1' and s.status ='1' and s.locked= '0'")
    Page<Stock> findActiveAll(Pageable pageable);

    Stock findByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsStockByIdAndStatusAndLocked(Long id, char status, char locked);

}
