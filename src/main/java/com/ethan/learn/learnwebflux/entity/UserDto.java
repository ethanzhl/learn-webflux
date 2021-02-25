package com.ethan.learn.learnwebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ethan
 * @date 2021/2/25 9:15 上午
 */
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private int age;
    private String sex;
}
