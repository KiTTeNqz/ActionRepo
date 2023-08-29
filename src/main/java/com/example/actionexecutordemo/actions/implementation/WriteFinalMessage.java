package com.example.actionexecutordemo.actions.implementation;

import com.example.actionexecutordemo.actions.RestActionInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class WriteFinalMessage implements RestActionInterface<Void> {

    private final String secretMessage;

    @Override
    public Void execute() {
        log.info("I HATE NI"+secretMessage);
        return null;
    }

    @Override
    public String getName() {
        return "WriteFinalMessage";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
