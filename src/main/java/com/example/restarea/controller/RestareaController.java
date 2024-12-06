package com.example.restarea.controller;

import com.example.restarea.dto.RestareaDTO;
import com.example.restarea.entity.Restarea;
import com.example.restarea.service.RestareaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/sadmin")
public class RestareaController {

    private final RestareaService restareaService;

    //휴게소 등록 보기 페이지
    @GetMapping("/register")
    public String registerGet(){

        return "sadmin/register";
    }

    //휴게소 등록 포스트
    @PostMapping("/register")
    public String registerPost(RestareaDTO restareaDTO){
        log.info("컨트롤러로 들어온값 : "+ restareaDTO);

        restareaService.register(restareaDTO);

        return "redirect:/sadmin/list";
    }

    @GetMapping("/list")
    public String list(Model model){


        //서비스에서 휴게소리스트를 받아올것
        //모델어트로비트로 담아서 보낼것
        //밑에 html에 데이터 찍어줄것
        //휴게소 서비스 만들기

        model.addAttribute("restareaDTO", new RestareaDTO());

        return "sadmin/list";
    }


}
