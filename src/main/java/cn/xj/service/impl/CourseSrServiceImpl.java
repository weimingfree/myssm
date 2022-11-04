package cn.xj.service.impl;

import cn.xj.mapper.CourseSrMapper;
import cn.xj.pojo.CourseSr;
import cn.xj.pojo.CourseSrExample;
import cn.xj.service.CourseSrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSrServiceImpl implements CourseSrService {
    @Autowired
    CourseSrMapper courseSrMapper;


    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.setOrderByClause("Hideid desc");
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public String getMaxHided() {
      CourseSrExample courseSrExample = new CourseSrExample();
      courseSrExample.setOrderByClause("Hideid desc");
      List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
      return list.get(0).getHideid();
    }

    @Override
    public boolean isSame(String cid, String cname, String ctid, String ctname, String sid, String sname) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andCidEqualTo(cid).andCnameEqualTo(cname).andTidEqualTo(ctid)
                .andTnameEqualTo(ctname).andSidEqualTo(sid).andSnameEqualTo(sname);
       List<CourseSr> list = courseSrMapper.selectByExample(example);
       return !list.isEmpty();//如果list不为空，说明有相同的
    }


    @Override
    public PageInfo splitPageBySelectCname(int pageNUm, int pageSize, String Cname) {
        PageHelper.startPage(pageNUm,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andCnameEqualTo(Cname);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectTname(int pageNUm, int pageSize, String Tname) {
        PageHelper.startPage(pageNUm,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andTnameEqualTo(Tname);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectSname(int pageNum, int pageSize, String Sname) {
        PageHelper.startPage(pageNum,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andSnameEqualTo(Sname);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectCid(int pageNUm, int pageSize, String Cid) {
        PageHelper.startPage(pageNUm,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andCidEqualTo(Cid);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectTid(int pageNUm, int pageSize, String Tid) {
        PageHelper.startPage(pageNUm,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andTidEqualTo(Tid);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo splitPageBySelectSid(int pageNum, int pageSize, String Sid) {
        PageHelper.startPage(pageNum,pageSize);
        CourseSrExample courseSrExample = new CourseSrExample();
        courseSrExample.createCriteria().andSidEqualTo(Sid);
        List<CourseSr> list = courseSrMapper.selectByExample(courseSrExample);
        PageInfo<CourseSr> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<CourseSr> SelectByCid(String Cid) {
       CourseSrExample example = new CourseSrExample();
       example.createCriteria().andCidEqualTo(Cid);
       List<CourseSr> list = courseSrMapper.selectByExample(example);
       return list;
    }

    @Override
    public List<CourseSr> SelectByTid(String Tid) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andTidEqualTo(Tid);
        List<CourseSr> list = courseSrMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<CourseSr> SelectBySid(String Sid) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andSidEqualTo(Sid);
        List<CourseSr> list = courseSrMapper.selectByExample(example);
        return list;
    }


    @Override
    public int deleteyByHideid(String hideid) {
        return courseSrMapper.deleteByPrimaryKey(hideid);
    }

    @Override
    public int deleteByCid(String cid) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andCidEqualTo(cid);
        return courseSrMapper.deleteByExample(example);
    }

    @Override
    public int deleteByTid(String tid) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andTidEqualTo(tid);
        return courseSrMapper.deleteByExample(example);
    }

    @Override
    public int deleteBySid(String sid) {
        CourseSrExample example = new CourseSrExample();
        example.createCriteria().andSidEqualTo(sid);
        return courseSrMapper.deleteByExample(example);
    }


    @Override
    public int save(String hideid, String Cid, String Cname, String Tid, String Tname, String Sid, String Sname) {
       CourseSr courseSr = new CourseSr();
       courseSr.setHideid(hideid);
       courseSr.setCid(Cid);
       courseSr.setCname(Cname);
       courseSr.setTid(Tid);
       courseSr.setTname(Tname);
       courseSr.setSid(Sid);
       courseSr.setSname(Sname);
       return courseSrMapper.insert(courseSr);
    }

    @Override
    public CourseSr getByID(String hideid) {
       return courseSrMapper.selectByPrimaryKey(hideid);
    }

    @Override
    public int update(String hideid, String Cid, String Cname, String Tid, String Tname, String Sid, String Sname) {
        CourseSr courseSr = new CourseSr();
        courseSr.setHideid(hideid);
        courseSr.setCname(Cname);
        courseSr.setCid(Cid);
        courseSr.setTid(Tid);
        courseSr.setTname(Tname);
        courseSr.setSid(Sid);
        courseSr.setSname(Sname);
        return courseSrMapper.updateByPrimaryKey(courseSr);
    }
}
