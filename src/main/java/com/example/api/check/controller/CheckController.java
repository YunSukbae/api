package com.example.api.check.controller;

import com.example.api.check.service.CheckService;
import com.example.api.check.vo.CheckVo;
import com.example.api.check.vo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        UserEntity user = UserEntity.builder()
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();

        UserEntity registeredUser = userService.create(user);
        UserDTO responseUserDTO  = UserDTO.builder()
                .email(registeredUser.getEmail())
                .id(registeredUser.getId())
                .username(registeredUser.getUsername())
                .build();
        return ResponseEntity.ok().body(responseUserDTO);
    }

    @PostMapping("/check")
    public void check(CheckVo check){
        checkService.insertCheck(check);
    }

    @PostMapping("/check2")
    public void check2(@RequestBody CheckVo check){
        checkService.insertCheck(check);
    }

    @GetMapping("/checks")
    public List<CheckVo> selectCheckList(CheckVo checkVo){
        return checkService.selectCheckList(checkVo);
    }

}
