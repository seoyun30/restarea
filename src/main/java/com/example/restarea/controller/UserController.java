package com.example.restarea.controller;

import com.example.restarea.dto.UserDTO;
import com.example.restarea.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.Module;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/restarea")
@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    //일반 USER회원가입
    @GetMapping("/new") //회원가입 페이지
    public String userForm(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "user/userForm";
    }

    @PostMapping("/new")
    public String userFormPost(@Valid UserDTO userDTO, BindingResult bindingResult, Model model){
                                //@Valid 유효성 검사,  BindingResult 검증오류 보관 객체,
                                // Model .addAttribute()를 통해 view에 전달할 데이터를 저장
        log.info("저장의 post로 들어온 userDTO:" + userDTO);

        //윺효성 검사에 에러가 있는 경우
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "user/userForm";
        }

        //유효성 검사에 에러가 없는 경우
        try {
            userService.saveUser(userDTO);
        }catch (IllegalStateException e){
            model.addAttribute("msg", e.getMessage());
            return "user/userForm";
        }

        return null;
    }

    //MANAGER 사장님 회원가입
    @GetMapping("/newM") //회원가입 페이지
    public String userFormM(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "user/userFormM";
    }

    @PostMapping("/newM")
    public String userFormPostM(@Valid UserDTO userDTO, BindingResult bindingResult, Model model){
        //@Valid 유효성 검사,  BindingResult 검증오류 보관 객체,
        // Model .addAttribute()를 통해 view에 전달할 데이터를 저장
        log.info("저장의 post로 들어온 userDTO:" + userDTO);

        //윺효성 검사에 에러가 있는 경우
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "user/userFormM";
        }

        //유효성 검사에 에러가 없는 경우
        try {
            userService.saveUserM(userDTO);
        }catch (IllegalStateException e){
            model.addAttribute("msg", e.getMessage());
            return "user/userFormM";
        }

        return null;
    }

    @GetMapping("/login")
    public String loginMember(){
        return "user/loginForm";
    }

}
