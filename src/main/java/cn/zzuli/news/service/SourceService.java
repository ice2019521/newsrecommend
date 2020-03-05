package cn.zzuli.news.service;

import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.Source;

public interface SourceService {
    /**
     * 添加来源
     * @param source
     * @return
     * @throws Exception
     */
    Result insertSource(Source source) throws Exception;

    /**
     * 根据id修改来源名称
     * @param source
     * @return
     * @throws Exception
     */
    Result updateSourceById(Source source) throws Exception;

    /**
     * 根据id删除来源
     * @param id
     * @return
     * @throws Exception
     */
    Result deleteSource(Integer id) throws Exception;

    /**
     * 获取全部来源
     * @return
     * @throws Exception
     */
    Result selectSourceAll() throws Exception;

    /**
     * 根据id获取来源
     * @param id
     * @return
     * @throws Exception
     */
    Result selectSourceById(Integer id) throws Exception;
}
