package com.bay.example.service;

import com.bay.example.domain.Products;
import com.bay.example.dao.jpa.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * @Class Productservice
 * Sample service to demonstrate what the API would use to get things done
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
@Service
public class Productservice {

    private static final Logger log = LoggerFactory.getLogger(Productservice.class);

    @Autowired
    private ProductsRepository ProductsRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public Productservice() {
    }

    public Products createProducts(Products Products) {
        return ProductsRepository.save(Products);
    }

    public Products getProducts(long id) {
        return ProductsRepository.findOne(id);
    }

    public void updateProducts(Products Products) {
        ProductsRepository.save(Products);
    }

    public void deleteProducts(Long id) {
        ProductsRepository.delete(id);
    }

    //http://goo.gl/7fxvVf
    public Page<Products> getAllproducts(Integer page, Integer size) {
        Page pageOfproducts = ProductsRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("bay.productservice.getAll.largePayload");
        }
        return pageOfproducts;
    }
}
