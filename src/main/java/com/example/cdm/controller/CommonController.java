package com.example.cdm.controller;


import com.example.cdm.config.idwork.IdWorker;
import com.example.cdm.config.idwork.Sid;
import com.example.cdm.config.swagger.ApiVersion;
import com.example.cdm.config.swagger.ApiVersionConstant;
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
@Api(value = "公共接口层",description = "公共接口层")
public class CommonController {

    @Autowired
    private BaseInfoService BaseInfoServiceImpl;

    @Autowired
    private Sid sid ;

    @GetMapping("println/{id}")
    @ApiOperation(value="根据用户id查询用户信息", notes="根据用户id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    })
    @ApiVersion(group = ApiVersionConstant.VERSION_1_01)
    public void println(@PathVariable("id") Long id ){
        BaseInfo baseInfo  = BaseInfoServiceImpl.selectByPrimaryKey(id);
        System.out.println( baseInfo.getName() + " " + baseInfo.getRemark() );
    }

    @GetMapping("idworker")
    @ApiVersion(group = ApiVersionConstant.VERSION_1_01)
    public void idworker(){
        System.out.println( "idWorker:" + sid.nextLong() );
    }


}
