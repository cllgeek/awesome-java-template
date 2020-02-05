package com.geekjc.redis.modules.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.geekjc.redis.modules.system.entity.SysLog;
import com.geekjc.redis.modules.system.mapper.LogMapper;
import com.geekjc.redis.modules.system.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ll
 * @date 2020年02月05日 10:51 AM
 * 系统管理 - 日志表 服务实现类
 */
@Service
@Transactional
public class LogServiceImpl extends ServiceImpl<LogMapper, SysLog> implements ILogService {

    @Autowired
    LogMapper logMapper;

}
