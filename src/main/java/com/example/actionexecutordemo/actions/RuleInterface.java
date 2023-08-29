package com.example.actionexecutordemo.actions;

public interface RuleInterface<T> {
    public T execute();

    public String getName();

    public int getOrder();
}
