package com.geekjc.spring_security_04.modules.system.dto.input;

import com.geekjc.spring_security_04.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理 - 用户角色关联表 查询参数
 *
 * @author: ll
 * @description:
 * @date: 2019-08-20
 */
@Data
@ApiModel(description = "系统管理 - 用户角色关联表 查询参数")
public class UserRoleQueryPara extends BasePageQuery{
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;
    @ApiModelProperty(value = "用户ids")
    private String userIds;
}
