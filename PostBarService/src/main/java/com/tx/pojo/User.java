package com.tx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("table_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "uid", type = IdType.ASSIGN_ID)
    private Long uid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 用户账号
     */
    private Integer userAccount;

    /**
     * 用户密码
     */
    private String userPasswd;

    /**
     * 用户创建时间
     */
    private LocalDateTime createTime;


}
