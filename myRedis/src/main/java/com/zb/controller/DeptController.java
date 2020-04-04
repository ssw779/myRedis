package com.zb.controller;

import com.alibaba.fastjson.JSON;
import com.zb.entity.Dept;
import com.zb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class DeptController   {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        System.out.println("进入controller");
        List<Dept> list = deptService.findDeptList();

        return JSON.toJSONString(list);
    }


}
