package cn.zzuli.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("cn.zzuli.news.dao")
@SpringBootApplication
@EnableTransactionManagement
public class NewsRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsRecommendApplication.class, args);
    }

}
