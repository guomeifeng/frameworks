package org.example.config;

/*
 * Created by kelly on 5/10/2020.
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties("secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

}
