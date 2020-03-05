package cn.zzuli.news.dao;

import cn.zzuli.news.entity.Cate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CateMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cate record);

    int insertSelective(Cate record);

    Cate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cate record);

    int updateByPrimaryKey(Cate record);

    List<Cate> selectCateAll();
}