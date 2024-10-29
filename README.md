# springboot-examples
# Overview
web系统框架，由东北林业大学软件工程王波老师主讲，第五学期的一门课
<br/>
基于springboot 后端框架设计和实现技术
项目包括以下模块
- jdbc-examples
- springmvc-examples
具体技术内容：
- 基于spring-data-jdbc持久化框架
- MySQL关系型和非关系型混合开发技术
- springmvc框架分层架构
- springdoc-openapi框架的API接口文档技术
# Environment & Tools
- IDEA
- Maven
- springboot3.3.4
- Git
- Mysql
- Redis
# Resources 
```xml
spring:
  datasource:
    url: 'jdbc:mysql://ip地址:端口/2022212829?createDatabaseIfNotExist=true'
    username: 用户名
    password: 密码
    hikari:
      maximum-pool-size: 1
  sql:
    init:
      mode: always
#      自动读取生成数据表
```
# Update
- 为什么java开发的时候不直接导入所有的包
  - 导入所有包会导致编译时间边长 无法分别同名类属于那是一个包 失去了打包的意义 可读性差 结构冗余
- spring-mvc
- 使用 save 方法可以插入或更新数据，但它在更新时会根据实体的主键进行判断，而 @Modifying 注解则用于在自定义的查询中明确表示这是一个更新操作。通过 @Modifying，你可以执行更复杂的更新逻辑，例如批量更新或基于条件的更新，这在某些情况下比简单的 save 方法更灵活