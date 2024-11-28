package com.example.restarea.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "deletion")
public class Deletion {

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

