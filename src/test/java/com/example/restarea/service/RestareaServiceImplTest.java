package com.example.restarea.service;

import com.example.restarea.dto.RestareaDTO;
import com.example.restarea.entity.Restarea;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2

class RestareaServiceImplTest{

    @Autowired
    private RestareaService restareaService;

    @Test
    public void registerTest() {
        RestareaDTO restareaDTO = new RestareaDTO();
        restareaDTO.setRadd("경감 거제시");
        restareaDTO.setRcon("02-3333-4444");
        restareaDTO.setRname("매장임");

        Restarea restarea =
        restareaService.register(restareaDTO);
        log.info(restarea);

    }

}