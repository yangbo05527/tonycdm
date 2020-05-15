package com.example.cdm.controller;


import com.example.cdm.config.ApiVersion;
import com.example.cdm.config.ApiVersionConstant;
import com.example.cdm.domain.BaseInfo;
import com.example.cdm.service.BaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("common")
@Api(value = "简书-演示",description = "用来演示Swagger的一些注解")
public class CommonController {

    @Autowired
    private BaseInfoService BaseInfoServiceImpl;

    @GetMapping("println/{id}")
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    })
    @ApiVersion(group = ApiVersionConstant.VERSION_1_01)
    public void println(@PathVariable("id") Long id ){
        BaseInfo baseInfo  = BaseInfoServiceImpl.selectByPrimaryKey(id);
        System.out.println( baseInfo.getName() + " " + baseInfo.getRemark() );
    }


}
