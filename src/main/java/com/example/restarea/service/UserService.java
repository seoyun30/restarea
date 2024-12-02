package com.example.restarea.service;

import com.example.restarea.constant.Role;
import com.example.restarea.dto.UserDTO;
import com.example.restarea.entity.User;
import com.example.restarea.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class UserService implements UserDetailsService {


    private final UserRepository userRepository; //been 값이 있을때 @RequiredArgsConstructo + final을
                                                 // 이용해서 의존성으로 생서자를 주입해서 사용할때 방법


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //비밀번호 유효성을 확인하는거

    private ModelMapper modelMapper = new ModelMapper();  //been 없이 직접 생성자를 만들어서 사용할때 방법

    //User 일반 회원가입
    public User saveUser(UserDTO userDTO){
        //가입여부 확인

        //컨트롤러에서 받은 userDTO를 user entity로 변경
        User user = userDTO.dtoToEntity(userDTO);

        user = userRepository.save(user);

        return user;
    }

    //Admin 사장님 회원가입
    public User saveUserM(UserDTO userDTO){
        //가입여부 확인

        //modelmapper를 이용한 방식
        User user = modelMapper.map(userDTO, User.class);
            user.setUpw(passwordEncoder.encode(userDTO.getUpw()));
            user.setRole(Role.MANAGER);
        user = userRepository.save(user);

        return user;
    }

    //회원가입여부를 확인하는 메소드
    //위에 회원가입 public을 만들때 직접 써도 되지만 여러번 사용하기 때문에 메소드를 만들어서 사용
    private void validateDuplicateMember(String email){

        User user = userRepository.findByEmail(email);
            //userRepository(저장소)에 있는 동일한 email을 가진게 있는지 확인한다는 의미
        if (user != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }


    //로그인
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        log.info("로그인 하려는 사람"+user);

        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())    //세션에 저장됨
                .password(user.getUpw()) // 로그인시 입력한 비밀번호와 비교할값
                .roles(user.getRole().name())
                .build();
    }

}