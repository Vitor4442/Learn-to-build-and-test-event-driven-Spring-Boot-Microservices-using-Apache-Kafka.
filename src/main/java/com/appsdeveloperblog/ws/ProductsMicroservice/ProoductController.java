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
    @PostMapping
    public ResponseEntity<String> createProduct (@RequestBody CreateProductRestModel product){
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
