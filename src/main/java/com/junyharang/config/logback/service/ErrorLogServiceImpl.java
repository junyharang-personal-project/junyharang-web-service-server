package com.junyharang.config.logback.service;

import com.junyharang.config.logback.entity.ErrorLog;
import com.junyharang.config.logback.entity.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ErrorLogServiceImpl implements ErrorLogService{

    private final ErrorLogRepository errorLogRepository;

    @Transactional
    public void save(ErrorLog errorLog) {
        errorLogRepository.save(errorLog);
    }
}