package com.rootable.voca.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResponseDto<E> {

    private List<E> dtoList; //데이터 목록

    private List<Integer> pageNumberList; //페이지 목록

    private PageRequestDto pageRequestDto; //검색 조건

    private boolean prev, next; //이전, 다음 페이지 이동

    //총 데이터 개수, 이전 페이지, 다음 페이지, 전체 페이지, 현재 페이지
    private int totalCount, prevPage, nextPage, totalPage, current;

    @Builder
    public PageResponseDto(List<E> dtoList, PageRequestDto pageRequestDto, int totalCount) {
        this.dtoList = dtoList;
        this.pageRequestDto = pageRequestDto;
        this.totalCount = totalCount;

        //화면의 시작, 끝 페이지
        int endNum = (int) (Math.ceil(pageRequestDto.getPage() / 10.0)) * 10;
        int startNum = endNum - 9;

        //마지막 페이지
        int lastPage = (int) Math.ceil(totalCount / (double) pageRequestDto.getSize());

        endNum = Math.min(endNum, lastPage);

        this.prev = startNum > 1;
        this.next = totalCount > endNum * pageRequestDto.getSize();

        this.pageNumberList = IntStream.rangeClosed(startNum, endNum).boxed().collect(Collectors.toList());

        this.prevPage = prev ? startNum - 1 : 0;
        this.nextPage = next ? endNum + 1 : 0;

        this.totalPage = this.pageNumberList.size();

        this.current = pageRequestDto.getPage();

    }

}
