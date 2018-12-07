package com.admin.service.impl;

import com.admin.mapper.AdminMapper;
import com.admin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lisheng
 * @version TestService, v0.1 2018/11/3 17:30
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    AdminMapper mapper;

    @Override
    public Long count(){
        return mapper.count();
    }
}
