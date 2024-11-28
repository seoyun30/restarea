package com.example.restarea.dto;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class RestareaDTO {

    @Id
    @Column(name = "rno_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @Column(length = 50, nullable = false, unique = true)
    private String rname;

    @Column(length = 255, nullable = false)
    private String radd;

    @Column(length = 12, nullable = false)
    private Long rcon;
}
