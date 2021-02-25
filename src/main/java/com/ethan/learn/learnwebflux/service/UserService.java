package com.ethan.learn.learnwebflux.service;

import com.ethan.learn.learnwebflux.entity.UserDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ethan
 * @date 2021/2/25 9:06 上午
 */
@Service
public class UserService {

    private final ConcurrentHashMap<Long, UserDto> users = new ConcurrentHashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0L);

    public Long addUser(UserDto userDto) {
        long id = ID_GENERATOR.incrementAndGet();
        users.put(id, userDto);
        return id;
    }

    public UserDto getUser(Long id) {
        return users.get(id);
    }

    public Collection<UserDto> getAllUser() {
        return users.values();
    }
}
