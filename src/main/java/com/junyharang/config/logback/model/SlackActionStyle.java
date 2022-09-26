package com.junyharang.config.logback.model;

public enum SlackActionStyle {
    DEFAULT("default"), PRIMARY("primary"), DANGER("danger");

    private String code;

    SlackActionStyle(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
