package com.junyharang.config.logback.service;

import com.junyharang.config.logback.entity.ErrorLog;

public interface ErrorLogService {

    void save(ErrorLog errorLog);
}