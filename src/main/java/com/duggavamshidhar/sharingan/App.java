package com.duggavamshidhar.sharingan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping
public class App {

    @GetMapping(value = "/", produces = "application/json")
    public Map<String, String> index() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "For more information, visit the API documentation at /api-docs");
        return map;
    }

    @GetMapping(value = "/api-docs")
    public ResponseEntity<Void> apiDocs() {
        String apiDocsUrl = "https://github.com/duggavamshidhar/sharingan/blob/main/README.md";
        return ResponseEntity.status(302).header("Location", apiDocsUrl).build();
    }

    @GetMapping(value = "/**", produces = "application/json")
    public ResponseEntity<Map<String, String>> notFound() {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Not Found");
        return status(404).body(errorResponse);
    }

}
