package cn.xiaowenjie.jpa;

import cn.xiaowenjie.beans.BaseEntity;
import cn.xiaowenjie.consts.ObjType;
import cn.xiaowenjie.daos.BlogDao;
import cn.xiaowenjie.jms.JMSType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 对象创建事件
 */
@Component
@Slf4j
public class JMSObjectComsumer {

    @JmsListener(destination = JMSType.CREATE)
    public void objectCreatePost(@Payload BaseEntity obj) {
        log.info("create: {}", obj);

        updateCounts(obj);
    }

    @JmsListener(destination = JMSType.DELETE)
    public void deleteObjectPost(@Payload BaseEntity obj) {
        log.info("delete : {}", obj);

        updateCounts(obj);
    }

    /**
     *  现在删除对象的时候，更新各种数据（如收藏数）
     * @param obj
     */
    private void updateCounts(@Payload BaseEntity obj) {
        try {
            // 不用担心冲掉
            JPAThreadLocal.setBackground(true);

        } finally {
            JPAThreadLocal.setBackground(false);
        }
    }



    @Autowired
    BlogDao blogDao;

    PagingAndSortingRepository<? extends BaseEntity, Long> findDao(int objType) {
        if (objType == ObjType.BLOG) {
            return blogDao;
        }

        throw new IllegalArgumentException("object type error: " + objType);
    }
}
