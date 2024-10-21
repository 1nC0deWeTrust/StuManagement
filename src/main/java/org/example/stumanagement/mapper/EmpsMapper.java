package org.example.stumanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.stumanagement.pojo.Emp;

import java.util.List;


@Mapper
public interface EmpsMapper {

    List<Emp> selectEmps();
}
