package com.tx.service.impl;

import com.tx.pojo.Reply;
import com.tx.dao.ReplyDao;
import com.tx.service.IReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyDao, Reply> implements IReplyService {

}
