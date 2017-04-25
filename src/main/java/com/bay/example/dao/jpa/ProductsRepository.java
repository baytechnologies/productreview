package com.bay.example.dao.jpa;

import com.bay.example.domain.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @Class ProductsRepository
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */

public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
    Products findProductsByCity(String city);
    Page findAll(Pageable pageable);
}
