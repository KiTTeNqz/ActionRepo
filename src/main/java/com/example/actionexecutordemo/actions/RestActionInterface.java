package com.example.actionexecutordemo.actions;

public interface RestActionInterface<T> {
    public T execute();
    public String getName();
    public int getOrder();
}
