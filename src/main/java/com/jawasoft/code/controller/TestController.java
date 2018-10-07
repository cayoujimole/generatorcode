package com.jawasoft.code.controller;

import com.jawasoft.code.entity.Role;
import com.jawasoft.code.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    RoleService roleService;

    @ResponseBody
    @RequestMapping("/getRole/{pid}")
    public Role getRole(@PathVariable("pid") Integer pid){
        return roleService.get(pid);
    }

    @RequestMapping("/hellow")
    public String hellow(Map<String, Object> map){
        map.put("m","ssssss");
        return "index";
    }

    @RequestMapping("/hellow2")
    public String hellow2(Map<String, Object> map){
        map.put("m","ssssss");
        return "index_new";
    }

    @RequestMapping("/index2")
    public String index2(Map<String, Object> map){
        map.put("m","ssssss");
        return "index2";
    }
}
