package org.example.service.impl;
import cn.hutool.core.collection.CollUtil;
import org.example.entity.Resource;
import org.example.entity.User;
import org.example.repository.RoleResourceRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.RedisService;
import org.example.service.UserCacheService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/*
 * Created by kelly on 26/10/2020.
 */



/**
 * UmsAdminCacheService实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleResourceRepository roleResourceRepository;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delAdmin(Long userId) {
        User admin = userService.getItem(userId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        List<Long> userIdList = userRoleRepository.getUserIdList(roleId);
        if (CollUtil.isNotEmpty(userIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = userIdList.stream().map(userId -> keyPrefix + userId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {

        List<Long> resourceList = roleResourceRepository.getResourcesByRoleIds(roleIds);
        if (CollUtil.isNotEmpty(resourceList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = resourceList.stream().map(resourceId -> keyPrefix + resourceId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> userIdList = userRoleRepository.getUserIdList(resourceId);
        if (CollUtil.isNotEmpty(userIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = userIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public User getUser(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (User) redisService.get(key);
    }

    @Override
    public void setUser(User user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getUsername();
        redisService.set(key, user, REDIS_EXPIRE);
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<Resource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<Resource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }
}
