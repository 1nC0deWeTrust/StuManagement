package org.example.stumanagement.service;

import org.example.stumanagement.pojo.Clazz;
import org.example.stumanagement.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {

    PageResult<Clazz> queryClazzs(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void setClazz(Clazz clazz);

    void removeClazz(Integer id);

    List<Clazz> getClazzList();
}
