package com.geekjc.mybatisplus.modules.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.geekjc.mybatisplus.modules.system.entity.User;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月04日 5:17 PM
 * 系统管理-用户基础信息表 Mapper 接口
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<User> selectUsers(Pagination page, @Param("filter") User filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<User> selectUsers(@Param("filter") User filter);
}
