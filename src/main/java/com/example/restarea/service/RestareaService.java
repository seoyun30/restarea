package com.example.restarea.service;

import com.example.restarea.dto.RestareaDTO;
import com.example.restarea.entity.Restarea;

import java.util.List;

public interface RestareaService {

    //등록
    public Restarea register(RestareaDTO restareaDTO);

    //읽기
    public RestareaDTO read(Long rno);

    //목록
    public List<RestareaDTO> list();

    //수정
    public void update(RestareaDTO restareaDTO);

    //삭제
    public void delete(Long rno);

}
