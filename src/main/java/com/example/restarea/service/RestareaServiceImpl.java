package com.example.restarea.service;

import com.example.restarea.dto.RestareaDTO;
import com.example.restarea.entity.Restarea;
import com.example.restarea.repository.RestareaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class RestareaServiceImpl implements RestareaService{

    private final RestareaRepository restareaRepository;
    private ModelMapper modelMapper = new ModelMapper();

//    public final ModelMapper modelMapper;
//    RootConfig, CustomModelMapper config가 있으면 위의 방식으로 modelmapper를 사용 가능하다.


    @Override
    public Restarea register(RestareaDTO restareaDTO) {
        log.info("등록 서비스로 들어온 값"+restareaDTO);

        Restarea restarea = modelMapper.map(restareaDTO, Restarea.class);

        restarea =
        restareaRepository.save(restarea);

        //controller를 통해서 service에 정의된 값을 구현
        return restarea;
    }

    @Override
    public RestareaDTO read(Long rno) {
        log.info("서비스 읽기로 들어온 값: "+ rno);

        return null;
    }

    @Override
    public List<RestareaDTO> list() {
        return null;
    }

    @Override
    public void update(RestareaDTO restareaDTO) {

    }

    @Override
    public void delete(Long rno) {

    }
}
