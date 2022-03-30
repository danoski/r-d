package com.rd.client;

import com.domain.RoadStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://api.tfl.gov.uk/", value = "TflClient")
public interface TflClient {

    @GetMapping(value = "/Road/{ids}")
    ResponseEntity<List<RoadStatus>> getRoadStatus(@PathVariable(name = "ids") String roadId);
}
