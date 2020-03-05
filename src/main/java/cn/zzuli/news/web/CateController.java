package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.common.util.StringUtil;
import cn.zzuli.news.entity.Cate;
import cn.zzuli.news.service.CateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cate")
public class CateController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(CateController.class);
    @Autowired
    CateService cateService;

    /**
     * 添加分类标签
     * @param cate
     * @return
     */
    @PostMapping("/insertCate")
    public Result insertCate(@RequestBody Cate cate) {
        try {
            if (cate == null || StringUtil.isEmpty(cate.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加分类标签");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加分类标签");
            }
            return cateService.insertCate(cate);
        } catch (Exception e) {
            logger.error("添加分类标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加分类标签");
        }
    }

    /**
     * 根据id修改标签名称
     * @param cate
     * @return
     */
    @PutMapping("/updateCateById")
    public Result updateCateById(@RequestBody Cate cate) {
        try {
            if (cate == null || cate.getId()==null || StringUtil.isEmpty(cate.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改标签名称");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改标签名称");
            }
            return cateService.updateCateById(cate);
        } catch (Exception e) {
            logger.error("根据id修改标签名称error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id修改标签名称");
        }
    }

    /**
     * 根据id删除分类标签
     * @param id
     * @return
     */
    @GetMapping("/deleteCate/{id}")
    public Result deleteCate(@PathVariable Integer id) {
        try {
            if (id == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id删除分类标签");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id删除分类标签");
            }
            return cateService.deleteCate(id);
        } catch (Exception e) {
            logger.error("根据id删除分类标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id删除分类标签");
        }
    }

    /**
     * 获取全部标签
     * @return
     */
    @GetMapping("/selectCateAll")
    public Result selectCateAll() {
        try {
            return cateService.selectCateAll();
        } catch (Exception e) {
            logger.error("获取全部标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 获取全部标签");
        }
    }

    /**
     * 根据id获取标签
     * @param id
     * @return
     */
    @GetMapping("/selectCateById/{id}")
    public Result selectCateById(@PathVariable("id") Integer id) {
        try {
            return cateService.selectCateById(id);
        } catch (Exception e) {
            logger.error("根据id获取标签error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id获取标签");
        }
    }

}
