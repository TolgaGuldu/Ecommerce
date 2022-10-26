package com.ecommerce.om.controllers;

import com.ecommerce.om.dtos.create.CreateAddressRequestDto;
import com.ecommerce.om.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.om.dtos.update.UpdateAddressRequestDto;
import com.ecommerce.om.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@RestController
@RequestMapping("/address")
public class AddressController {
    
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/getById")
    public ResponseEntity<?> getByAddressId(@RequestParam String id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getAddressByActive(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int limit,
                                              @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(addressService.getAddressByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getAddressByNonActive(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(addressService.getAddressByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllAddressofPage(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int limit,
                                               @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(addressService.getAllAddressofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllAddressofList() {
        return ResponseEntity.ok(addressService.getAllAddressofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@Valid @RequestBody CreateAddressRequestDto createAddressRequestDto) {
        return ResponseEntity.ok(addressService.createAddress(createAddressRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestParam String id, @Valid @RequestBody UpdateAddressRequestDto updateAddressRequestDto) {
        return ResponseEntity.ok(addressService.updateAddress(id, updateAddressRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActiveAddress(@RequestParam String id, @Valid @RequestBody UpdateActiveRequestDto updateAddressRequestDto) {
        return ResponseEntity.ok(addressService.updateActiveAddress(id, updateAddressRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeleteAddressById(@RequestParam String id) {
        return ResponseEntity.ok(addressService.softDeleteAddressById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeleteAddressById(@RequestParam String id) {
        return ResponseEntity.ok(addressService.hardDeleteAddressById(id));
    }
    
}
