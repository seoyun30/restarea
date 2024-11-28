package com.example.restarea.dto;

import com.example.restarea.controller.Role;
import com.example.restarea.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하로 작성해주세요.")
    private String name;

    @Email(message = "이메일 형식으로 작성해주세요.")
    @NotBlank(message = "이메일을 작성해주세요")
    @Size(min = 2, max = 15, message = "메일은 2자 이상 15자 이하로 작성해주세요.")
    private String email;

    @NotBlank
    @Size(min = 8, max = 12, message = "영문,숫자,문자를 섞어서 8자 이상 12자 이하로 만들어주세요.")
    private String upw;

    @NotBlank
    @Size(min = 8, max = 12, message = "영문,숫자,문자를 섞어서 8자 이상 12자 이하로 만들어주세요.")
    private String upw1;

    //이미사용중인지 확인만들기
    private String unick;

    @Enumerated(EnumType.STRING) //권한 참조
    private Role role;

    public User dtoToEntity(UserDTO userDTO){

    }
}
