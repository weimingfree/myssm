package cn.xj.service;

import cn.xj.pojo.CourseSr;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseSrService {
    PageInfo splitPage(int pageNum, int pageSize);//根据页码进行跳转
    public String getMaxHided();
    public boolean isSame(String cid,String cname,String ctid,String ctname,String sid,String sname);
    PageInfo splitPageBySelectCname(int pageNUm,int pageSize,String Cname);//通过课程名选择
    PageInfo splitPageBySelectTname(int pageNUm,int pageSize,String Tname);//通过老师姓名选择
    PageInfo splitPageBySelectSname(int pageNum,int pageSize,String Sname);//通过学生姓名选择
    PageInfo splitPageBySelectCid(int pageNUm,int pageSize,String Cid);//通过课程号选择
    PageInfo splitPageBySelectTid(int pageNUm,int pageSize,String Tid);//通过老师工号选择
    PageInfo splitPageBySelectSid(int pageNum,int pageSize,String Sid);//通过学生学号选择
    List<CourseSr> SelectByCid(String Cid);//通过课程号选择
    List<CourseSr> SelectByTid(String Tid);//通过教师工号选择
    List<CourseSr> SelectBySid(String Sid);//通过学生学号选择

    public int deleteyByHideid(String hideid);//根据hideid删除
    public int deleteByCid(String cid);//根据cid删除
    public int deleteByTid(String tid);//根据tid删除
    public int deleteBySid(String sid);//根据sid删除
    public int save(String hideid,String Cid,String Cname,String Tid,String Tname,String Sid,String Sname);
    public CourseSr getByID(String hideid);
    public int update(String hideid,String Cid,String Cname,String Tid,String Tname,String Sid,String Sname);
}
