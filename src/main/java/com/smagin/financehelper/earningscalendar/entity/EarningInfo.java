package com.smagin.financehelper.earningscalendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "earnings")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = PRIVATE)
public class EarningInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;
    @Column(name = "date")
    String date;
    @Column(name = "epsActual")
    String epsActual;
    @Column(name = "epsEstimate")
    String epsEstimate;
    @Column(name = "hour")
    String hour;
    @Column(name = "quarter")
    String quarter;
    @Column(name = "revenueActual")
    String revenueActual;
    @Column(name = "revenueEstimate")
    String revenueEstimate;
    @Column(name = "symbol")
    String symbol;
    @Column(name = "year")
    String year;

}
