package cn.xj.service.impl;

import cn.xj.mapper.AdminPwMapper;
import cn.xj.mapper.StudentPwMapper;
import cn.xj.mapper.TeacherPwMapper;
import cn.xj.pojo.*;
import cn.xj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AdminPwMapper adminPwMapper;
    @Autowired
    StudentPwMapper studentPwMapper;
    @Autowired
    TeacherPwMapper teacherPwMapper;


    @Override
    public AdminPw adminLogin(String name, String pwd){
        //根据传入的用户名到DB中查询相应的用户对象
        //如果有条件，则一定要创建AdminExample的对象，用来封装条件
        AdminPwExample example = new AdminPwExample();
        //添加用户名a_name条件
        example.createCriteria().andAnameEqualTo(name);
        List<AdminPw> list  = adminPwMapper.selectByExample(example);
        if(list.size() > 0){
            AdminPw adminPw = list.get(0);
            //如果查询到用户对象，再进行密码比对,注意密码是密文
            if(pwd.equals(adminPw.getApw())){
                return adminPw;
            }
        }
        return null;
    }

    @Override
    public StudentPw studentLogin(String name,String pwd){
        StudentPwExample example = new StudentPwExample();
        example.createCriteria().andSidEqualTo(name);
        List<StudentPw> list = studentPwMapper.selectByExample(example);
        if(list.size() > 0){
            StudentPw studentPw = list.get(0);
            if(pwd.equals(studentPw.getSpw())){
                return studentPw;
            }
        }
        return null;
    }

    @Override
    public TeacherPw teacherLogin(String name,String pwd){
        TeacherPwExample example = new TeacherPwExample();
        example.createCriteria().andTidEqualTo(name);
        List<TeacherPw> list = teacherPwMapper.selectByExample(example);
        if(list.size() > 0){
            TeacherPw teacherPw = list.get(0);
            if(pwd.equals(teacherPw.getTpw())){
                return teacherPw;
            }
        }
        return null;
    }
}
