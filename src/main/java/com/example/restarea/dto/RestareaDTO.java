package com.example.restarea.dto;

import com.example.restarea.entity.Restarea;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class RestareaDTO {

    private Long rno;

    @NotBlank(message = "휴게소의 이름을 작성해주세요")
    private String rname;

    @NotBlank(message = "휴게소의 주소를 작성해주세요")
    private String radd;

    @NotBlank(message = "휴게소의 관리실 번호를 작성해주세요.")
    private String rcon;

    public Restarea dtoToEntity(RestareaDTO restareaDTO){

        Restarea restarea = new Restarea();
        restarea.setRno(restareaDTO.getRno());
        restarea.setRname(restareaDTO.getRname());
        restarea.setRadd(restareaDTO.getRadd());
        restarea.setRcon(restarea.getRcon());

        return restarea;
    }




}




