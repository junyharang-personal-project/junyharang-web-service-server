package com.junyharang.config.logback.config;

import ch.qos.logback.classic.LoggerContext;
import com.junyharang.config.logback.appender.CustomLogbackAppender;
import com.junyharang.config.logback.service.ErrorLogService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class LogContextConfig implements InitializingBean {

    private LogConfig logConfig;

    private ErrorLogService errorLogService;

    @Override
    public void afterPropertiesSet() throws Exception {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        CustomLogbackAppender customLogbackAppender = new CustomLogbackAppender(errorLogService, logConfig);

        customLogbackAppender.setContext(loggerContext);
        customLogbackAppender.setName("customLogbackAppender");
        customLogbackAppender.start();
        loggerContext.getLogger("ROOT").addAppender(customLogbackAppender);
    }
}