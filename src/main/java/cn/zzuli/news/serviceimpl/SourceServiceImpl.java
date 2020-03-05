package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.dao.SourceMapper;
import cn.zzuli.news.entity.Source;
import cn.zzuli.news.service.SourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(SourceServiceImpl.class);
    @Autowired
    SourceMapper sourceMapper;

    /**
     * 添加来源
     * @param source
     * @return
     * @throws Exception
     */
    @Override
    public Result insertSource(Source source) throws Exception {
        if (sourceMapper.insert(source)==1){
            logger.info("添加来源, 成功");
            return Result.success();
        } else {
            logger.info("添加来源, 失败");
            return Result.fail(ErrorCode.AddIsErrorCode, ErrorCode.AddIsErrorInfo + ", 添加来源");
        }
    }

    /**
     * 根据id修改来源名称
     * @param source
     * @return
     * @throws Exception
     */
    @Override
    public Result updateSourceById(Source source) throws Exception {
        if (sourceMapper.updateByPrimaryKey(source)==1){
            logger.info("根据id修改来源名称, 成功");
            return Result.success();
        } else {
            logger.info("根据id修改来源名称, 失败");
            return Result.fail(ErrorCode.UpdateErrorCode, ErrorCode.UpdateErrorInfo + ", 根据id修改来源名称");
        }
    }

    /**
     * 根据id删除来源
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result deleteSource(Integer id) throws Exception {
        if (sourceMapper.deleteByPrimaryKey(id)==1){
            logger.info("根据id删除来源, 成功");
            return Result.success();
        } else {
            logger.info("根据id删除来源, 失败");
            return Result.fail(ErrorCode.DeleteIsErrorCode, ErrorCode.DeleteIsErrorInfo + ", 根据id删除来源");
        }
    }

    /**
     * 获取全部来源
     * @return
     * @throws Exception
     */
    @Override
    public Result selectSourceAll() throws Exception {
        List<Source> sources = sourceMapper.selectSourceAll();
        if (sources == null || CollectionUtils.isEmpty(sources)) {
            logger.info("获取全部来源, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 获取全部来源");
        } else {
            logger.info("获取全部来源, 成功");
            return Result.success(sources);
        }
    }

    /**
     * 根据id获取来源
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result selectSourceById(Integer id) throws Exception {
        Source source = sourceMapper.selectByPrimaryKey(id);
        if (source == null) {
            logger.info("根据id获取来源, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据id获取来源");
        } else {
            logger.info("根据id获取来源, 成功");
            return Result.success(source);
        }
    }
}
