package cn.xj.mapper;

import cn.xj.pojo.TeacherPw;
import cn.xj.pojo.TeacherPwExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherPwMapper {
    int countByExample(TeacherPwExample example);

    int deleteByExample(TeacherPwExample example);

    int deleteByPrimaryKey(String tid);

    int insert(TeacherPw record);

    int insertSelective(TeacherPw record);

    List<TeacherPw> selectByExample(TeacherPwExample example);

    TeacherPw selectByPrimaryKey(String tid);

    int updateByExampleSelective(@Param("record") TeacherPw record, @Param("example") TeacherPwExample example);

    int updateByExample(@Param("record") TeacherPw record, @Param("example") TeacherPwExample example);

    int updateByPrimaryKeySelective(TeacherPw record);

    int updateByPrimaryKey(TeacherPw record);
}