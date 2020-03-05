package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.dao.TasteMapper;
import cn.zzuli.news.entity.Taste;
import cn.zzuli.news.service.TasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TasteServiceImpl implements TasteService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(TasteServiceImpl.class);
    @Autowired
    TasteMapper tasteMapper;

    /**
     * 添加一组关注
     *
     * @param taste
     * @return
     * @throws Exception
     */
    @Override
    public Result insertTaste(Taste taste) throws Exception {
        if (tasteMapper.insert(taste) == 1) {
            logger.info("添加一组关注, 成功");
            return Result.success();
        } else {
            logger.info("添加一组关注, 失败");
            return Result.fail(ErrorCode.AddIsErrorCode, ErrorCode.AddIsErrorInfo + ", 添加一组关注");
        }
    }

    /**
     * 删除一组关注
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result deleteTasteById(Integer id) throws Exception {
        if (tasteMapper.deleteByPrimaryKey(id) == 1) {
            logger.info("删除一组关注, 成功");
            return Result.success();
        } else {
            logger.info("删除一组关注, 失败");
            return Result.fail(ErrorCode.DeleteIsErrorCode, ErrorCode.DeleteIsErrorInfo + ", 删除一组关注");
        }
    }

    /**
     * 根据标签id删除所有标签关注
     *
     * @param cateId
     * @return
     * @throws Exception
     */
    @Override
    public Result deleteTasteByCateId(Integer cateId) throws Exception {
        int result = tasteMapper.deleteTasteByCateId(cateId);
        if (result > 0) {
            logger.info("根据标签id: " + cateId + " 删除" + result + "个标签关注, 成功");
            return Result.success();
        } else {
            logger.info("根据标签id删除所有标签关注, 失败");
            return Result.fail(ErrorCode.DeleteIsErrorCode, ErrorCode.DeleteIsErrorInfo + ", 根据标签id删除所有标签关注");
        }
    }

    /**
     * 根据用户id查询关注标签
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Result selectTasteByUserId(Integer userId) throws Exception {
        List<Taste> tastes = tasteMapper.selectTasteByUserId(userId);
        if (tastes == null || CollectionUtils.isEmpty(tastes)) {
            logger.info("根据用户id查询关注标签, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据id查询用户信息");
        } else {
            logger.info("根据用户id查询关注标签, 成功");
            return Result.success(tastes);
        }
    }

    /**
     * 根据标签id查询关注标签
     *
     * @param cateId
     * @return
     * @throws Exception
     */
    @Override
    public Result selectTasteByCateId(Integer cateId) throws Exception {
        List<Taste> tastes = tasteMapper.selectTasteBycateId(cateId);
        if (tastes == null || CollectionUtils.isEmpty(tastes)) {
            logger.info("根据标签id查询关注标签, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据标签id查询关注标签");
        } else {
            logger.info("根据标签id查询关注标签, 成功");
            return Result.success(tastes);
        }
    }
}
