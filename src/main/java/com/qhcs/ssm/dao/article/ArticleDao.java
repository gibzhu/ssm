package com.qhcs.ssm.dao.article;

import org.springframework.stereotype.Repository;

import com.qhcs.ssm.common.dao.BaseDao;
import com.qhcs.ssm.entity.article.Article;

/**
 * 
 * 文章数据库访问接口
 * 
 * @version 2017年5月23日上午10:10:19
 * @author zhuwenbin
 */
@Repository
public interface ArticleDao extends BaseDao<Article> {

	/**
	 * 
	 * 删除文章
	 * 
	 * @version 2017年5月24日下午5:40:22
	 * @author zhuwenbin
	 * @param ids
	 * @return
	 */
	public int deleteByIds(Integer[] ids);

}
