package com.qhcs.ssm.controller.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qhcs.ssm.common.controller.BaseController;
import com.qhcs.ssm.entity.article.Article;
import com.qhcs.ssm.page.article.ArticlePage;
import com.qhcs.ssm.service.article.ArticleService;

/**
 * 
 * 文章控制类
 * 
 * @version 2017年5月23日上午10:25:25
 * @author zhuwenbin
 */
@Controller
public class ArticleController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	/**
	 * 
	 * 分页查询符合条件的文章
	 * 
	 * @version 2017年5月23日上午10:25:35
	 * @author zhuwenbin
	 * @param articlePage
	 * @param model
	 * @return
	 */
	@RequestMapping("/article")
	public String articleList(ArticlePage articlePage, Model model) {
		log.info("执行前: " + JSON.toJSONString(articlePage));
		articleService.getArticleList(articlePage);
		log.info("执行后: " + JSON.toJSONString(articlePage));
		// 返回分页实体
		model.addAttribute("page", articlePage);
		return "article/article";
	}

	/**
	 * 
	 * 根据id查询文章
	 * 
	 * @version 2017年5月23日上午10:27:23
	 * @author zhuwenbin
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/article/{id}")
	public String article(@PathVariable("id") String id, Model model) {
		Article article = articleService.getArticleById(Integer.parseInt(id));
		model.addAttribute("article", article);
		return "article/articleDetail";
	}

	/**
	 * 
	 * 新增文章
	 * 
	 * @version 2017年5月24日上午11:55:17
	 * @author zhuwenbin
	 * @param article
	 * @return
	 */
	@PostMapping("/addArticle")
	@ResponseBody
	public String addArticle(Article article) {
		boolean result = articleService.addArticle(article);
		return result ? "success" : "failure";
	}

	/**
	 * 
	 * 根据id获取文章
	 * 
	 * @version 2017年5月24日下午4:05:03
	 * @author zhuwenbin
	 * @param id
	 * @return
	 */
	@GetMapping("/getArticleById")
	@ResponseBody
	public Article getArticleById(@RequestParam("id") Integer id) {
		return articleService.getArticleById(id);
	}

	/**
	 * 
	 * 修改文章
	 * 
	 * @version 2017年5月24日下午4:42:02
	 * @author zhuwenbin
	 * @param article
	 * @param model
	 * @return
	 */
	@PostMapping("/updateArticle")
	@ResponseBody
	public String updateArticle(Article article) {
		boolean result = articleService.updateArticle(article);
		return result ? "success" : "failure";
	}

	/**
	 * 
	 * 删除文章
	 * 
	 * @version 2017年5月24日下午5:37:47
	 * @author zhuwenbin
	 * @param article
	 * @return
	 */
	@PostMapping("/deleteArticle")
	@ResponseBody
	public String deleteArticle(@RequestParam("ids[]") Integer[] ids) {
		boolean result = articleService.deleteArticle(ids);
		return result ? "success" : "failure";
	}
}
