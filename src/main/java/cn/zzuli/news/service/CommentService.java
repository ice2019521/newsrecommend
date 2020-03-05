package cn.zzuli.news.service;

import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.Comment;

public interface CommentService {
    /**
     * 添加评论
     *
     * @param comment
     * @return
     * @throws Exception
     */
    Result insertComment(Comment comment) throws Exception;

    /**
     * 根据用户id查询评论
     *
     * @param userId
     * @return
     * @throws Exception
     */
    Result selectCommentByUserId(Integer userId) throws Exception;

    /**
     * 根据新闻id查询评论
     *
     * @param newsId
     * @return
     * @throws Exception
     */
    Result selectCommentByNewsId(Integer newsId) throws Exception;

    /**
     * 修改评论状态
     *
     * @param comment
     * @return
     * @throws Exception
     */
    Result updateComment(Comment comment) throws Exception;
}
