package org.example.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.example.entity.AdminUser;
import org.example.entity.FmRole;
import org.example.entity.Resource;
import org.example.entity.User;
import org.example.repository.ResourceRepository;
import org.example.repository.UserRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by kelly on 6/10/2020.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceRepository resourceRepository;
//    @Autowired
//    private UmsAdminLoginLogMapper loginLogMapper;
//    @Autowired
//    private UmsAdminCacheService adminCacheService;

    @Override
    public User getUserByUsername(String username) {
//        User user = adminCacheService.getAdmin(username);
//        if(user!=null) return  admin;
//        UmsAdminExample example = new UmsAdminExample();
//        example.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userRepository.findUsersByName(username);
        if (userList != null && userList.size() > 0) {
            User user = userList.get(0);
//            adminCacheService.setAdmin(admin);
            return user;
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public AdminUser getItem(Long id) {
        return null;
    }

    @Override
    public List<AdminUser> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int update(Long id, AdminUser admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<FmRole> getRoleList(Long adminId) {
        return null;
    }

    @Override
    public List<Resource> getResourceList(Long userId) {
//        List<Resource> resourceList = adminCacheService.getResourceList(adminId);
//        if(CollUtil.isNotEmpty(resourceList)){
//            return  resourceList;
//        }
        List<Resource> resourceList = resourceRepository.getResourceListByUserId(userId);
        if(CollUtil.isNotEmpty(resourceList)){
//            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        User user = getUserByUsername(username);
        if (user != null) {
            List<Resource> resourceList = getResourceList(user.getId());
            return new AdminUser(user,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
