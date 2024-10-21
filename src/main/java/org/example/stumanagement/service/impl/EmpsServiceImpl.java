package org.example.stumanagement.service.impl;

import jakarta.annotation.Resource;
import org.example.stumanagement.mapper.EmpsMapper;
import org.example.stumanagement.pojo.Emp;
import org.example.stumanagement.service.EmpsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpsServiceImpl implements EmpsService {

    @Resource
    private EmpsMapper empsMapper;

    @Override
    public List<Emp> getEmps() {
        return empsMapper.selectEmps();
    }
}
