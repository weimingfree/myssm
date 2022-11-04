package cn.xj.controller;

import cn.xj.pojo.StudentInfo;
import cn.xj.pojo.StudentPw;
import cn.xj.pojo.TeacherInfo;
import cn.xj.pojo.TeacherPw;
import cn.xj.service.*;
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
@RequestMapping("/teacherInfo")
public class TeacherInfoAction {
    public static final int PAGE_SIZE = 5;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    TeacherPWService teacherPWService;
    @Autowired
    CourseSrService courseSrService;

    //分页，始终跳转到第一页的信息
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        PageInfo info = null;
        info =teacherInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "teacherInfo";
    }
    //翻页使用
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int spage, HttpSession session){

        //取得当前page参数的页面的数据
        PageInfo info = teacherInfoService.splitPage(spage,PAGE_SIZE);
        session.setAttribute("info",info);
    }
    //查询
    @ResponseBody
    @RequestMapping("/condition")
    public void conditionSplit(String tid,HttpSession session){
        PageInfo info = null;
        info = teacherInfoService.splitPageBySelectID(1,PAGE_SIZE,tid);
        session.setAttribute("info",info);
    }
    //删除
    @RequestMapping("/delete")
    public String delete(String tid,HttpServletRequest request){
        System.out.println(tid);
        int num = -1,num2 = -1,num3 = 1;
        try {
            num = teacherInfoService.delete(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = teacherPWService.delete(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!courseSrService.SelectByTid(tid).isEmpty()) {
            System.out.println(courseSrService.SelectByTid(tid).get(0).getTid());
            try {
                num3 = courseSrService.deleteByTid(tid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(num+" "+num2 + " " + num3);
        if(num  > 0 && num2 > 0 && num3 > 0){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
        //删除结束后跳到分页显示
        return "forward:/teacherInfo/split.action";
    }

    //更新
    //点击编辑按钮时
    @RequestMapping("/one")
    public String one(String tid, Model model){
        TeacherInfo info = teacherInfoService.getByID(tid);
        TeacherPw tpw = teacherPWService.getByID(tid);
        model.addAttribute("thisteacher",info);
        model.addAttribute("tpw",tpw);
        return"updateTeacherInfo";
    }
    @RequestMapping("/update")
    public String update(String tname,String tid,String tpw,HttpServletRequest request){
        int num = -1,num2 = -1;
        try {
            num = teacherInfoService.update(tname,tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = teacherPWService.update(tid,tpw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num+" "+num2 );
        if(num  > 0 && num2 > 0){
            request.setAttribute("msg","更新成功");
        }else{
            request.setAttribute("msg","更新失败");
        }
        //删除结束后跳到分页显示
        return "forward:/teacherInfo/split.action";

    }
    //保存
    @RequestMapping("/save")
    public String save(String tname,String tid,String tpw,HttpServletRequest request){
        System.out.println(tname + " " + tid + " " + tpw);
        int num = -1,num2 = -1;
        try {
            num = teacherInfoService.save(tid,tname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            num2 = teacherPWService.save(tid, tpw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num+" "+num2 );
        if(num > 0 && num2 > 0){
            request.setAttribute("msg","增加成功！");
        }else {
            request.setAttribute("msg","增加失败！");
        }
        return "forward:/teacherInfo/split.action";
    }




}

