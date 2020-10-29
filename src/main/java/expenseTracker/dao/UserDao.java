package expenseTracker.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import expenseTracker.dto.BankBook;

@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	@Transactional
	public int insertMoney(HashMap<String,Object> map) {
		return sqlSession.insert("userMappper.insertMoney", map);
	}
	
	public List<BankBook> selectMoney() {
		return sqlSession.selectList("userMappper.selectMoney");
	}
	
	public List<BankBook> selectMoney(HashMap<String,Object> map) {
		return sqlSession.selectList("userMappper.selectMoney", map);
	}
	
	public List<BankBook> selectGBCategory(HashMap<String,Object> map) {
		return sqlSession.selectList("userMappper.selectGBCategory", map);
	}
	
	public Integer selectAmount() {
		Integer i = sqlSession.selectOne("userMappper.selectAmount");
		return i;
	}
	
}
