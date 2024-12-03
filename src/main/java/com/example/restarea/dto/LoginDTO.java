package com.example.restarea.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    //이거 왜 만드는건데?
    private String email;
    private String password;
}
