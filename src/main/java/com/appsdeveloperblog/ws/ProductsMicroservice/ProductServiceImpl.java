package com.appsdeveloperblog.ws.ProductsMicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ProductServiceImpl implements ProductService{

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {

        String productId = UUID.randomUUID().toString();

        //TODO: Persist Product Details into database table before publishing an event

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productRestModel.getTitle(), productRestModel.getPrice(), productRestModel.getQuantity());

        CompletableFuture<SendResult<String, ProductCreatedEvent>> future;
        future = kafkaTemplate.send("products-created-events-topic", productCreatedEvent);

        future.whenComplete((result, exeption) -> {
            if(exeption != null){
                LOGGER.error("Failed to send message: " + exeption.getMessage());
            } else {
                LOGGER.info("Message sent sucessfully: " + result.getRecordMetadata());
            }
        });

            future.join(); //esse pequeno trecho de código faz o processo ficar sincrono
        return "";
    }
}
