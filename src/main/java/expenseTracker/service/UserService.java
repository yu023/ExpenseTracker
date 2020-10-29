package expenseTracker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import expenseTracker.dao.UserDao;
import expenseTracker.dto.BankBook;

@Service
public class UserService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public HashMap<String,Object> insertMoney(String map) {
		String[] mapArr = null;
		Integer selectAmount = 0;
		Integer resultInt = 0;
		Object resultNum = 0;
		HashMap<String,Object> myMap = new HashMap<String,Object>();
		List<Integer> myList = new ArrayList<>();
		
		if(map.length() > 0) {
			
			map = map.substring(2, map.length()-2);
			selectAmount = getAmount();
			
			if(map.contains("},{")) {
				mapArr = map.split("\\}[,]\\{");
				
				if(null == selectAmount) {
					mapArr[0] += ", \"bb_amount\":null";
				}
				
				for(int i = 0; i < mapArr.length; i++) {
					myMap = strJsonParser("{" + mapArr[i] + "}");
					myMap.put("bb_amount", userDao.selectAmount());
					if(!((Boolean) myMap.get("inputRadio")) && Integer.valueOf(myMap.get("bb_amount").toString()) < Integer.valueOf(myMap.get("moneyInput").toString())) {
						resultInt = 0;
						resultNum = myMap.get("listNumber");
					}else {
						resultInt = userDao.insertMoney(myMap);
						myList.add(Integer.valueOf(myMap.get("listNumber").toString()));
					}
				}
				
			}else {
				if(null == selectAmount) {
					map += ", \"bb_amount\":null";
				}
				myMap = strJsonParser("{" + map + "}");
				myMap.put("bb_amount", userDao.selectAmount());
				if(!((Boolean) myMap.get("inputRadio")) && Integer.valueOf(myMap.get("bb_amount").toString()) < Integer.valueOf(myMap.get("moneyInput").toString())) {
					resultInt = 0;
					resultNum = myMap.get("listNumber");
				}else {
					resultInt = userDao.insertMoney(myMap);
					myList.add(Integer.valueOf(myMap.get("listNumber").toString()));
				}
			}
			
			
			myMap.put("amount", userDao.selectAmount());
			myMap.put("myNumList", myList);
			
			if(resultInt > 0) {
				myMap.put("msg", "정상 기입되었습니다.");
			}else {
				myMap.put("msg", resultNum + "번째 항목에서 오류가 발생했습니다.");
			}
		}
		return myMap;
	}
	
	public Integer getAmount() {
		return userDao.selectAmount();
	}
	
	public HashMap<String, Object> createList(HashMap<String, Object> map) {
		List<BankBook> bankBook1 = userDao.selectGBCategory(map);
		List<BankBook> bankBook2 = userDao.selectMoney(map);
		map.clear();
		map.put("selectGBCategory", bankBook1);
		map.put("selectMoney", bankBook2);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> strJsonParser(String str){
		JSONParser parser = new JSONParser(str);
		try {
			return (HashMap<String, Object>) parser.parse();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
