package com.geekjc.redis.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.geekjc.redis.utils.DateTimeUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

/**
 * @author ll
 * @date 2020年02月04日 8:41 PM
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    /**
     * 创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LOG.info(" -------------------- start insert fill ...  --------------------");
        if (metaObject.hasGetter("gmtCreate") && metaObject.hasGetter("gmtModified")) {
            setFieldValByName("gmtCreate", new Date(), metaObject);
            setFieldValByName("gmtModified", new Date(), metaObject);
        }

        // 日志输出 ================================================================================================
        Date gmtCreate = (Date) this.getFieldValByName("gmtCreate", metaObject);
        Date gmtModified = (Date) this.getFieldValByName("gmtModified", metaObject);
        if (gmtCreate != null && gmtModified != null) {
            try {
                LOG.info("MyBatisPlus自动填充处理 - gmtCreate:{} gmtModified:{}", DateTimeUtils.dateToDateTimeString(gmtCreate), DateTimeUtils.dateToDateTimeString(gmtModified));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 最后一次更新时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOG.info(" -------------------- start update fill ...  --------------------");
        if (metaObject.hasGetter("et.gmtModified")) {
            setFieldValByName("gmtModified", new Date(), metaObject);
        }

        // 日志输出 ================================================================================================
        Date gmtModified = (Date) this.getFieldValByName("gmtModified", metaObject);
        if (gmtModified != null) {
            try {
                LOG.info("MyBatisPlus自动填充处理 - gmtModified:{}", DateTimeUtils.dateToDateTimeString(gmtModified));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
