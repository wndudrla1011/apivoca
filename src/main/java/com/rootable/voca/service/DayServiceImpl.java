package com.rootable.voca.service;

import com.rootable.voca.dto.DayDto;
import com.rootable.voca.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;

    /*
    * Day 등록
    * */
    @Override
    public Long create(DayDto dto) {
        return dayRepository.save(dtoToEntity(dto)).getId();
    }

}
