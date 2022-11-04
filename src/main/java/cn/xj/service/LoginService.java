package cn.xj.service;

import cn.xj.pojo.AdminPw;
import cn.xj.pojo.StudentPw;
import cn.xj.pojo.TeacherPw;

public interface LoginService {
    AdminPw adminLogin(String name, String pwd);
    StudentPw studentLogin(String name,String pwd);
    TeacherPw teacherLogin(String name,String pwd);

}
