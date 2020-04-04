package com.zb.test;

import com.zb.entity.Dept;
import com.zb.service.DeptService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-redis.xml");
        DeptService ps=context.getBean(DeptService.class);
        List<Dept> deptList = ps.findDeptList();
        for (Dept dept : deptList) {
            System.out.println(dept.getDeptName());
        }

    }
}
