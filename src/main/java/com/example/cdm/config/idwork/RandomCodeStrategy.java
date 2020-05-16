package com.example.cdm.config.idwork;

public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
