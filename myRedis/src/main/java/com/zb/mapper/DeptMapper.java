package com.zb.mapper;

import com.zb.entity.Dept;

import javax.servlet.http.HttpServlet;
import java.util.List;

public interface DeptMapper  {
    public List<Dept> findDeptList();
}
