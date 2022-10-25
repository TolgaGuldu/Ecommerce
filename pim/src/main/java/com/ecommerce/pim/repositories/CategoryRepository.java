package com.ecommerce.pim.repositories;

import com.ecommerce.pim.models.Category;
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
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.id = :id and c.status = '1' and c.locked= '0'")
    List<Category> findById(long id);

    @Query("SELECT c FROM Category c WHERE c.categoryTitle = :categoryTitle and c.status = '1' and c.locked= '0'")
    List<Category> findByCategoryTitle(String categoryTitle);


    @Query("SELECT c FROM Category c WHERE c.status ='1' and c.locked= '0'")
    Page<Category> findAll(Pageable pageable);

    @Query("SELECT c FROM Category c WHERE c.active='0' and c.status ='1' and c.locked= '0'")
    Page<Category> findNonActiveAll(Pageable pageable);

    @Query("SELECT c FROM Category c WHERE c.active='1' and c.status ='1' and c.locked= '0'")
    Page<Category> findActiveAll(Pageable pageable);

    Category findByIdAndStatusAndLocked(Long id, char status, char locked);

    Category findByCategoryTitleAndStatusAndLocked(String categoryTitle, char status, char locked);

    Category deleteByCategoryTitle(String categoryTitle);

    boolean existsCategoryByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsByCategoryTitleIgnoreCaseAndStatusAndLocked(String categoryTitle, char status, char locked);

}
