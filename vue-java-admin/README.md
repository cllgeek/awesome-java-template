### 一、前言

最近整合`Spring Boot`+`Spring Security`+`JWT`+`Vue` 完成了一套前后端分离的基础项目，这里把它开源出来分享给有需要的小伙伴们

功能很简单，单点登录，前后端动态权限配置，前端权限精确到 `按钮` 级别，后端权限精确到 `url` 上，剩下的就是一些关联表的增删改查，例如：用户管理，角色管理，菜单管理，系统日志等...

###### Spring Security 入门系列教程：

1. [SpringBoot 集成 Spring Security 入门体验（一）](https://www.geekjc.com/post/5e3cf9a812576e175007747b)
2. [Spring Security 自定义登录认证（二）](https://www.geekjc.com/post/5e3d2ca897bc84185b187489)
3. [Spring Security 动态 url 权限控制（三）](https://www.geekjc.com/post/5e3d2f8b75453c18b049edc7)
4. [Spring Security 整合 JWT（四）](https://www.geekjc.com/post/5e3d5b6b4277d8194929cae5)

###### 项目部署

[docker-compose 部署项目到服务器](https://www.geekjc.com/post/5e60caf027ec223940c37529)

###### 开发环境：

1. JDK 1.8
2. IDEA 2019.2
3. MySQL 5.7
4. Node.js 10.15.3

###### 项目使用技术栈：

前端：Vue + Axios
后端：Spring Boot 、 MyBatis-Plus
权限：Spring Security
.......

### 二、页面截图

![在这里插入图片描述](./demo.png)

---
