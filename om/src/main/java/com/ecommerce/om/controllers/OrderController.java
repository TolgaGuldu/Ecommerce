package com.ecommerce.om.controllers;

import com.ecommerce.om.models.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

}
