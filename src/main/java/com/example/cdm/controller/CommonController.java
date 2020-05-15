package com.example.cdm.controller;


import com.example.cdm.domain.BaseInfo;
import com.example.cdm.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("common")
public class CommonController {

    @Autowired
    private BaseInfoService BaseInfoServiceImpl;

    @GetMapping("println/{id}")
    public void println(@PathVariable("id") Long id ){
        BaseInfo baseInfo  = BaseInfoServiceImpl.selectByPrimaryKey(id);
        System.out.println( baseInfo.getName() + " " + baseInfo.getRemark() );
    }


}
