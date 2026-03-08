package com.appsdeveloperblog.ws.ProductsMicroservice;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

public class ProductServiceImpl implements ProductService{

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public ProductServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {

        String productId = UUID.randomUUID().toString();

        //TODO: Persist Product Details into database table before publishing an event

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productRestModel.getTitle(), productRestModel.getPrice(), productRestModel.getQuantity());

        kafkaTemplate.send("products-created-events-topic", productId, productCreatedEvent);

        return "";
    }
}
