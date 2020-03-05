package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.common.util.SHAUtil;
import cn.zzuli.news.dao.UserMapper;
import cn.zzuli.news.entity.User;
import cn.zzuli.news.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichaoyuan
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Result insertUser(User user) throws Exception {
        //密码加密
        user.setPassword(SHAUtil.getSHA256StrJava(user.getPassword()));
        if (userMapper.insertSelective(user) == 1) {
            logger.info("添加用户, 成功");
            return Result.success();
        } else {
            return Result.fail(ErrorCode.AddIsErrorCode, ErrorCode.AddIsErrorInfo + ", 添加用户");
        }
    }

    /**
     * 根据id修改用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Result updateUserById(User user) throws Exception {
        if (user.getPassword() != null) {
            //密码加密
            user.setPassword(SHAUtil.getSHA256StrJava(user.getPassword()));
        }
        if (userMapper.updateByPrimaryKeySelective(user) == 1) {
            logger.info("根据id修改用户信息, 成功");
            return Result.success();
        } else {
            return Result.fail(ErrorCode.UpdateErrorCode, ErrorCode.UpdateErrorInfo + ", 根据id修改用户信息");
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result selectUserById(Integer id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            logger.info("查询用户id为 " + id + " 信息, 成功");
            return Result.success(user);
        } else {
            return Result.fail(ErrorCode.UpdateErrorCode, ErrorCode.UpdateErrorInfo + ", 根据id查询用户信息");
        }
    }

    /**
     * 根据条件分页查询用户信息
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Result selectUserPageConditions(Map map) throws Exception {
        //查询满足条件的用户信息总数
        int total = userMapper.selectUserTotalConditions(map);
        //查询满足条件的用户分页信息
        Integer currIndex = (Integer) map.get("currIndex");
        Integer pageSize = (Integer) map.get("pageSize");
        map.put("currIndex", (currIndex - 1) * pageSize);
        List<User> users = userMapper.selectUserPageConditions(map);
        if (users == null || CollectionUtils.isEmpty(users)) {
            logger.info("根据条件分页查询用户信息, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据id查询用户信息");
        } else {
            Map<String, Object> res = new HashMap<>(users.size());
            res.put("users", users);
            res.put("currIndex", map.get("currIndex"));
            res.put("pageSize", map.get("pageSize"));
            res.put("pages", total);
            logger.info("根据条件分页查询用户信息, 成功");
            return Result.success(res);
        }
    }

}
