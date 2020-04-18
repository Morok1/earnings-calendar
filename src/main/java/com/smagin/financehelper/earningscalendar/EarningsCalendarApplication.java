package com.smagin.financehelper.earningscalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class EarningsCalendarApplication {
    public static void main(String[] args) {
        SpringApplication.run(EarningsCalendarApplication.class, args);
    }
}
