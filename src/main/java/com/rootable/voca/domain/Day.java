package com.rootable.voca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "DAY_SEQ_GENERATOR",
        sequenceName = "DAY_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_SEQ_GENERATOR")
    @Column(name = "day_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(10)")
    private Integer day;

}
