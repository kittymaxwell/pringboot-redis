package com.rambo.plugin.module.advise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.rambo.plugin.module.advise.entity.BaseEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PluginAdvise对象", description="")
public class PluginAdvise extends BaseEntity<PluginAdvise> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "意见反馈内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "反馈者联系方式")
    @TableField("contact")
    private String contact;

    @ApiModelProperty(value = "反馈者IP")
    @TableField("ip")
    private String ip;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
