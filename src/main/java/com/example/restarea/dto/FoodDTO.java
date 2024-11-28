package com.example.restarea.dto;

import com.example.restarea.entity.Store;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class FoodDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @Column(length = 50, nullable = false, unique = true)
    private String fname;

    @Column(length = 255, nullable = false)
    private String fcontant;

    @Column
    private Long fprice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sno")
    private Store store;

}

