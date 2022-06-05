package com.tx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("table_topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    /**
     * 帖子类型: 1(学习) 2（闲聊）
     */
    private Integer topicType;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 发帖用户id
     */
    private Long fromUid;

    /**
     * 发帖时间
     */
    private LocalDateTime createTimeTopic;

    /**
     * 发帖用户名
     */
    private String fromName;


}
