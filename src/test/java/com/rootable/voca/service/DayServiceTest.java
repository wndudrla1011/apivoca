package com.rootable.voca.service;

import com.rootable.voca.domain.Day;
import com.rootable.voca.dto.DayDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DayServiceTest {

    @Autowired
    DayService dayService;

    @Test
    void create() {

        int dayNum = 1;

        DayDto dayDto = DayDto.builder()
                .day(dayNum)
                .build();

        dayService.create(dayDto);

    }

}