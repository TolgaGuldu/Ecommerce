package com.ecommerce.pim.repositories;

import com.ecommerce.pim.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.id = :id and p.status ='1' and p.locked= '0'")
    List<Product> findById(long id);

    @Query("SELECT p FROM Product p WHERE p.status ='1' and p.locked= '0'")
    Page<Product> findAll(Pageable pageable);

    Product findByIdAndStatusAndLocked(long id, boolean status, boolean locked);

    @Query("SELECT p FROM Product p WHERE p.active='0' and p.status ='1' and p.locked= '0'")
    Page<Product> findNonActiveAll(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.active='1' and p.status ='1' and p.locked= '0'")
    Page<Product> findActiveAll(Pageable pageable);

    Product findByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsProductByIdAndStatusAndLocked(Long id, char status, char locked);

}
