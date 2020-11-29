package com.rambo.plugin.module.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Rambo
 * @since 2020-11-28
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@ApiModel(value="PluginAdviseVO对象", description="")
public class PluginAdviseVO {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private BigInteger id;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建者")
    private String createUser;

    @ApiModelProperty(value = "更新者")
    private String updateUser;

    @ApiModelProperty(value = "删除标志 0未删除 1已删除")
    private Integer deleteFlag;

    @ApiModelProperty(value = "意见反馈内容")
    private String content;

    @ApiModelProperty(value = "反馈者联系方式")
    private String contact;

    @ApiModelProperty(value = "反馈者IP")
    private String ip;


}
