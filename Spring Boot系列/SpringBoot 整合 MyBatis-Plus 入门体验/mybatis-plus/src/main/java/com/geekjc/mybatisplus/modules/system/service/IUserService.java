package com.geekjc.mybatisplus.modules.system.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.geekjc.mybatisplus.modules.system.entity.User;

import java.util.List;

/**
 * 
 * @author ll
 * @date 2020/2/4 6:17 PM
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
    void listPage(Page<User> page, User filter);

    /**
     * 系统管理-用户基础信息表列表
     *
     * @param filter
     * @return
     */
    List<User> list(User filter);

    /**
     * 保存系统管理-用户基础信息表
     *
     * @param input:
     * @return: java.lang.Integer
     */
    Integer save(User input);

}
