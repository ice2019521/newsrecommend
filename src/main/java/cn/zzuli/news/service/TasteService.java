package cn.zzuli.news.service;

import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.Taste;

public interface TasteService {
    /**
     * 添加一组关注
     *
     * @param taste
     * @return
     * @throws Exception
     */
    Result insertTaste(Taste taste) throws Exception;

    /**
     * 删除一组关注
     *
     * @param id
     * @return
     * @throws Exception
     */
    Result deleteTasteById(Integer id) throws Exception;

    /**
     * 根据标签id删除所有标签关注
     *
     * @param cateId
     * @return
     * @throws Exception
     */
    Result deleteTasteByCateId(Integer cateId) throws Exception;

    /**
     * 根据用户id查询关注标签
     *
     * @param userId
     * @return
     * @throws Exception
     */
    Result selectTasteByUserId(Integer userId) throws Exception;

    /**
     * 根据标签id查询关注标签
     *
     * @param cateId
     * @return
     * @throws Exception
     */
    Result selectTasteByCateId(Integer cateId) throws Exception;
}
