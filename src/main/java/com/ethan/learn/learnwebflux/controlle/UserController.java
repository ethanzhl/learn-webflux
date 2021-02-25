package com.ethan.learn.learnwebflux.controlle;

import com.ethan.learn.learnwebflux.entity.UserDto;
import com.ethan.learn.learnwebflux.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author ethan
 * @date 2021/2/25 9:01 上午
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public Mono<Long> addUser(@RequestBody UserDto userDto) {
        return Mono.create(monoSink -> monoSink.success(userService.addUser(userDto)));
    }

    @GetMapping("/user/{id}")
    public Mono<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.getUser(id);
        return Mono.justOrEmpty(userDto);
    }

    @GetMapping("/users")
    public Flux<UserDto> getAllUser() {
        return Flux.fromIterable(userService.getAllUser());
    }
}
