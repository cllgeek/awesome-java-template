package com.geekjc.server.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.geekjc.server.modules.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ll
 * @date 2020年02月29日 8:34 PM
 *
 * 系统管理 - 日志表
 */
@Data
@ApiModel(value = "系统管理 - 日志表")
@TableName("t_sys_log")
public class SysLog extends BaseEntity<SysLog> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称")
    @TableField("name")
    private String name;
    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址")
    @TableField("url")
    private String url;
    /**
     * 访问人IP
     */
    @ApiModelProperty(value = "访问人IP")
    @TableField("ip")
    private String ip;
    /**
     * 访问人ID
     */
    @ApiModelProperty(value = "访问人ID")
    @TableField("user_id")
    private Integer userId;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;
    /**
     * 接口执行时间
     */
    @ApiModelProperty(value = "接口执行时间")
    @TableField("execute_time")
    private String executeTime;

    @ApiModelProperty(value = "访问人名字")
    @TableField(exist = false)
    private String username;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
