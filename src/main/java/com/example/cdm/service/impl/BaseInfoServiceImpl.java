package com.example.cdm.service.impl;

import com.example.cdm.dao.BaseInfoMapper;
import com.example.cdm.domain.BaseInfo;
import com.example.cdm.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Autowired
    private BaseInfoMapper baseInfoMapper;


    @Override
    public BaseInfo selectByPrimaryKey(Long id) {
        return baseInfoMapper.selectByPrimaryKey(id);
    }


}
