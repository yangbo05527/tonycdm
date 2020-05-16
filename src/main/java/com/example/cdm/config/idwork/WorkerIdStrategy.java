package com.example.cdm.config.idwork;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
