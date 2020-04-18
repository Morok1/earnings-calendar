package com.smagin.financehelper.earningscalendar.service;

import com.smagin.financehelper.earningscalendar.entity.EarningInfo;
import com.smagin.financehelper.earningscalendar.repository.EarningsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class EarningService {
    private final EarningsRepository repository;
    public void saveAll(Iterable<EarningInfo> infos){
        log.info("Save info with time:" + LocalDateTime.now() +  "...");
        repository.saveAll(infos);
        log.info("Save info with time:" + LocalDateTime.now() +  "... done!");
    }
}
