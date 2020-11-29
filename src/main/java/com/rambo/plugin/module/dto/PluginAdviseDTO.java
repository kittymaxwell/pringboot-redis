package com.rambo.plugin.module.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

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
@ApiModel(value="PluginAdviseDTO对象", description="")
public class PluginAdviseDTO {

    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "主键")
    private BigInteger id;

    @ApiModelProperty(value = "意见反馈内容")
    @Length(max = 255,message = "意见反馈内容不能超过255个字符")
    @NotNull(message = "意见反馈内容不能为空")
    private String content;

    @ApiModelProperty(value = "反馈者联系方式")
    @NotNull(message = "反馈者联系方式不能为空")
    @Length(max = 30,message = "反馈者联系方式不能超过30个字符")
    private String contact;

    @ApiModelProperty(value = "反馈者IP")
    private String ip;


}
