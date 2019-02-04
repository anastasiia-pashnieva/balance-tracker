package com.pashnieva.website.api.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusWS {

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        return ResponseEntity.ok("Status: UP");
    }
}
