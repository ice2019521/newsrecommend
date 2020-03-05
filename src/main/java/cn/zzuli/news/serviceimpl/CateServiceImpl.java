package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.dao.CateMapper;
import cn.zzuli.news.dao.TasteMapper;
import cn.zzuli.news.entity.Cate;
import cn.zzuli.news.service.CateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CateServiceImpl implements CateService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(CateServiceImpl.class);
    @Autowired
    CateMapper cateMapper;
    @Autowired
    TasteMapper tasteMapper;

    /**
     * 添加分类标签
     *
     * @param cate
     * @return
     * @throws Exception
     */
    @Override
    public Result insertCate(Cate cate) throws Exception {
        if (cateMapper.insert(cate) == 1) {
            logger.info("添加分类标签, 成功");
            return Result.success();
        } else {
            logger.info("添加分类标签, 失败");
            return Result.fail(ErrorCode.AddIsErrorCode, ErrorCode.AddIsErrorInfo + ", 添加分类标签");
        }
    }

    /**
     * 根据id删除分类标签(级联删除用户关注标签)
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Result deleteCate(Integer id) throws Exception {
        if (cateMapper.deleteByPrimaryKey(id) == 1) {
            int result = tasteMapper.deleteTasteByCateId(id);
            logger.info("根据id: " + id + " 删除分类标签,级联删除用户关注标签" + result + " 个, 成功");
            return Result.success();
        } else {
            logger.info("根据id删除分类标签, 失败");
            return Result.fail(ErrorCode.DeleteIsErrorCode, ErrorCode.DeleteIsErrorInfo + ", 根据id删除分类标签");
        }
    }

    /**
     * 获取全部标签
     *
     * @return
     * @throws Exception
     */
    @Override
    public Result selectCateAll() throws Exception {
        List<Cate> cates = cateMapper.selectCateAll();
        if (cates == null || CollectionUtils.isEmpty(cates)) {
            logger.info("获取全部标签, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 获取全部标签");
        } else {
            logger.info("获取全部标签, 成功");
            return Result.success(cates);
        }
    }

    /**
     * 根据id修改标签名称
     *
     * @param cate
     * @return
     * @throws Exception
     */
    @Override
    public Result updateCateById(Cate cate) throws Exception {
        if (cateMapper.updateByPrimaryKey(cate) == 1) {
            logger.info("根据id修改标签名称, 成功");
            return Result.success();
        } else {
            logger.info("根据id修改标签名称, 失败");
            return Result.fail(ErrorCode.UpdateErrorCode, ErrorCode.UpdateErrorInfo + ", 根据id修改标签名称");
        }
    }

    /**
     * 根据id获取标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result selectCateById(Integer id) throws Exception {
        Cate cate = cateMapper.selectByPrimaryKey(id);
        if (cate == null) {
            logger.info("根据id获取标签, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据id获取标签");
        } else {
            logger.info("根据id获取标签, 成功");
            return Result.success(cate);
        }
    }
}
