package com.smagin.financehelper.earningscalendar.repository;

import com.smagin.financehelper.earningscalendar.entity.EarningInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarningsRepository  extends JpaRepository< EarningInfo, Long> {

}
