package com.geekjc.server.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ll
 * @date 2020年02月10日 8:39 PM
 *
 *  <p> 全局上下文工具类配置 </p>
 *
 * @description : 解决静态方法中mapper的调用
 */
@Slf4j
public class ApplicationContextUtil {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext = ac;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据Class类型在IOC容器中获取对象
     * @param clazz Class类型
     * @return 对象
     */
    public static <T> List<T> getBeanByType(Class<T> clazz) {
        List<T> list = new ArrayList<T>();

        /* 获取接口的所有实例名 */
        String[] beanNames = applicationContext.getBeanNamesForType(clazz); // 返回对于指定类型Bean（包括子类）的所有名字

        log.debug("getBeanByType beanNames :" + beanNames == null ? "" : Arrays.toString(beanNames));

        if(beanNames == null || beanNames.length == 0) {
            return list;
        }
        T t = null;
        for(String beanName : beanNames) {
            t = (T)applicationContext.getBean(beanName);
            list.add(t);
        }
        return list;
    }
}
