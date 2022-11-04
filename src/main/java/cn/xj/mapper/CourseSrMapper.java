package cn.xj.mapper;

import cn.xj.pojo.CourseSr;
import cn.xj.pojo.CourseSrExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseSrMapper {
    int countByExample(CourseSrExample example);

    int deleteByExample(CourseSrExample example);

    int deleteByPrimaryKey(String hideid);

    int insert(CourseSr record);

    int insertSelective(CourseSr record);

    List<CourseSr> selectByExample(CourseSrExample example);

    CourseSr selectByPrimaryKey(String hideid);

    int updateByExampleSelective(@Param("record") CourseSr record, @Param("example") CourseSrExample example);

    int updateByExample(@Param("record") CourseSr record, @Param("example") CourseSrExample example);

    int updateByPrimaryKeySelective(CourseSr record);

    int updateByPrimaryKey(CourseSr record);
}