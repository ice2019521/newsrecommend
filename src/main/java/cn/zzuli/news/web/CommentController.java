package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.common.util.StringUtil;
import cn.zzuli.news.entity.Comment;
import cn.zzuli.news.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/insertComment")
    public Result insertComment(@RequestBody Comment comment) {
        try {
            if (comment == null || comment.getUserId() == null || comment.getNewsId() == null || StringUtil.isEmpty(comment.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加评论");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加评论");
            }
            return commentService.insertComment(comment);
        } catch (Exception e) {
            logger.error("添加评论error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加评论");
        }
    }

    /**
     * 根据用户id查询评论
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectCommentByUserId/{userId}")
    public Result selectCommentByUserId(@PathVariable("userId") Integer userId) {
        try {
            if (userId == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据用户id查询评论");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据用户id查询评论");
            }
            return commentService.selectCommentByUserId(userId);
        } catch (Exception e) {
            logger.error("根据用户id查询评论error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据用户id查询评论");
        }
    }

    /**
     * 根据新闻id查询评论
     *
     * @param newsId
     * @return
     */
    @GetMapping("/selectCommentByNewsId/{newsId}")
    public Result selectCommentByNewsId(@PathVariable("newsId") Integer newsId) {
        try {
            if (newsId == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 根据新闻id查询评论");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 根据新闻id查询评论");
            }
            return commentService.selectCommentByNewsId(newsId);
        } catch (Exception e) {
            logger.error("根据新闻id查询评论error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 根据新闻id查询评论");
        }
    }

    /**
     * 修改评论状态(或评论内容)
     *
     * @param comment
     * @return
     */
    @PutMapping("/updateCommentStatus")
    public Result updateCommentStatus(Comment comment) {
        try {
            if (comment == null || comment.getId() == null || comment.getStatus() != null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 修改评论状态");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 修改评论状态");
            }
            return commentService.updateComment(comment);
        } catch (Exception e) {
            logger.error("修改评论状态error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 修改评论状态");
        }
    }

    /**
     * 修改评论内容
     *
     * @param comment
     * @return
     */
    @PutMapping("/updateCommentContent")
    public Result updateCommentContent(Comment comment) {
        try {
            if (comment == null || comment.getId() == null || StringUtil.isEmpty(comment.getContent())) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 修改评论内容");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 修改评论内容");
            }
            return commentService.updateComment(comment);
        } catch (Exception e) {
            logger.error("修改评论内容error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 修改评论内容");
        }
    }

}
