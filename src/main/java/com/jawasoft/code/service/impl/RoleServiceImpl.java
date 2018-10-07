package com.jawasoft.code.service.impl;

import com.jawasoft.code.dao.RoleMapper;
import com.jawasoft.code.entity.Role;
import com.jawasoft.code.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role get(Integer pid) {
        return roleMapper.selectByPrimaryKey(pid);
    }
}
