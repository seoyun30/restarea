package com.example.restarea.entity;

import com.example.restarea.constant.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id //
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String upw;

    @Column
    private String unick;

    @Enumerated(EnumType.STRING) //권한 참조
    private Role role;
}
