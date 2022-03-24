package com.example.api.check.mapper;


import com.example.api.check.vo.CheckVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CheckMapper {
	void insertCheck(CheckVo checkVo);
	List<CheckVo> selectCheckList(CheckVo checkVo);
}
