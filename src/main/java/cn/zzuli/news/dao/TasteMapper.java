package cn.zzuli.news.dao;

import cn.zzuli.news.entity.Taste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TasteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Taste record);

    int insertSelective(Taste record);

    Taste selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Taste record);

    int updateByPrimaryKey(Taste record);

    int deleteTasteByCateId(@Param("cateId") Integer cateId);

    List<Taste> selectTasteByUserId(@Param("userId") Integer userId);

    List<Taste> selectTasteBycateId(@Param("cateId") Integer cateId);
}