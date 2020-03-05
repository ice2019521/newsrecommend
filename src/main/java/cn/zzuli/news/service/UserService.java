package cn.zzuli.news.service;

import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.User;

import java.util.Map;

public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Result insertUser(User user) throws Exception;

    /**
     * 根据id修改用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    Result updateUserById(User user) throws Exception;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Result selectUserById(Integer id) throws Exception;

    /**
     * 根据条件分页查询用户信息
     *
     * @param map
     * @return
     * @throws Exception
     */
    Result selectUserPageConditions(Map map) throws Exception;
}
