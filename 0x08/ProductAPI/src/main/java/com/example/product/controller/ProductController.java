package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    @GetMapping(value = "/welcome")
    public String welcome() {
        return "BEM VINDO À PRODUCT REST API.";
    }

    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products")
    })
    @GetMapping(value = "/allProducts")
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productRepository.getAllProducts());
    }

    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed")
    })
    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id was not informed. This information is required")
    })
    @GetMapping(value = "/findProductById/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(productRepository.getProductById(id));
    }

    @ApiOperation(value = "Responsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in database")
    })
    @PutMapping(value = "/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
    }

    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @DeleteMapping(value = "/removeProduct")
    public void deleteProduct(@RequestBody Product product) {
        productRepository.removeProduct(product);
    }

}
