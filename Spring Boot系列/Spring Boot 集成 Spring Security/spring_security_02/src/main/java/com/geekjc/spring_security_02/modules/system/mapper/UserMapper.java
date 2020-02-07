package com.geekjc.spring_security_02.modules.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.geekjc.spring_security_02.modules.system.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p> 系统管理-用户基础信息表 Mapper 接口 </p>
 *
 * @author: ll
 * @date: 2019-08-19
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
