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
@TableName("table_reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复评论id
     */
    @TableId(value = "rid", type = IdType.ASSIGN_ID)
    private Long rid;

    /**
     * 帖子ID
     */
    private Long tid;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复用户id
     */
    private Long fromUid;

    /**
     * 回复时间
     */
    private LocalDateTime createTimeReply;


}
