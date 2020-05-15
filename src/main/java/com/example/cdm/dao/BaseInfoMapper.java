package com.example.cdm.dao;

import com.example.cdm.domain.BaseInfo;

public interface BaseInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    BaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
}