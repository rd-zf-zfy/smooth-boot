package org.smooth.study.swagger.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 通用API接口返回
 * </p>
 *
 * @author zhangfei
 * @date Created in 2021-06-11 11:30
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(value = "通用PI接口返回", description = "接口返回结果类")
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811406L;
    /**
     * 通用返回状态
     */
    @ApiModelProperty(value = "通用返回状态", required = true)
    private Integer code;
    /**
     * 通用返回信息
     */
    @ApiModelProperty(value = "通用返回信息", required = true)
    private String msg;
    /**
     * 通用返回数据
     */
    @ApiModelProperty(value = "通用返回数据", required = true)
    private T data;
}
