package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.common.util.StringUtil;
import cn.zzuli.news.entity.User;
import cn.zzuli.news.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User user) {
        try {
            if (user == null || StringUtil.isEmpty(user.getNick())
                    || StringUtil.isEmpty(user.getPassword()) || !StringUtil.isPhone(true, user.getPhone())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加用户");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加用户");
            }
            return userService.insertUser(user);
        } catch (Exception e) {
            logger.error("添加用户error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加用户");
        }
    }

    /**
     * 根据id修改用户信息
     *
     * @param user
     * @return
     */
    @PutMapping("/updateUserById")
    public Result updateUserById(@RequestBody User user) {
        try {
            if (user == null || user.getId() == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改用户信息");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改用户信息");
            }
            return userService.updateUserById(user);
        } catch (Exception e) {
            logger.error("根据id修改用户信息error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id修改用户信息");
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/selectUserById/{id}")
    public Result selectUserById(@PathVariable("id") Integer id) {
        try {
            if (id == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id查询用户信息");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id查询用户信息");
            }
            return userService.selectUserById(id);
        } catch (Exception e) {
            logger.error("根据id查询用户信息error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id查询用户信息");
        }
    }

    /**
     * 根据条件分页查询用户信息
     *
     * @param map
     * @return
     */
    @PostMapping("/selectUserPageConditions")
    public Result selectUserPageConditions(@RequestBody Map map) {
        try {
            if (map == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据条件分页查询用户信息");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据条件分页查询用户信息");
            }
            return userService.selectUserPageConditions(map);
        } catch (Exception e) {
            logger.error("根据条件分页查询用户信息error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据条件分页查询用户信息");
        }
    }

}
