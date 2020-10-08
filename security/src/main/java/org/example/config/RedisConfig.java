package org.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 * Created by Kelly Guo on 2020/10/7.
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
