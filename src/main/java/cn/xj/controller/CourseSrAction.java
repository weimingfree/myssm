package cn.xj.controller;

import cn.xj.pojo.CourseSr;
import cn.xj.service.CourseSrService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/courseSr")
public class CourseSrAction {
    public static final int PAGE_SIZE = 5;
    public int MAX_SIZE = 0;
    @Autowired
    CourseSrService courseSrService;
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        PageInfo info = null;
        info  = courseSrService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
       /* if(!info.getList().isEmpty()) {
            Object object = info.getList().get(0);
            CourseSr courseSr = (CourseSr) object;
            MAX_SIZE = Integer.parseInt(courseSr.getHideid());
            System.out.println("页面此时最大隐藏id" + MAX_SIZE);
        }*/
        return "courseSr";
    }
    //翻页使用
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int spage, HttpSession session){
        //取得当前page参数的页面的数据
        PageInfo info = courseSrService.splitPage(spage,PAGE_SIZE);
        session.setAttribute("info",info);
    }
    //查询
    @ResponseBody
    @RequestMapping("/conditionByTname")//通过教师名查询
    public void conditionSplitByTname(String tname,HttpSession session){
        PageInfo info = null;
        info = courseSrService.splitPageBySelectTname(1,PAGE_SIZE,tname);
        session.setAttribute("info",info);
    }
    @ResponseBody
    @RequestMapping("/conditionByCname")//通过课程名查询
    public void conditionSplitByCname(String cname,HttpSession session){
        PageInfo info = null;
        info = courseSrService.splitPageBySelectCname(1,PAGE_SIZE,cname);
        session.setAttribute("info",info);
    }
    @ResponseBody
    @RequestMapping("/conditionBySname")//通过学生名查询
    public void conditionSplitBySname(String sname,HttpSession session){
        PageInfo info = null;
        info = courseSrService.splitPageBySelectSname(1,PAGE_SIZE,sname);
        session.setAttribute("info",info);
    }
    //删除
    @RequestMapping("/delete")
    public String delete(String hideid,HttpServletRequest request){
        System.out.println(hideid);
        int num = -1;
        try {
            num = courseSrService.deleteyByHideid(hideid);
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
        return "forward:/courseSr/split.action";
    }

    //更新
    //点击编辑按钮时
    @RequestMapping("/one")
    public String one(String hideid, Model model){
        System.out.println(hideid);
        CourseSr info = courseSrService.getByID(hideid);
        model.addAttribute("thiscourseSr",info);
        /*System.out.println(info.toString());*/
        return"updateCourseSr";
    }
    @RequestMapping("/update")
    public String update(String hideid,String cid,String cname,String tname,String tid,String sid,String sname,HttpServletRequest request){
        System.out.println(hideid + " " + cname + " " + cid + " " + tname + " " + tid + " " + sid + " " + sname);
        int num = -1;
        try {
            num = courseSrService.update(hideid,cid,cname,tid,tname,sid,sname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
        if(num  > 0){
            request.setAttribute("msg","更新成功");
        }else{
            request.setAttribute("msg","更新失败");
        }
        //更新结束后跳到分页显示
        return "forward:/courseSr/split.action";

    }
    //保存
    @RequestMapping("/save")
    public String save(String cid,String cname,String tname,String tid,String sid,String sname,HttpServletRequest request){
        String hideid = String.valueOf(Integer.parseInt(courseSrService.getMaxHided()) + 1);
        System.out.println(hideid + " " + cname + " " + cid + " " + tname + " " + tid + " " + sid + " " + sname);
        int num = -1;
        try {
            num = courseSrService.save(hideid,cid,cname,tid,tname,sid,sname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
        if(num > 0){
            request.setAttribute("msg","增加成功！");
        }else {
            request.setAttribute("msg","增加失败！");
        }
        return "forward:/courseSr/split.action";
    }


}
