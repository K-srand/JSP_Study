package sec03.brd04;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
		
	public int addArticle(ArticleVO article){
		return boardDAO.insertNewArticle(article);		
	}
	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		//조회수를 하나 증가시켜주는 SQL 문을 작성해야 합니다.
		return article;
	}
	
}
