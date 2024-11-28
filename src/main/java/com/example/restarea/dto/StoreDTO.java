package com.example.restarea.dto;

import com.example.restarea.entity.Restarea;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StoreDTO {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private String sadd;

    private String smneme;

    private Long scon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno_id")
    private Restarea restarea;




}
