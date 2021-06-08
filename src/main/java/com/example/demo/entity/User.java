package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author cc
 * @date 2021/5/20 - 16:18
 */
@Data // 代替手动增加get、set方法
public class User {
    // 主键策略
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 自动填充数据
     * DEFAULT    默认不处理
     * INSERT    插入填充字段
     * UPDATE    更新填充字段
     * INSERT_UPDATE    插入和更新填充字段
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; //create_time

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; //update_time

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version; // 注意修改表字段，添加注解：@Version

    @TableLogic // 表示逻辑删除
    /**
     * 使用逻辑删除注解@TableLogic
     * 1.调用deleteById()方法
     * 但是底层：UPDATE user SET deleted=1 WHERE id=? AND deleted=0
     * 2.调用selectList()方法
     * 但是底层：SELECT * FROM user WHERE deleted=0
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted; // 逻辑删除


}
