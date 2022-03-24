package com.example.api.check.service.impl;

import com.example.api.check.mapper.CheckMapper;
import com.example.api.check.service.CheckService;
import com.example.api.check.vo.CheckVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public void insertCheck(CheckVo checkVo) {
        checkMapper.insertCheck(checkVo);
    }

    @Override
    public List<CheckVo> selectCheckList(CheckVo checkVo) {
        return checkMapper.selectCheckList(checkVo);
    }
}
