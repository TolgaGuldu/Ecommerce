package com.ecommerce.pim.controllers;

import com.ecommerce.pim.dtos.create.CreateStockRequestDto;
import com.ecommerce.pim.dtos.update.UpdateActiveRequestDto;
import com.ecommerce.pim.dtos.update.UpdateStockRequestDto;
import com.ecommerce.pim.services.StockService;
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
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getByStockId(@RequestParam String id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping("/getByActive")
    public ResponseEntity<?> getStockByActive(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int limit,
                                              @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(stockService.getStockByActive(page, limit, type));
    }

    @GetMapping("/getByNonActive")
    public ResponseEntity<?> getStockByNonActive(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(stockService.getStockByNonActive(page, limit, type));
    }

    @GetMapping("/getAllPage")
    public ResponseEntity<?> getAllStockofPage(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int limit,
                                               @RequestParam(defaultValue = "id") String type) {
        return ResponseEntity.ok(stockService.getAllStockofPage(page, limit, type));
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getAllStockofList() {
        return ResponseEntity.ok(stockService.getAllStockofList());
    }


    @PostMapping("/create")
    public ResponseEntity<?> createStock(@Valid @RequestBody CreateStockRequestDto createStockRequestDto) {
        return ResponseEntity.ok(stockService.createStock(createStockRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStock(@RequestParam String id, @Valid @RequestBody UpdateStockRequestDto updateStockRequestDto) {
        return ResponseEntity.ok(stockService.updateStock(id, updateStockRequestDto));
    }

    @PutMapping("/updateActive")
    public ResponseEntity<?> updateActiveStock(@RequestParam String id, @Valid @RequestBody UpdateActiveRequestDto updateStockRequestDto) {
        return ResponseEntity.ok(stockService.updateActiveStock(id, updateStockRequestDto));
    }

    @DeleteMapping("/softDeletebyId")
    public ResponseEntity<?> softDeleteStockById(@RequestParam String id) {
        return ResponseEntity.ok(stockService.softDeleteStockById(id));
    }

    @DeleteMapping("/hardDeletebyId")
    public ResponseEntity<?> hardDeleteStockById(@RequestParam String id) {
        return ResponseEntity.ok(stockService.hardDeleteStockById(id));
    }
}
