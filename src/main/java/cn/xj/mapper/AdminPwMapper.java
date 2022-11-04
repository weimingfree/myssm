package cn.xj.mapper;

import cn.xj.pojo.AdminPw;
import cn.xj.pojo.AdminPwExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPwMapper {
    int countByExample(AdminPwExample example);//按条件计数

    int deleteByExample(AdminPwExample example);//按条件删除

    int deleteByPrimaryKey(String aname);//按主键删除

    int insert(AdminPw record);//插入数据

    int insertSelective(AdminPw record);//选择性插入

    List<AdminPw> selectByExample(AdminPwExample example);//按条件查询

    AdminPw selectByPrimaryKey(String aname);//按主键查询

    int updateByExampleSelective(@Param("record") AdminPw record, @Param("example") AdminPwExample example);

    int updateByExample(@Param("record") AdminPw record, @Param("example") AdminPwExample example);//按条件更新

    int updateByPrimaryKeySelective(AdminPw record);//通过主键选择性更新

    int updateByPrimaryKey(AdminPw record);//按主键更新
}