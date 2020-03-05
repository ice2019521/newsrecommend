package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.common.util.StringUtil;
import cn.zzuli.news.entity.Source;
import cn.zzuli.news.service.SourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/source")
public class SourceController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(SourceController.class);
    @Autowired
    SourceService sourceService;
    
    /**
     * 添加来源
     * @param source
     * @return
     */
    @PostMapping("/insertSource")
    public Result insertSource(@RequestBody Source source) {
        try {
            if (source == null || StringUtil.isEmpty(source.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加来源");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加来源");
            }
            return sourceService.insertSource(source);
        } catch (Exception e) {
            logger.error("添加来源error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加来源");
        }
    }

    /**
     * 根据id修改来源名称
     * @param source
     * @return
     */
    @PutMapping("/updateSourceById")
    public Result updateSourceById(@RequestBody Source source) {
        try {
            if (source == null || source.getId()==null || StringUtil.isEmpty(source.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改来源名称");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id修改来源名称");
            }
            return sourceService.updateSourceById(source);
        } catch (Exception e) {
            logger.error("根据id修改来源名称error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id修改来源名称");
        }
    }

    /**
     * 根据id删除来源
     * @param id
     * @return
     */
    @GetMapping("/deleteSource/{id}")
    public Result deleteSource(@PathVariable Integer id) {
        try {
            if (id == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据id删除来源");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据id删除来源");
            }
            return sourceService.deleteSource(id);
        } catch (Exception e) {
            logger.error("根据id删除来源error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id删除来源");
        }
    }

    /**
     * 获取全部来源
     * @return
     */
    @GetMapping("/selectSourceAll")
    public Result selectSourceAll() {
        try {
            return sourceService.selectSourceAll();
        } catch (Exception e) {
            logger.error("获取全部来源error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 获取全部来源");
        }
    }

    /**
     * 根据id获取来源
     * @param id
     * @return
     */
    @GetMapping("/selectSourceById/{id}")
    public Result selectSourceById(@PathVariable("id") Integer id) {
        try {
            return sourceService.selectSourceById(id);
        } catch (Exception e) {
            logger.error("根据id获取来源error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据id获取来源");
        }
    }
}
