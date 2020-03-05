package cn.zzuli.news.web;

import cn.zzuli.news.common.result.ErrorCode;
import cn.zzuli.news.common.result.Result;
import cn.zzuli.news.entity.News;
import cn.zzuli.news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;

    /**
     * 添加新闻
     *
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    public Result insertNews(@RequestBody News news) {
        try {
            if (news == null) {
                logger.error(ErrorCode.ParaCheckErrorRetInfo + ", 添加用户");
                return Result.fail(ErrorCode.ParaCheckErrorRetCode, ErrorCode.ParaCheckErrorRetInfo + ", 添加新闻");
            }
            return newsService.insertNews(news);
        } catch (Exception e) {
            logger.error("添加新闻error: ", e);
            return Result.fail(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + ", 添加新闻");
        }
    }
}
