package cn.xj.service.impl;

import cn.xj.mapper.StudentPwMapper;
import cn.xj.pojo.StudentPw;
import cn.xj.service.StudentPWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPWServiceImpl implements StudentPWService {
    @Autowired
    StudentPwMapper studentPwMapper;
    @Override
    public int delete(String sid){
        return studentPwMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int save(String sid, String spw) {
        StudentPw studentPw = new StudentPw();
        studentPw.setSid(sid);
        studentPw.setSpw(spw);
        return studentPwMapper.insert(studentPw);
    }

    @Override
    public StudentPw getByID(String sid) {
        return studentPwMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int update(String sid, String spw) {
        StudentPw studentPw = new StudentPw();
        studentPw.setSpw(spw);
        studentPw.setSid(sid);
        return studentPwMapper.updateByPrimaryKey(studentPw);
    }
}
