package com.rambo.plugin.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rambo.plugin.module.dto.PluginAdviseDTO;
import com.rambo.plugin.module.entity.PluginAdvise;
import com.rambo.plugin.module.mapper.PluginAdviseMapper;
import com.rambo.plugin.module.service.PluginAdviseService;
import com.rambo.plugin.module.vo.PluginAdviseVO;
import com.rambo.plugin.utils.BeanUtil;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
@Service
public class PluginAdviseServiceImpl extends ServiceImpl<PluginAdviseMapper, PluginAdvise> implements PluginAdviseService {

    @Override
    public void saveOrUpdate(PluginAdviseDTO pluginAdviseDTO) {
        PluginAdvise pluginAdvise = new PluginAdvise();
        BeanUtil.copyFields(pluginAdviseDTO,pluginAdvise,null);
        this.saveOrUpdate(pluginAdvise);
    }

    @Override
    public PluginAdviseVO findById(BigInteger id) {
        PluginAdvise pluginAdvise = this.getById(id);
        PluginAdviseVO pluginAdviseVO = new PluginAdviseVO();
        BeanUtil.copyFields(pluginAdvise,pluginAdviseVO,null);
        return pluginAdviseVO;
    }

    @Override
    public void delete(BigInteger id) {
        this.removeById(id);
    }

    @Override
    public IPage<PluginAdviseVO> selectPage(Page page) {
        IPage<PluginAdviseVO> adviseVoPage = new Page<>();
        QueryWrapper<PluginAdvise> wrapper = new QueryWrapper<>();
        IPage<PluginAdvise> advisePage = this.page(page,wrapper);
        BeanUtil.copyFields(advisePage,adviseVoPage,null);
        return adviseVoPage;
    }
}
