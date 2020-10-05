package org.example.service.impl;

import org.example.entity.FmResource;
import org.example.repository.FmResourceRepository;
import org.example.service.FmResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by kelly on 5/10/2020.
 */
@Service
public class FmResourceServiceImpl implements FmResourceService {

    @Autowired
    private FmResourceRepository fmResourceRepository;

    @Override
    public List<FmResource> findAll() {
        return fmResourceRepository.findAll();
    }
}
