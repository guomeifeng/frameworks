package org.example.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/*
 * Created by kelly on 5/10/2020.
 */

public interface DynamicSecurityService {
    Map<String, ConfigAttribute> loadConfigAttibutes();
}
