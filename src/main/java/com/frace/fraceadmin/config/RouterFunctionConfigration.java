package com.frace.fraceadmin.config;

import com.frace.fraceadmin.domain.User;
import com.frace.fraceadmin.repository.UserRepository;
import com.sun.deploy.nativesandbox.comm.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由器函数
 * 配置
 */
@Configuration
public class RouterFunctionConfigration {

    /**
     * Servlet接口
     * 请求接口：ServletRequest或者HttpServletRequest
     * 响应接口：ServletResponse或者HttpServletResponse
     * Spring 5.0重新定义了服务请求接口和响应接口
     * 请求接口:ServletRequest
     * 响应接口:ServletResponse
     * 既可以支持Servlet规范，也可以自定义，比如Netty（Web Server）
     * 本例中：
     * 定义get请求，返回所有用户对象Url：/person/find/all
     * Flux 是0-N个对象集合
     * Mono 是0-1个对象集合
     * Reactive 中的Flux 或者mono 是 是异步处理（非阻塞）
     * 集合对象基本上异步处理的（阻塞）
     *
     *
     */
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    return  ServerResponse.ok().body(
                            Flux.fromIterable(userRepository.findAll())
                            ,User.class);
                });
    }
}
