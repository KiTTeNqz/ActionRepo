package com.example.actionexecutordemo.actions.implementation;

import com.example.actionexecutordemo.actions.RuleInterface;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeaderRule implements RuleInterface {

    private final HttpServletRequest request;

    @Override
    public Boolean execute() {
        String headerValue = request.getHeader("dimasik");
        return "dimich".equals(headerValue);
    }

    @Override
    public String getName() {
        return "HeaderRule";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
