package com.qhcs.ssm.service.impl.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.article.ArticleDao;
import com.qhcs.ssm.entity.article.Article;
import com.qhcs.ssm.page.article.ArticlePage;
import com.qhcs.ssm.service.article.ArticleService;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * 文章服务接口
 * 
 * @version 2017年5月23日上午10:21:34
 * @author zhuwenbin
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public ArticlePage getArticleList(ArticlePage articlePage) {
		// 查询符合条件数据数目
		int count = articleDao.findCount(articlePage);
		if (count > 0) {
			// 设置符合条件数据数目
			articlePage.setTotalElements(count);
			// 分页查询符合条件的数据
			List<Object> articles = articleDao.findList(articlePage);
			// 设置查询结果
			articlePage.setDatas(articles);
		}
		return articlePage;
	}

	// @Override
	// // @Cacheable(value = "userCache", key = "#id")
	// public Article getArticleById(int id) {
	// Article article = null;
	// Object object = EHCacheUtil.getValue("userCache", "article:" + id);
	// if (object == null) {
	// System.out.println("根据文章id查询文章信息");
	// article = articleDao.findById(id);
	// EHCacheUtil.put("userCache", "article:" + id, article);
	// } else {
	// article = (Article) object;
	// }
	// return article;
	// }

	@Override
	public Article getArticleById(int id) {
		Article article = new Article();
		String title = jedisCluster.get("article:" + id);
		if (title == null) {
			synchronized (ArticleServiceImpl.class) {
				if (title == null) {
					System.out.println("根据文章id查询文章信息");
					article = articleDao.findById(id);
					title = article.getTitle();
					jedisCluster.set("article:" + id, article.getTitle());
					jedisCluster.expire("article:" + id, 30);
				}
			}
		} else {
			article.setTitle(title);
		}
		return article;
	}

	@Override
	public boolean addArticle(Article article) {
		return articleDao.insert(article) > 0 ? true : false;
	}

	@Override
	public boolean updateArticle(Article article) {
		return articleDao.update(article) > 0 ? true : false;
	}

	@Override
	public boolean deleteArticle(Integer[] ids) {
		return articleDao.deleteByIds(ids) > 0 ? true : false;
	}

}
