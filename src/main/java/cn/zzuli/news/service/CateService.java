package cn.zzuli.news.service;

import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.Cate;

public interface CateService {
    /**
     * 添加分类标签
     * @param cate
     * @return
     * @throws Exception
     */
    Result insertCate(Cate cate) throws Exception;

    /**
     * 根据id删除分类标签
     * @param id
     * @return
     * @throws Exception
     */
    Result deleteCate(Integer id) throws Exception;

    /**
     * 获取全部标签
     * @return
     * @throws Exception
     */
    Result selectCateAll() throws Exception;

    /**
     * 根据id修改标签名称
     * @param cate
     * @return
     * @throws Exception
     */
    Result updateCateById(Cate cate) throws Exception;

    /**
     * 根据id获取标签
     * @param id
     * @return
     * @throws Exception
     */
    Result selectCateById(Integer id) throws Exception;
}
