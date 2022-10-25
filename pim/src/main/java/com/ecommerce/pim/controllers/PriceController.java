package com.ecommerce.pim.controllers;

import com.ecommerce.pim.dtos.create.CreatePriceRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdatePriceRequestDto;
import com.ecommerce.pim.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@RestController
@RequestMapping("/price")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping("/getById")
    public ResponseEntity<?> getByPriceId(@RequestParam String id) {
        return ResponseEntity.ok(priceService.getPriceById(id));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getPriceByActive(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int limit,
                                              @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(priceService.getPriceByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getPriceByNonActive(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(priceService.getPriceByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllPriceofPage(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int limit,
                                               @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(priceService.getAllPriceofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllPriceofList() {
        return ResponseEntity.ok(priceService.getAllPriceofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createPrice(@Valid @RequestBody CreatePriceRequestDto createPriceRequestDto) {
        return ResponseEntity.ok(priceService.createPrice(createPriceRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePrice(@RequestParam String id, @Valid @RequestBody UpdatePriceRequestDto updatePriceRequestDto) {
        return ResponseEntity.ok(priceService.updatePrice(id, updatePriceRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActivePrice(@RequestParam String id, @Valid @RequestBody UpdateActiveRequestDto updatePriceRequestDto) {
        return ResponseEntity.ok(priceService.updateActivePrice(id, updatePriceRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeletePriceById(@RequestParam String id) {
        return ResponseEntity.ok(priceService.softDeletePriceById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeletePriceById(@RequestParam String id) {
        return ResponseEntity.ok(priceService.hardDeletePriceById(id));
    }

}
