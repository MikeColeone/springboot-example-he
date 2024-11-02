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
- 出现java.lang.IllegalStatsException
  - 这个 `java.lang.IllegalStateException` 错误通常表明在加载 Spring `ApplicationContext` 时发生了问题。常见原因可能是以下几种：

1. **缺少必要的配置或依赖**：
  - 确保 `application.properties` 或 `application.yml` 文件正确配置了数据库连接信息（如 URL、用户名、密码等），尤其是在使用 Spring Data JPA 测试 `@Repository` 类时。
  - 检查 `pom.xml` 或 `build.gradle` 中是否包含 Spring Boot Starter、JPA、H2 或其他必要的数据库依赖。

2. **数据库未配置**：
  - 如果你的测试涉及数据库操作，确保配置了一个嵌入式数据库（例如 H2）或在测试环境中使用了一个测试数据库。
  - 可以通过 `@SpringBootTest` 或 `@DataJpaTest` 注解的 `properties` 属性为测试数据库配置临时属性。

3. **`@SpringBootTest` 注解的类路径配置错误**：
  - `@SpringBootTest` 默认会扫描和加载整个应用上下文。确保 `BackendExamplesApplication` 是 Spring Boot 主启动类，或检查它的包路径是否与测试类一致。

4. **缺少相关 Bean 或 Bean 定义错误**：
  - 检查你的配置类和主类 `BackendExamplesApplication` 是否声明了所有所需的 Bean。例如，`UserRepositoryTest` 所需的 `UserRepository` 应该在上下文中被正确注册。

5. **其他配置冲突**：
  - 检查是否有重复的 `ContextCustomizer`（如 `DuplicateJsonObjectContextCustomizer` 提示），可能是由于在项目中重复引入了特定的测试类或上下文配置。

如果问题仍然存在，请提供完整的错误信息，这样我可以进一步协助排查。
- 什么时候使用Map.of 什么时候使用put
  - Map.of适用于不可变的映射对象 put适用于可变对象
- 为什么java开发的时候不直接导入所有的包
  - 导入所有包会导致编译时间边长 无法分别同名类属于那是一个包 失去了打包的意义 可读性差 结构冗余
- spring-mvc
- 使用 save 方法可以插入或更新数据，但它在更新时会根据实体的主键进行判断，而 @Modifying 注解则用于在自定义的查询中明确表示这是一个更新操作。通过 @Modifying，你可以执行更复杂的更新逻辑，例如批量更新或基于条件的更新，这在某些情况下比简单的 save 方法更灵活