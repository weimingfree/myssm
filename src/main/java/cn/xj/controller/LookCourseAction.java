package cn.xj.controller;

import cn.xj.service.CourseSrService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("lookcourse")
public class LookCourseAction {
    public static final int PAGE_SIZE = 5;
    @Autowired
    CourseSrService courseSrService;
    @RequestMapping("/split")
    public String split(String sid,HttpServletRequest request){
        System.out.println(sid);
        PageInfo info = null;
        info  = courseSrService.splitPageBySelectSid(1,PAGE_SIZE,sid);
        request.setAttribute("info",info);
        return "student/lookCourseInfo";
    }

}
