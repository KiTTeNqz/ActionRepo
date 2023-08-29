package com.example.actionexecutordemo.controller;

import com.example.actionexecutordemo.actions.ActionExecutorBuilder;
import com.example.actionexecutordemo.actions.implementation.HeaderRule;
import com.example.actionexecutordemo.actions.implementation.WriteFinalMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @PostMapping("/test")
    public String sayHello(HttpServletRequest request) throws IOException {
        ActionExecutorBuilder.<String, Boolean>builder()
                .rules(new HeaderRule(request))
                .build()
                .executeRules()
                .executeFinalAction(
                    new WriteFinalMessage(
                            "GHT"
                    )
                );

        return "Processing...";
    }
}
