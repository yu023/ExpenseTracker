package expenseTracker.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import expenseTracker.service.AdminService;
import expenseTracker.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/totalChart")
	public String total() {
		return "user/totalChart";
	}
	
	@RequestMapping("/createList")
	@ResponseBody
	public HashMap<String, Object> createList(@RequestBody HashMap<String, Object> map) {
		return userService.createList(map);
	}
	
	@RequestMapping("/insert")
	public String insert() {
		return "user/insertMoney";
	}
	
	@RequestMapping("/insertMoney")
	@ResponseBody
	public HashMap<String,Object> insertMoney(@RequestBody String map) {
		return userService.insertMoney(map);
	}
	
	@RequestMapping("/getAmount")
	@ResponseBody
	public Integer getAmount() {
		return userService.getAmount();
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	
	@RequestMapping("/cateList")
	@ResponseBody
	public List<String> cateList(){
		return adminService.searchCategory();
	}

	@RequestMapping("/addCateForm")
	@ResponseBody
	public List<String> addCateForm(@RequestBody HashMap<String, Object> map) {
		adminService.insertCategory(map.get("addCate").toString());
		return cateList();
	}
	
	@RequestMapping("/removeCate")
	@ResponseBody
	public List<String> removeCate(@RequestBody HashMap<String, Object> map) {
		adminService.deleteCategory(map.get("removeCate").toString());
		return cateList();
	}
	
}
