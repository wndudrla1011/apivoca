package com.rootable.voca.service;

import com.rootable.voca.domain.Day;
import com.rootable.voca.dto.DayDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DayService {

    Long create(DayDto dto);

    default Day dtoToEntity(DayDto dto) {
        return Day.builder()
                .day(dto.getDay())
                .build();
    }

}
