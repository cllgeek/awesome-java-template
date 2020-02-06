package com.geekjc.crontab;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author ll
 * @date 2020年02月06日 4:58 PM
 */
@Mapper
@Component
public interface CronMapper {

    @Select("select cron from cron limit 1")
    String getCron();
}
