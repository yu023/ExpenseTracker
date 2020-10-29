package expenseTracker.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<String> searchCategory() {
		return sqlSession.selectList("adminMappper.searchCategory");
	}
	
	public List<String> searchCategory(String addCate) {
		return sqlSession.selectList("adminMappper.searchCategory", addCate);
	}
	
	public int insertCategory(String addCate) {
		return sqlSession.update("adminMappper.insertCategory", addCate);
	}
	
	public int deleteCategory(String addCate) {
		return sqlSession.update("adminMappper.deleteCategory", addCate);
	}
	
}
