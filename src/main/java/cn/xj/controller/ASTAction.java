package cn.xj.controller;

import cn.xj.pojo.AdminPw;
import cn.xj.pojo.StudentPw;
import cn.xj.pojo.TeacherPw;
import cn.xj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ast")
public class ASTAction {
    //调用service层
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(String name, String pwd, String type, HttpServletRequest request){
            System.out.println(name+" "+pwd+" "+type);
            if(type.equals( "1")){
                AdminPw adminPw = loginService.adminLogin(name,pwd);

                if(adminPw != null){
                    //登录成功
                    request.setAttribute("admin",adminPw);
                    return "managermain";
                }else{
                    //登录失败
                    request.setAttribute("errmsg","用户名或密码不正确");
                    return "myLogin";
                }

            } else if(type.equals( "2")) {
                StudentPw studentPw = loginService.studentLogin(name, pwd);
                if (studentPw != null) {
                    //登录成功
                    request.setAttribute("admin", studentPw);
                    return "/student/studentmain";
                } else {
                    //登录失败
                    request.setAttribute("errmsg", "用户名或密码不正确");
                    return "myLogin";
                }
            }else if(type.equals("3")){
                TeacherPw teacherPw = loginService.teacherLogin(name,pwd);
                if(teacherPw != null){
                    //登录成功
                    request.setAttribute("admin",teacherPw);
                    return "/teacher/teachermain";
                }else{
                    //登录失败
                    request.setAttribute("errmsg","用户名或密码不正确");
                    return "myLogin";
                }
            }else{
                request.setAttribute("errmsg","请输入类别");
                return "myLogin";
            }

            }

}
