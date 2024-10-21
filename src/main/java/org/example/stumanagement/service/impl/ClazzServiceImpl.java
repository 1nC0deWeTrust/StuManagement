package org.example.stumanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.stumanagement.mapper.ClazzMapper;
import org.example.stumanagement.pojo.Clazz;
import org.example.stumanagement.pojo.PageResult;
import org.example.stumanagement.service.ClazzService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> queryClazzs(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Clazz> clazzList = clazzMapper.selectClazzs(name, begin, end);

        PageResult<Clazz> pageResult = new PageResult<>();
        pageResult.setTotal((int) new PageInfo<>(clazzList).getTotal());
        pageResult.setRows(clazzList);

        return pageResult;
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.insertClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.selectClazzById(id);
    }

    @Override
    public void setClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public void removeClazz(Integer id) {
        clazzMapper.deleteClazz(id);
    }

    @Override
    public List<Clazz> getClazzList() {
        return clazzMapper.getClazzList();
    }
}
