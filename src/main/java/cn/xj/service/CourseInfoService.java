package cn.xj.service;

import cn.xj.pojo.CourseInfo;
import com.github.pagehelper.PageInfo;

public interface CourseInfoService {
    PageInfo splitPage(int pageNum, int pageSize);//根据页码进行跳转
    PageInfo splitPageBySelectID(int pageNum,int pageSize,String cid);//根据id
    PageInfo splitPageBySelectCname(int pageNum,int pageSize,String cname);//根据课程名
    PageInfo splitPageBySelectTname(int pageNum,int pageSize,String tname);//根据教师名
    PageInfo splitPageBySelectTid(int pageNum,int pagesize,String tid);//通过教师的id
    PageInfo splitPageBySelectTidNotNull(int pageNum,int pagesize);//选择tid不为空的课程
    public int setTidTnameNull(String cid,String tid);//对tid和tname进行置空
    public int delete(String cid);//根据id删除,这里仅仅删除了student_info表的内容，student_pw表的内容没有删除
    public int save(String cid,String cname,String ctname,String ctid);
    public CourseInfo getByID(String cid);
    public int update(String ctname,String cname,String cid,String ctid);
}
