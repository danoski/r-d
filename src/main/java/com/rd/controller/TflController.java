package com.rd.controller;

import com.domain.RoadStatus;
import com.domain.ErrorStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rd.client.TflClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TflController {

    private TflClient tflClient;
    @Value("${key.api}")
    String apiKey;

    @Value("${key.token}")
    String apiToken;

    public TflController(TflClient tflClient) {
        this.tflClient = tflClient;
    }

    @GetMapping(value = "/Road/{ids}")
    ResponseEntity <List<RoadStatus>> getRoadStatus(@PathVariable(name = "ids")String ids) throws Exception{
        try {
            return tflClient.getRoadStatus(ids);
        } catch (FeignException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorStatus r = objectMapper.readValue(e.responseBody().get().array(), ErrorStatus.class);
            return new ResponseEntity(r,HttpStatus.valueOf(e.status()));
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
