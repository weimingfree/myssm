package cn.xj.controller;

import cn.xj.pojo.CourseInfo;
import cn.xj.service.CourseInfoService;
import cn.xj.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teachCourse")
public class TeacherTeachCourseAction {
    public static int PAGE_SIZE = 5;
    @Autowired
    CourseInfoService courseInfoService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @RequestMapping("/split")
    public String split(String tid, HttpServletRequest request){
        System.out.println(tid);
        PageInfo info = null;
        info = courseInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        request.setAttribute("tid",tid);
        return "/teacher/teachCourse";
    }
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(String tid,int spage,HttpSession session){
        System.out.println(tid+" " + spage);
        PageInfo info = courseInfoService.splitPage(spage,PAGE_SIZE);
        session.setAttribute("info",info);
        session.setAttribute("tid",tid);
    }
    @RequestMapping("/teach")
    public String teach(String tid,String cid,String ctid,HttpServletRequest request){
        System.out.println(tid + " " +cid + " " + ctid);
        if(!ctid.equals("0")){
            request.setAttribute("msg","此课已被其他教师所授");
        }else {
            String tname = teacherInfoService.getByID(tid).getTname();
            String cname = courseInfoService.getByID(cid).getCname();
            courseInfoService.update(tname,cname,cid,tid);
            request.setAttribute("msg","授课成功");
        }
        return "forward:/teachCourse/split.action";
    }
}
