package expenseTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import expenseTracker.dao.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	public List<String> searchCategory() {
		return adminDao.searchCategory();
	}
	
	public List<String> searchCategory(String addCate) {
		addCate = addCate.trim();
		return adminDao.searchCategory(addCate);
	}
	
	public List<String> insertCategory(String addCate) {
		if(0 == searchCategory(addCate).size()) {
			adminDao.insertCategory(addCate);
		}
		return searchCategory();
	}
	
	public List<String> deleteCategory(String removeCate) {
		if(0 < searchCategory(removeCate).size()) {
			adminDao.deleteCategory(removeCate);
		}
		return searchCategory();
	}

}
