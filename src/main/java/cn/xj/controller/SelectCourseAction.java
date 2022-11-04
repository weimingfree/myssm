package cn.xj.controller;

import cn.xj.pojo.StudentInfo;
import cn.xj.pojo.TeacherInfo;
import cn.xj.pojo.TeacherInfoExample;
import cn.xj.service.CourseInfoService;
import cn.xj.service.CourseSrService;
import cn.xj.service.StudentInfoService;
import cn.xj.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/selectCourse")
public class SelectCourseAction {
    public static final int PAGE_SIZE = 5;
    @Autowired
    CourseInfoService courseInfoService;
    @Autowired
    CourseSrService courseSrService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    StudentInfoService studentInfoService;
    @RequestMapping("/split")
    public String split(String sid,HttpServletRequest request){//查询出所有的课程信息
        System.out.println(sid);
        PageInfo info = null;
        info  = courseInfoService.splitPageBySelectTidNotNull(1,PAGE_SIZE);
        request.setAttribute("info",info);
        request.setAttribute("sid",sid);
        return "student/selectCourseInfo";
    }
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int spage, HttpSession session){
        //取得当前page参数的页面的数据
        PageInfo info = courseInfoService.splitPageBySelectTidNotNull(spage,PAGE_SIZE);
        session.setAttribute("info",info);
    }
    @RequestMapping("/add")
    public String add(String sid,String cid,String cname,String ctname,String ctid,HttpServletRequest request){//选课，即增加一份选课记录
        System.out.println(sid + " " + cid + " " + cname + " " + ctname + " "+ ctid);
        StudentInfo studentInfo = studentInfoService.getByID(sid);
        String sname = studentInfo.getSname();
        String hideid = String.valueOf(Integer.parseInt(courseSrService.getMaxHided())+1);
        System.out.println(hideid + " " + cname + " " + cid + " " + ctname + " " + ctid + " " + sid + " " + sname);
        if(courseSrService.isSame(cid,cname,ctid,ctname,sid,sname)){
            request.setAttribute("msg","您已经选过这门课");
        }
        else {
            int num = -1;
            try {
                num = courseSrService.save(hideid, cid, cname, ctid, ctname, sid, sname);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(num);
            if (num > 0) {
                request.setAttribute("msg", "选课成功！");
            } else {
                request.setAttribute("msg", "选课失败！");
            }
        }
        return "forward:/selectCourse/split.action";

    }


}
