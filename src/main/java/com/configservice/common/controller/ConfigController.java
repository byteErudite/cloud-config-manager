package com.configservice.common.controller;

import com.configservice.common.config.DbProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ConfigController {

    @Value("${my.greetings: default greetings}")
    private String greetingMessage;

    @Value("${message.from: from local}")
    private String messageFrom;

    @Value("#{${my.value.pairs}}")
    private Map<String, String> testPairs;

    @Value("${my.name.components}")
    private List<String> ownerNameComponents;

    @Autowired
    private DbProperties dbProperties;

    @GetMapping("/greeting")
    public ResponseEntity<String> getPropertiesValue() {
        return new ResponseEntity<>(greetingMessage + messageFrom, HttpStatus.OK);
    }

    @GetMapping("/owner")
    public ResponseEntity<List<String>> getOwnerName() {
        return new ResponseEntity<>(ownerNameComponents , HttpStatus.OK);
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<String> getOwnerName(@PathVariable String key) {
        return new ResponseEntity<>(testPairs.containsKey(key) ? testPairs.get(key) : "does not exist" , HttpStatus.OK);
    }

    @GetMapping("/properties")
    public ResponseEntity<String> getDbProperties() {
        return new ResponseEntity<>(dbProperties.toString() , HttpStatus.OK);
    }
}
