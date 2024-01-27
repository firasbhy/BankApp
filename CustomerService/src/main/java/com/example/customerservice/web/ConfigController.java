package com.example.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {
    @Value("${global.params.p1}")
    private  int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x}")
    private  int x;
    @Value("${customer.params.y}")
    private int y;
    @GetMapping("/ConfigTest")
    public Map<String,Integer> getConfig() {
        Map<String,Integer> map =new HashMap<>();
        map.put("p1",p1);
        map.put("p2",p2);
        map.put("x",x);
        map.put("y",y);

        return map;
    }
}
