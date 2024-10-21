package org.example.stumanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.stumanagement.pojo.Clazz;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> selectClazzs(@Param("name") String name,
                             @Param("begin") LocalDate begin,
                             @Param("end") LocalDate end);

    void insertClazz(Clazz clazz);

    Clazz selectClazzById(Integer id);

    void updateClazz(Clazz clazz);

    void deleteClazz(Integer id);

    List<Clazz> getClazzList();
}
