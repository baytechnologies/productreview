package com.bay.example.api.rest;

import com.bay.example.domain.Products;
import com.bay.example.exception.DataFormatException;
import com.bay.example.service.Productservice;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Class ProductsController This is controller class for handling all the 
 *        API requests.
 * 
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
@RestController
@RequestMapping(value = "/example/v1/products")
@Api(value = "products", description = "Products API")
public class ProductsController extends AbstractRestHandler {

    @Autowired
    private Productservice productservice;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a Products resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createProducts(@RequestBody Products Products,
                                 HttpServletRequest request, HttpServletResponse response) {
        Products createdProducts = this.productservice.createProducts(Products);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdProducts.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all products.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Products> getAllProducts(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.productservice.getAllproducts(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Products.", notes = "You have to provide a valid Products ID.")
    public
    @ResponseBody
    Products getProducts(@ApiParam(value = "The ID of the Products.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Products Products = this.productservice.getProducts(id);
        checkResourceFound(Products);
        //todo: http://goo.gl/6iNAkz
        return Products;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a Products resource.", notes = "You have to provide a valid Products ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateProducts(@ApiParam(value = "The ID of the existing Products resource.", required = true)
                                 @PathVariable("id") Long id, @RequestBody Products Products,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.productservice.getProducts(id));
        if (id != Products.getId()) throw new DataFormatException("ID doesn't match!");
        this.productservice.updateProducts(Products);
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a Products resource.", notes = "You have to provide a valid Products ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteProducts(@ApiParam(value = "The ID of the existing Products resource.", required = true)
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.productservice.getProducts(id));
        this.productservice.deleteProducts(id);
    }
}
