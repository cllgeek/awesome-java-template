package com.geekjc.server.modules.system.dto.input;

import com.geekjc.server.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ll
 * @date 2020年02月11日 8:39 PM
 *
 * 系统管理-用户基础信息表查询参数
 */
@Data
@ApiModel(description = "系统管理-用户基础信息表查询参数")
public class UserQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "账号 - 修改个人信息使用")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "QQ第三方登录授权认证成功后的openID")
    private String openId;

    @ApiModelProperty(value = "QQ第三方登录授权认证成功后的token")
    private String accessToken;

}
