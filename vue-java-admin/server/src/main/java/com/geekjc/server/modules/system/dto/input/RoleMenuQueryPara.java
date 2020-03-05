package com.geekjc.server.modules.system.dto.input;

import com.geekjc.server.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ll
 * @date 2020年02月21日 11:05 AM
 *
 * 系统管理 - 角色-菜单关联表 查询参数
 */
@Data
@ApiModel(description = "系统管理- 角色-菜单关联表 查询查询参数")
public class RoleMenuQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;
    @ApiModelProperty(value = "菜单ids")
    private String menuIds;
}
