package org.smooth.study.swagger.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author zhangfei
 * @date Created in 2021-06-11
 */
// 这里 同时使用了@Data与@Builder ，会将类的无参构造方法覆盖掉，需要重写无参构造方法，或者使用@NoArgsConstructor，防止与lombok的注解冲突。
// 重写无参构造方法需在无参构造方法上面加入@Tolerate注解。
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// swagger 实体类描述 ,可不写
@ApiModel(value = "用户实体", description = "User Entity")
public class User implements Serializable {
    private static final long serialVersionUID = 5057954049311281251L;
    /**
     * 主键id
     */
    // swagger 实体类成员描述 ,可不写
    @ApiModelProperty(value = "主键id", required = true)
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    /**
     * 工作岗位
     */
    @ApiModelProperty(value = "工作岗位", required = true)
    private String job;

}
