package com.geekjc.server.modules.system.dto.model;

import com.google.common.collect.Sets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author ll
 * @date 2020年02月27日 8:54 PM
 */

@Data
@ApiModel(description = "用户信息")
public class UserInfoVO implements Serializable {

    private Integer id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "用户账号")
    private String username;

    private String nickName;

    /**
     * 性别：0是男 1是女
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private String flag;

    private Set<String> roles = Sets.newHashSet();

    private Set<MenuVO> menus = Sets.newHashSet();

    private Set<ButtonVO> buttons = Sets.newHashSet();
}
