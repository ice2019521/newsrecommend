package cn.zzuli.news.dao;

import cn.zzuli.news.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据条件分页查询用户信息
     * currIndex 查询第几页
     * pageSize 页面大小
     *
     * @param map
     * @return
     */
    List<User> selectUserPageConditions(Map map);

    /**
     * 查询满足条件的用户信息总数
     *
     * @param map
     * @return
     */
    int selectUserTotalConditions(Map map);
}