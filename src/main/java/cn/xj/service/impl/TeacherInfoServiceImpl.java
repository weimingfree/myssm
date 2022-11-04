package cn.xj.service.impl;

import cn.xj.mapper.TeacherInfoMapper;
import cn.xj.pojo.StudentInfo;
import cn.xj.pojo.StudentInfoExample;
import cn.xj.pojo.TeacherInfo;
import cn.xj.pojo.TeacherInfoExample;
import cn.xj.service.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //先根据页数和页的大小
        PageHelper.startPage(pageNum,pageSize);
        TeacherInfoExample example = new TeacherInfoExample();
        example.setOrderByClause("Tid desc");
        List<TeacherInfo> list  = teacherInfoMapper.selectByExample(example);
        PageInfo<TeacherInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectID(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        TeacherInfoExample example = new TeacherInfoExample();
        example.createCriteria().andTidEqualTo(id);
        List<TeacherInfo> list = teacherInfoMapper.selectByExample(example);
        PageInfo<TeacherInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delete(String tid) {
        return teacherInfoMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int save(String tid, String tname) {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setTid(tid);
        teacherInfo.setTname(tname);
        return teacherInfoMapper.insert(teacherInfo);
    }

    @Override
    public TeacherInfo getByID(String tid) {
        return teacherInfoMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int update(String tname, String tid) {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setTid(tid);
        teacherInfo.setTname(tname);
        return teacherInfoMapper.updateByPrimaryKey(teacherInfo);
    }
}
