package com.jawasoft.code.dao;

import com.jawasoft.code.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}