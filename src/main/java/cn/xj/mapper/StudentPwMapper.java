package cn.xj.mapper;

import cn.xj.pojo.StudentPw;
import cn.xj.pojo.StudentPwExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentPwMapper {
    int countByExample(StudentPwExample example);

    int deleteByExample(StudentPwExample example);

    int deleteByPrimaryKey(String sid);

    int insert(StudentPw record);

    int insertSelective(StudentPw record);

    List<StudentPw> selectByExample(StudentPwExample example);

    StudentPw selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") StudentPw record, @Param("example") StudentPwExample example);

    int updateByExample(@Param("record") StudentPw record, @Param("example") StudentPwExample example);

    int updateByPrimaryKeySelective(StudentPw record);

    int updateByPrimaryKey(StudentPw record);
}