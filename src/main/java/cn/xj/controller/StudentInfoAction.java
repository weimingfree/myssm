package cn.xj.controller;

import cn.xj.pojo.StudentInfo;
import cn.xj.pojo.StudentPw;
import cn.xj.service.CourseSrService;
import cn.xj.service.StudentInfoService;
import cn.xj.service.StudentPWService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/studentInfo")
public class StudentInfoAction {
    public static final int PAGE_SIZE = 5;
    @Autowired
    StudentInfoService studentInfoService;
    @Autowired
    StudentPWService studentPWService;
    @Autowired
    CourseSrService courseSrService;

    //分页，始终跳转到第一页的信息
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        PageInfo info = null;
        info =studentInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "studentInfo";
    }
    //翻页使用
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int  spage, HttpSession session){

        //取得当前page参数的页面的数据
        PageInfo info = studentInfoService.splitPage(spage,PAGE_SIZE);
        session.setAttribute("info",info);
    }
    //查询
    @ResponseBody
    @RequestMapping("/condition")
    public void conditionSplit(String sid,HttpSession session){
        PageInfo info = null;
        info = studentInfoService.splitPageBySelectID(1,PAGE_SIZE,sid);
        session.setAttribute("info",info);
    }
    //删除
    @RequestMapping("/delete")//删除该学生信息会删除他的姓名，学号，密码，以及他的选课记录
    public String delete(String sid,HttpServletRequest request){
        int num = -1,num2 = -1,num3 = 1;
        try {
            num = studentInfoService.delete(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = studentPWService.delete(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!courseSrService.SelectBySid(sid).isEmpty()) {
            try {
                num3 = courseSrService.deleteBySid(sid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //如果没有他的选课记录，那么可能删除失败
        System.out.println(num+" "+num2 + " " + num3);
        if(num  > 0 && num2 > 0 && num3 > 0){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
        //删除结束后跳到分页显示
        return "forward:/studentInfo/split.action";
    }

    //更新
    //点击编辑按钮时
    @RequestMapping("/one")
    public String one(String sid, Model model){
        StudentInfo info = studentInfoService.getByID(sid);
        StudentPw spw = studentPWService.getByID(sid);
        model.addAttribute("thisstudent",info);
        model.addAttribute("spw",spw);
        return"updateStudentInfo";
    }
    @RequestMapping("/update")
    public String update(String sname,String sid,String spw,HttpServletRequest request){
        int num = -1,num2 = -1;
        try {
            num = studentInfoService.update(sname ,sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = studentPWService.update(sid,spw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(num > 0 && num2 > 0){
            //此时说明更新成功
            request.setAttribute("msg","更新成功!");
        }else{
            request.setAttribute("msg","更新失败!");
        }
        return "forward:/studentInfo/split.action";

    }
    //保存
    @RequestMapping("/save")
    public String save(String sname,String sid,String spw,HttpServletRequest request){
        System.out.println(sname + " " + sid + " " + spw);
        int num = -1,num2 = -1;
        try {
            num = studentInfoService.save(sid,sname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = studentPWService.save(sid,spw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(num > 0 && num2 > 0){
            request.setAttribute("msg","增加成功！");
        }else {
            request.setAttribute("msg","增加失败！");
        }
        return "forward:/studentInfo/split.action";
    }




}
