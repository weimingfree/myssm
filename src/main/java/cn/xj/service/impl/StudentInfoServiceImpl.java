package cn.xj.service.impl;

import cn.xj.mapper.StudentInfoMapper;
import cn.xj.pojo.StudentInfo;
import cn.xj.pojo.StudentInfoExample;
import cn.xj.service.StudentInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //先根据页数和页的大小
        PageHelper.startPage(pageNum,pageSize);
        StudentInfoExample example = new StudentInfoExample();
        example.setOrderByClause("Sid desc");
        List<StudentInfo> list =studentInfoMapper.selectByExample(example);
        PageInfo<StudentInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectID(int pageNum, int pageSize,String id) {
       PageHelper.startPage(pageNum,pageSize);
       StudentInfoExample example = new StudentInfoExample();
       example.createCriteria().andSidEqualTo(id);
       List<StudentInfo> list = studentInfoMapper.selectByExample(example);
       PageInfo<StudentInfo> pageInfo = new PageInfo<>(list);
       return pageInfo;
    }

    @Override
    public int delete(String sid) {
        return studentInfoMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int save(String sid, String sname) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setSid(sid);
        studentInfo.setSname(sname);
        return studentInfoMapper.insert(studentInfo);
    }

    @Override
    public StudentInfo getByID(String sid) {
        return studentInfoMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int update(String sname, String sid) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setSname(sname);
        studentInfo.setSid(sid);
        return studentInfoMapper.updateByPrimaryKey(studentInfo);
    }


}
