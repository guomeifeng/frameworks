package org.example.service.impl;

import org.example.entity.Resource;
import org.example.repository.ResourceRepository;
import org.example.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by kelly on 5/10/2020.
 */
@Service
public class FmResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}
