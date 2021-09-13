#### OpenSource_Startup 后端项目
技术栈包含 Spring Boot、 Mybatis-Plus、 Spring Security、Mysql、Redis、Swagger2等
##### 一、数据库配置
  ###### 创建数据库
  - Mysql 5.0以上
  - 手动创建startup_backend空库
  - 运行startup_backend.sql
  ###### 配置数据源
  ####### 开发环境
  - 打开resources/config/application-dev.yml
  - 配置spring:datasource:druid
  -     datasource:
         druid:
          db-type: com.alibaba.druid.pool.DruidDataSource
          driverClassName: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
          url: jdbc:log4jdbc:mysql://localhost:3306/startup_backend?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
          username: root
          password: root
  ####### 生产环境
  - 打开resources/config/application-prod.yml
  - 配置spring:datasource:druid 
    -     datasource:
           druid:
            db-type: com.alibaba.druid.pool.DruidDataSource
            driverClassName: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
            url: jdbc:log4jdbc:mysql://localhost:3306/startup_backend?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
            username: root
            password: root
  
##### 二、邮箱配置
  - 打开resources/config/application.yml
  - 根据具体邮箱进行修改
  -     mail:
          email: xxxx@163.com
          host: smtp.163.com
          port: 465
          username: xxxx
          # 授权密码， 非邮箱密码，授权码是用于登录第三方邮件客户端的专用密码。
          password: xxxxx
 
 