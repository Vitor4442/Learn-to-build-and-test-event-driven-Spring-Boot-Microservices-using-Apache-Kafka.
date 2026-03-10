package com.appsdeveloperblog.ws.ProductsMicroservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProoductController {

    private final ProductService service;

    public ProoductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createProduct (@RequestBody CreateProductRestModel product){

        String productId = service.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
    }
}
