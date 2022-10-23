package com.ecommerce.pim.repositories;

import com.ecommerce.pim.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query("SELECT c FROM Category c WHERE c.id = :id and c.status = true and c.locked= false")
    List<Category> findById(long id);

    @Query("SELECT c FROM Category c WHERE c.categoryTitle = :categoryTitle and c.status = true and c.locked= false")
    List<Category> findByCategoryTitle(String categoryTitle);

    @Query("SELECT c FROM Category c WHERE c.status =true and c.locked= false")
    Page<Category> findAll(Pageable pageable);

    Category findByIdAndStatusAndLocked(long id,boolean status,boolean locked);

    boolean existsCategoryByIdAndStatusAndLocked(Long id,boolean status,boolean locked);

    boolean existsByCategoryTitleIgnoreCaseAndStatusAndLocked(String categoryTitle,boolean status,boolean locked);


}
