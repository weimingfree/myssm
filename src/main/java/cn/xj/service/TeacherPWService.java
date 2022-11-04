package cn.xj.service;

import cn.xj.pojo.StudentPw;
import cn.xj.pojo.TeacherPw;

public interface TeacherPWService {
    public int delete(String tid);//根据id删除,这里仅仅删除了student_info表的内容，student_pw表的内容没有删除
    public int save(String tid,String tpw);
    public TeacherPw getByID(String tid);
    public int update(String tid,String tpw);
}
