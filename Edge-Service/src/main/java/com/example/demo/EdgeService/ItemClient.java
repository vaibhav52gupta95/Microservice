package com.example.demo.EdgeService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("item-catalog-service")
public interface ItemClient {

    @GetMapping("/items")
    Resources<Item> readItems();
}