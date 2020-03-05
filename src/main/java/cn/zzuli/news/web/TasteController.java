package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.Taste;
import cn.zzuli.news.service.TasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taste")
public class TasteController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(TasteController.class);
    @Autowired
    TasteService tasteService;

    /**
     * 添加一组关注
     *
     * @param taste
     * @return
     */
    @PostMapping("/insertTaste")
    public Result insertTaste(@RequestBody Taste taste) {
        try {
            if (taste == null || taste.getUserId() == null || taste.getCateId() == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加一组关注");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加一组关注");
            }
            return tasteService.insertTaste(taste);
        } catch (Exception e) {
            logger.error("添加一组关注error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加一组关注");
        }
    }

    /**
     * 删除一组关注
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteTasteById/{id}")
    public Result deleteTasteById(@PathVariable("id") Integer id) {
        try {
            if (id == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 删除一组关注");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 删除一组关注");
            }
            return tasteService.deleteTasteById(id);
        } catch (Exception e) {
            logger.error("删除一组关注error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 删除一组关注");
        }
    }

    /**
     * 根据用户id查询关注标签
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectTasteByUserId/{userId}")
    public Result selectTasteByUserId(@PathVariable("userId") Integer userId) {
        try {
            if (userId == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据用户id查询关注标签");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据用户id查询关注标签");
            }
            return tasteService.selectTasteByUserId(userId);
        } catch (Exception e) {
            logger.error("根据用户id查询关注标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据用户id查询关注标签");
        }
    }

    /**
     * 根据标签id查询关注标签
     *
     * @param cateId
     * @return
     */
    @GetMapping("/selectTasteByCateId/{cateId}")
    public Result selectTasteByCateId(@PathVariable("cateId") Integer cateId) {
        try {
            if (cateId == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据标签id查询关注标签");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据标签id查询关注标签");
            }
            return tasteService.selectTasteByCateId(cateId);
        } catch (Exception e) {
            logger.error("根据标签id查询关注标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据标签id查询关注标签");
        }
    }

}
