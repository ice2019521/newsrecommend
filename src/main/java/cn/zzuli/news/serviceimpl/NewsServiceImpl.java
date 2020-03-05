package cn.zzuli.news.serviceimpl;

import cn.zzuli.news.dao.NewsMapper;
import cn.zzuli.news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    /**
     * 打印日志
     */
    private final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
    @Autowired
    NewsMapper newsMapper;


}
