package com.smagin.financehelper.earningscalendar.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smagin.financehelper.earningscalendar.entity.Companies;
import com.smagin.financehelper.earningscalendar.entity.EarningInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiIntegrator {
    private final RestTemplate restTemplate;
    public static final String FINHUB_URL = "https://finnhub.io/api/v1/calendar/earnings?from=2020-03-12&to=2020-03-15&token=bqcsrp7rh5rdevg56gd0";

    @Scheduled(fixedDelay = 100000)
    public List<EarningInfo> getEarningByCompanyNames() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> params = prepareParams();
        ResponseEntity<JsonNode> forEntity = restTemplate.getForEntity(FINHUB_URL, JsonNode.class, params);
        final List<EarningInfo> earningInfos = mapper.readValue(forEntity.getBody().get("earningsCalendar").toString(), new TypeReference< List<EarningInfo>>() {});
        return earningInfos;
    }

    private Map<String, String> prepareParams() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol", Companies.APPL.name());
        return params;
    }
}
