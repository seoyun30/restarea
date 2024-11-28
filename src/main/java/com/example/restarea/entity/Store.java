package com.example.restarea.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private String sadd;

    private String smneme;

    private int scon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno_id")
    private Restarea restarea;




}
