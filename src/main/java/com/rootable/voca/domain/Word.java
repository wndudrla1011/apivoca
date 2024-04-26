package com.rootable.voca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "WORD_SEQ_GENERATOR",
        sequenceName = "WORD_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORD_SEQ_GENERATOR")
    @Column(name = "word_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id", referencedColumnName = "day_id")
    private Day day;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String eng;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String kor;

    @Column(nullable = false)
    private boolean isDone;

}
