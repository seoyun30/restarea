package com.example.restarea.entity;

import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "restarea")
public class Restarea {

    @Id
    @Column(name = "rno_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @Column(length = 50, nullable = false, unique = true)
    private String rname;

    @Column(length = 255, nullable = false)
    private String radd;

    @Column(length = 12, nullable = false)
    private String rcon;
}
