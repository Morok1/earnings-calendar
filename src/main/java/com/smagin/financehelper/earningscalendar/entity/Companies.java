package com.smagin.financehelper.earningscalendar.entity;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public enum Companies {
    APPL("apple");

    private final String name;
    public Function<String, String> toUpperCase = String::toUpperCase;
}
