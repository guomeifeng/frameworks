package org.example.config;

import org.example.component.DynamicSecurityService;
import org.example.entity.FmResource;
import org.example.service.AdminUserService;
import org.example.service.FmResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
 * Created by kelly on 5/10/2020.
 */
public class SpringHibernateSecurityConfig extends SecurityConfig{

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private FmResourceService fmResourceService;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> adminUserService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService(){
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadConfigAttibutes() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<FmResource> resourceList = fmResourceService.findAll();
                for (FmResource resource : resourceList){
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
