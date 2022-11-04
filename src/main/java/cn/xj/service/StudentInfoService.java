package cn.xj.service;

import cn.xj.pojo.StudentInfo;
import com.github.pagehelper.PageInfo;

public interface StudentInfoService {

    PageInfo splitPage(int pageNum, int pageSize);//根据页码进行跳转
    PageInfo splitPageBySelectID(int pageNum,int pageSize,String id);//根据id查询
    public int delete(String sid);//根据id删除,这里仅仅删除了student_info表的内容，student_pw表的内容没有删除
    public int save(String sid,String sname);
    public StudentInfo getByID(String sid);
    public int update(String sname,String sid);

}
