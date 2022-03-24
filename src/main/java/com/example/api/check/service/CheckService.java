package com.example.api.check.service;

import com.example.api.check.vo.CheckVo;

import java.util.List;

public interface CheckService {
    void insertCheck(CheckVo checkVo);
    List<CheckVo> selectCheckList(CheckVo checkVo);
}
