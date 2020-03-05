package com.geekjc.server.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geekjc.server.modules.system.dto.input.UserQueryPara;
import com.geekjc.server.modules.system.dto.model.UserInfoVO;
import com.geekjc.server.modules.system.entity.User;

/**
 *
 * @author ll
 * @date 2020/2/27 8:49 PM
 *
 * 系统管理-用户基础信息表 服务类
 */
public interface IUserService extends IService<User> {

    /**
     * 系统管理-用户基础信息表列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<User> page, UserQueryPara filter);

    /**
     * 保存系统管理-用户基础信息表
     *
     * @param input :
     * @return: java.lang.Integer
     */
    boolean save(User input);

    /**
     * 通过token获取用户信息
     *
     * @param token:
     * @return: com.geekjc.server.modules.system.dto.model.UserInfoVO
     */
    UserInfoVO getCurrentUserInfo(String token);
}
