package com.example.api.check.controller;

import com.example.api.check.service.CheckService;
import com.example.api.check.vo.CheckVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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