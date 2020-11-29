package com.rambo.plugin.module.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rambo.plugin.common.R;
import com.rambo.plugin.module.dto.PluginAdviseDTO;
import com.rambo.plugin.module.service.PluginAdviseService;
import com.rambo.plugin.module.vo.PluginAdviseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/advise/plugin-advise")
@Api("PluginAdviseController相关的api")
public class PluginAdviseController {

    protected static Logger logger = LoggerFactory.getLogger(PluginAdviseController.class);

    @Resource
    private PluginAdviseService pluginAdviseService;

    @PostMapping("/v1/saveOrUpdate")
    @ApiOperation(value="保持或更新")
    public R saveOrUpdate(@Validated @RequestBody PluginAdviseDTO pluginAdviseDTO) {
        pluginAdviseService.saveOrUpdate(pluginAdviseDTO);
        return R.SUCCESS();
    }

    @GetMapping("/v1/findone/{id}")
    @ApiOperation(value="根据ID查询详情")
    @ApiImplicitParam(name = "id", value = "城市ID",  paramType = "path", required = true)
    public R<PluginAdviseVO> findById(@PathVariable BigInteger id) {
        PluginAdviseVO obj = pluginAdviseService.findById(id);
        return R.SUCCESS(obj);
    }


    @DeleteMapping("/v1/delete/{id}")
    @ApiOperation(value="根据ID删除")
    @ApiImplicitParam(name = "id", value = "pluginAdviseID",  paramType = "path", required = true)
    public R delete(@PathVariable(value = "id") BigInteger id) {
        pluginAdviseService.delete(id);
        return R.SUCCESS();
    }


    @PostMapping("/v1/page")
    @ApiOperation(value="分页查询")
    public R<IPage<PluginAdviseVO>> selectPage(@RequestBody Page page) {

        IPage<PluginAdviseVO> data = pluginAdviseService.selectPage(page);
        return R.SUCCESS(data);
    }
}

