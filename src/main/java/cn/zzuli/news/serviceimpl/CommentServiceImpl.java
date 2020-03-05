package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.dao.CommentMapper;
import cn.zzuli.news.entity.Comment;
import cn.zzuli.news.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Autowired
    CommentMapper commentMapper;

    /**
     * 添加评论
     *
     * @param comment
     * @return
     * @throws Exception
     */
    @Override
    public Result insertComment(Comment comment) throws Exception {
        //设置评论可见
        comment.setStatus(1);
        if (commentMapper.insertSelective(comment) == 1) {
            logger.info("添加评论, 成功");
            return Result.success();
        } else {
            return Result.fail(ErrorCode.AddIsErrorCode, ErrorCode.AddIsErrorInfo + ", 添加评论");
        }
    }

    /**
     * 根据用户id查询评论
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Result selectCommentByUserId(Integer userId) throws Exception {
        List<Comment> comments = commentMapper.selectCommentByUserId(userId);
        if (comments == null || CollectionUtils.isEmpty(comments)) {
            logger.info("根据用户id查询评论, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据用户id查询评论");
        } else {
            logger.info("根据用户id查询评论, 成功");
            return Result.success(comments);
        }
    }

    /**
     * 根据新闻id查询评论
     *
     * @param newsId
     * @return
     * @throws Exception
     */
    @Override
    public Result selectCommentByNewsId(Integer newsId) throws Exception {
        List<Comment> comments = commentMapper.selectCommentByNewsId(newsId);
        if (comments == null || CollectionUtils.isEmpty(comments)) {
            logger.info("根据新闻id查询评论, 失败");
            return Result.fail(ErrorCode.GetErrorCode, ErrorCode.GetErrorInfo + ", 根据新闻id查询评论");
        } else {
            logger.info("根据新闻id查询评论, 成功");
            return Result.success(comments);
        }
    }

    /**
     * 修改评论
     *
     * @param comment
     * @return
     * @throws Exception
     */
    @Override
    public Result updateComment(Comment comment) throws Exception {
        if (commentMapper.updateByPrimaryKeySelective(comment) == 1) {
            logger.info("修改评论, 成功");
            return Result.success();
        } else {
            return Result.fail(ErrorCode.UpdateErrorCode, ErrorCode.UpdateErrorInfo + ", 修改评论");
        }
    }

}
