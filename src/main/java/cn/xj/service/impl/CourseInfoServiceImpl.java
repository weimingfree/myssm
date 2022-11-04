package cn.xj.service.impl;


import cn.xj.mapper.CourseInfoMapper;
import cn.xj.pojo.CourseInfo;
import cn.xj.pojo.CourseInfoExample;
import cn.xj.service.CourseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    CourseInfoMapper courseInfoMapper;


    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        CourseInfoExample example = new CourseInfoExample();
        example.setOrderByClause("Cid desc");
        List<CourseInfo> list  = courseInfoMapper.selectByExample(example);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectID(int pageNum, int pageSize, String cid) {
       PageHelper.startPage(pageNum,pageSize);
       CourseInfoExample example  = new CourseInfoExample();
       example.createCriteria().andCidEqualTo(cid);
       List<CourseInfo> list = courseInfoMapper.selectByExample(example);
       PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
       return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectCname(int pageNum, int pageSize, String cname) {
        PageHelper.startPage(pageNum,pageSize);
        CourseInfoExample example  = new CourseInfoExample();
        example.createCriteria().andCnameEqualTo(cname);
        List<CourseInfo> list = courseInfoMapper.selectByExample(example);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectTname(int pageNum, int pageSize, String tname) {
        PageHelper.startPage(pageNum,pageSize);
        CourseInfoExample example  = new CourseInfoExample();
        example.createCriteria().andCtnameEqualTo(tname);
        List<CourseInfo> list = courseInfoMapper.selectByExample(example);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectTid(int pageNum, int pagesize, String tid) {
        PageHelper.startPage(pageNum,pagesize);
        CourseInfoExample example = new CourseInfoExample();
        example.createCriteria().andCtidEqualTo(tid);
        List<CourseInfo> list = courseInfoMapper.selectByExample(example);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectTidNotNull(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum,pagesize);
        CourseInfoExample example = new CourseInfoExample();
        example.createCriteria().andCtidNotEqualTo("0");
        example.setOrderByClause("Cid desc");
        List<CourseInfo> list = courseInfoMapper.selectByExample(example);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int setTidTnameNull(String cid,String tid) {
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setCtid("0");
        courseInfo.setCtname("0");
        CourseInfoExample courseInfoExample = new CourseInfoExample();
        courseInfoExample.createCriteria().andCidEqualTo(cid).andCtidEqualTo(tid);
        return courseInfoMapper.updateByExampleSelective(courseInfo,courseInfoExample);
    }

    @Override
    public int delete(String cid) {
       return courseInfoMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int save(String cid, String cname, String ctname,String ctid) {
        CourseInfo info = new CourseInfo();
        info.setCid(cid);
        info.setCname(cname);
        info.setCtname(ctname);
        info.setCtid(ctid);
        return courseInfoMapper.insert(info);
    }

    @Override
    public CourseInfo getByID(String cid) {
        return courseInfoMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int update(String ctname, String cname, String cid,String ctid) {
        CourseInfo info = new CourseInfo();
        info.setCid(cid);
        info.setCname(cname);
        info.setCtname(ctname);
        info.setCtid(ctid);
        return courseInfoMapper.updateByPrimaryKey(info);
    }
}
