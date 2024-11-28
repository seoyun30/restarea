package com.example.restarea.dto;

import com.example.restarea.entity.Rating;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DeletionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dno;

    @Column
    private String title;

    @Column
    private String rejeciotn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rano")
    private Rating rating;

}

