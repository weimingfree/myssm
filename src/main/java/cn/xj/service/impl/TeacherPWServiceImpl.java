package cn.xj.service.impl;

import cn.xj.mapper.TeacherPwMapper;
import cn.xj.pojo.StudentPw;
import cn.xj.pojo.TeacherPw;
import cn.xj.service.TeacherPWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherPWServiceImpl implements TeacherPWService {
    @Autowired
    TeacherPwMapper teacherPwMapper;
    @Override
    public int delete(String tid) {
        return teacherPwMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int save(String tid, String tpw) {
        TeacherPw teacherPw = new TeacherPw();
        teacherPw.setTid(tid);
        teacherPw.setTpw(tpw);
        return teacherPwMapper.insert(teacherPw);
    }

    @Override
    public TeacherPw getByID(String tid) {
        return teacherPwMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int update(String tid, String tpw) {
        TeacherPw teacherPw = new TeacherPw();
        teacherPw.setTid(tid);
        teacherPw.setTpw(tpw);
        return teacherPwMapper.updateByPrimaryKey(teacherPw);
    }
}
