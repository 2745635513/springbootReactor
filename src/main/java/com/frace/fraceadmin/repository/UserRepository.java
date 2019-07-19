package com.frace.fraceadmin.repository;

import com.frace.fraceadmin.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式-》map
     */
    private final ConcurrentMap<Integer, User> userReposity = new ConcurrentHashMap<>();

    /**
     * 定义一个自增长
     */
    private final static AtomicInteger idGenerator =
            new AtomicInteger();

    /**
     * 保存用户对象
     *
     * @param user {@link User}对象
     * @return 成功true，失败false
     */
    public boolean save(User user) {
        //id从1开始自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return userReposity.put(id, user) == null;
    }

    /**
     * 返回所有的用户
     * @return
     */
    public Collection<User> findAll(){
        return userReposity.values();
    }
}
