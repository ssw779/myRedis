package com.zb.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.zb.entity.Dept;
import com.zb.mapper.DeptMapper;
import com.zb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public List<Dept> findDeptList() {
        List<Dept> list = null;
        String key = "list";
        //验证redi中是否存在数据
        if (redisTemplate.hasKey(key)) {
            System.out.println("从redis中查询数据");
            String jsonObj=(String )redisTemplate.opsForValue().get(key);
            list = JSON.parseArray(jsonObj, Dept.class);
        } else {
            System.out.println("从db中查询数据");
            list = deptMapper.findDeptList();
            //存储到redis中， 默认存储时间为60秒
            redisTemplate.opsForValue().set(key, JSON.toJSONString(list), 60, TimeUnit.SECONDS);
        }
        return list;





    }
}
