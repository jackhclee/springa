package com.example.demo;

import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class KafkaMsgListener {
    @KafkaListener(topics = "test")
    public void processMessage(String content) {
        log.info(content);
        if (content.length() < 5) {
            throw new IllegalArgumentException("argument too short");
        }
    }
}
