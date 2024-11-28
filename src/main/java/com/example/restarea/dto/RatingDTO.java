package com.example.restarea.dto;

import com.example.restarea.entity.Food;
import com.example.restarea.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class RatingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rano;

    private String ratext;

    private String rawriter;

    private LocalDateTime regidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fno")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
