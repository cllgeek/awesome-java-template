package com.geekjc.redis.modules.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.geekjc.redis.modules.system.entity.SysLog;
import org.springframework.stereotype.Component;

/**
 * @author ll
 * @date 2020年02月05日 10:45 AM
 * 系统管理 - 日志表 Mapper 接口
 */
@Component
public interface LogMapper extends BaseMapper<SysLog> {

}
