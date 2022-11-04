package cn.xj.controller;

import cn.xj.pojo.CourseInfo;
import cn.xj.service.CourseInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("courseInfo")
public class CourseInfoAction {
    public static final int PAGE_SIZE = 5;
    @Autowired
    CourseInfoService courseInfoService;
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        PageInfo info = null;
        info  = courseInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "courseInfo";
    }
    //翻页使用
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int spage, HttpSession session){

        //取得当前page参数的页面的数据
        PageInfo info = courseInfoService.splitPage(spage,PAGE_SIZE);
        session.setAttribute("info",info);
    }
    //查询
    @ResponseBody
    @RequestMapping("/condition")
    public void conditionSplit(String cid,HttpSession session){
        PageInfo info = null;
        info = courseInfoService.splitPageBySelectID(1,PAGE_SIZE,cid);
        session.setAttribute("info",info);
    }
    @ResponseBody
    @RequestMapping("/conditionByCname")
    public void conditionSplitByCname(String cname,HttpSession session){
        PageInfo info = null;
        info = courseInfoService.splitPageBySelectCname(1,PAGE_SIZE,cname);
        session.setAttribute("info",info);
    }
    @ResponseBody
    @RequestMapping("/conditionByTname")
    public void conditionSplitByTname(String tname,HttpSession session){
        PageInfo info = null;
        info = courseInfoService.splitPageBySelectTname(1,PAGE_SIZE,tname);
        session.setAttribute("info",info);
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String cid,HttpServletRequest request){
        System.out.println(cid);
        int num = -1;
        try {
            num = courseInfoService.delete(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(num);
        if(num  > 0 ){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
        //删除结束后跳到分页显示
        return "forward:/courseInfo/split.action";
    }

    //更新
    //点击编辑按钮时
    @RequestMapping("/one")
    public String one(String cid, Model model){
        System.out.println(cid);
        CourseInfo info = courseInfoService.getByID(cid);
        model.addAttribute("thiscourse",info);
        /*System.out.println(info.toString());*/
        return"updateCourseInfo";
    }
    @RequestMapping("/update")
    public String update(String cname,String cid,String ctname,String ctid,HttpServletRequest request){
        System.out.println(cname + " " + cid + " " + ctname + " " + ctid);
        int num = -1;
        try {
            num = courseInfoService.update(ctname, cname, cid,ctid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num );
        if(num  > 0){
            request.setAttribute("msg","更新成功");
        }else{
            request.setAttribute("msg","更新失败");
        }
        //删除结束后跳到分页显示
        return "forward:/courseInfo/split.action";

    }
    //保存
    @RequestMapping("/save")
    public String save(String cname,String cid,String ctname,String ctid,HttpServletRequest request){
        System.out.println(cname + " " + cid + " " + ctname + " " + ctid);
        int num = -1;
        try {
            num = courseInfoService.save(cid, cname, ctname,ctid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
        if(num > 0){
            request.setAttribute("msg","增加成功！");
        }else {
            request.setAttribute("msg","增加失败！");
        }
        return "forward:/courseInfo/split.action";
    }

}
