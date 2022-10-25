package com.ecommerce.om.repositories;

import com.ecommerce.om.models.Address;
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
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.id = :id and a.status ='1' and a.locked= '0'")
    List<Address> findById(long id);

    @Query("SELECT a FROM Address a WHERE a.status ='1' and a.locked= '0'")
    Page<Address> findAll(Pageable pageable);

    Address findByIdAndStatusAndLocked(long id, boolean status, boolean locked);

    @Query("SELECT a FROM Address a WHERE a.active='0' and a.status ='1' and a.locked= '0'")
    Page<Address> findNonActiveAll(Pageable pageable);

    @Query("SELECT a FROM Address a WHERE a.active='1' and a.status ='1' and a.locked= '0'")
    Page<Address> findActiveAll(Pageable pageable);

    Address findByIdAndStatusAndLocked(Long id, char status, char locked);

    boolean existsAddressByIdAndStatusAndLocked(Long id, char status, char locked);

}
