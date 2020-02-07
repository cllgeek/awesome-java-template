package com.geekjc.spring_security_03.modules.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.geekjc.spring_security_03.modules.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>  系统管理 - 角色-权限关联表  </p>
 *
 * @author: zhengqing
 * @date: 2019-08-20
 */
@Data
@ApiModel(description = "系统管理 - 角色-权限关联表 ")
@TableName("t_sys_role_permission")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    private Integer roleId;
    /**
     * 权限ID
     */
    @ApiModelProperty(value = "权限ID")
    @TableField("permission_id")
    private Integer permissionId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
