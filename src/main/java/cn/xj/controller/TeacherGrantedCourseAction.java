package cn.xj.controller;

import cn.xj.service.CourseInfoService;
import cn.xj.service.CourseSrService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/grantedCourse")
public class TeacherGrantedCourseAction {
    @Autowired
    CourseInfoService courseInfoService;//从课程中进行选择
    @Autowired
    CourseSrService courseSrService;
    public static int PAGE_SIZE = 5;
    @RequestMapping("/split")
    public String split(String tid, HttpServletRequest request){
        System.out.println(tid);
        PageInfo info = null;
        info = courseInfoService.splitPageBySelectTid(1,PAGE_SIZE,tid);
        request.setAttribute("info",info);
        return "teacher/grantedCourse";
    }
    @RequestMapping("/delete")
    //将course_info表中的教师名和教师id置空，将courseSr表中的cid和tid相同的选课记录删掉
    public String delete(String cid,String tid,HttpServletRequest request){
        System.out.println(cid+" "+tid);
        courseInfoService.setTidTnameNull(cid,tid);
        request.setAttribute("msg","退授成功");
        return "forward:/grantedCourse/split.action";
    }
}
