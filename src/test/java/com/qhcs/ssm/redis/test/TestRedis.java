package com.qhcs.ssm.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qhcs.ssm.service.article.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-context.xml", "classpath:spring/spring-ehcache.xml",
		"classpath:spring/spring-shiro.xml", "classpath:spring/spring-mvc.xml", "classpath:spring/spring-redis.xml", })
public class TestRedis {

	@Autowired
	private ArticleService articleService;

	@Test
	public void test() {
		articleService.getArticleById(1);
	}
}
