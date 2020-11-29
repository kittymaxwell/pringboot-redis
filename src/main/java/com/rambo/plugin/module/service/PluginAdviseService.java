package com.rambo.plugin.module.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rambo.plugin.module.dto.PluginAdviseDTO;
import com.rambo.plugin.module.entity.PluginAdvise;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rambo.plugin.module.vo.PluginAdviseVO;

import java.math.BigInteger;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
public interface PluginAdviseService extends IService<PluginAdvise> {

    /**
     * 保持或更新
     * @param pluginAdviseDTO
     */
    void saveOrUpdate(PluginAdviseDTO pluginAdviseDTO);

    /**
     * 根据ID查询详情
     * @param id
     * @return
     */
    PluginAdviseVO findById(BigInteger id);

    /**
     * 根据ID删除
     * @param id
     */
    void delete(BigInteger id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<PluginAdviseVO> selectPage(Page page);
}
