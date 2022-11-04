package cn.xj.service;

import cn.xj.pojo.StudentPw;

public interface StudentPWService {
    public int delete(String sid);//根据id删除,这里仅仅删除了student_info表的内容，student_pw表的内容没有删除
    public int save(String sid,String spw);
    public StudentPw getByID(String sid);
    public int update(String sid,String spw);
}
