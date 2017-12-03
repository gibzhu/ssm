package com.qhcs.ssm.service.article;

import com.qhcs.ssm.entity.article.Article;
import com.qhcs.ssm.page.article.ArticlePage;

/**
 * 
 * 文章服务接口
 * 
 * @version 2017年5月23日上午10:21:58
 * @author zhuwenbin
 */
public interface ArticleService {

	/**
	 * 
	 * 分页查询符合条件的文章
	 * 
	 * @version 2017年5月23日上午10:22:09
	 * @author zhuwenbin
	 * @param articlePage
	 * @return
	 */
	public ArticlePage getArticleList(ArticlePage articlePage);

	/**
	 * 
	 * 根据id查询文章
	 * 
	 * @version 2017年5月23日上午10:22:32
	 * @author zhuwenbin
	 * @param id
	 * @return
	 */
	public Article getArticleById(int id);

	/**
	 * 
	 * 新增文章
	 * 
	 * @version 2017年5月24日下午12:10:19
	 * @author zhuwenbin
	 * @param article
	 * @return
	 */
	public boolean addArticle(Article article);

	/**
	 * 
	 * 修改文章
	 * 
	 * @version 2017年5月24日下午4:40:24
	 * @author zhuwenbin
	 * @param article
	 * @return
	 */
	public boolean updateArticle(Article article);

	/**
	 * 
	 * 删除文章
	 * 
	 * @version 2017年5月24日下午5:35:43
	 * @author zhuwenbin
	 * @param article
	 * @return
	 */
	public boolean deleteArticle(Integer[] ids);
}
