package org.example.jdbcexamples.dox;

// 引入 Lombok 注解以简化代码
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

/**
 * 地址类，用于表示用户的地址信息。
 */
@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@NoArgsConstructor // 生成无参构造函数
@AllArgsConstructor // 生成全参构造函数
@Builder // 支持构建者模式，方便对象创建
public class Address {

    @Id // 标识该字段为唯一标识符
    @CreatedBy // 表示创建者信息，通常由框架自动填充
    private String id; // 地址的唯一标识符

    private String detail; // 地址详细信息，如街道、门牌号等

    private String userId; // 关联的用户ID，用于标识地址属于哪个用户

    @ReadOnlyProperty // 标识该字段为只读，通常在数据库操作时不会被修改
    private LocalDateTime createTime; // 地址创建时间

    @ReadOnlyProperty // 标识该字段为只读
    private LocalDateTime updateTime; // 地址最后更新时间
}
