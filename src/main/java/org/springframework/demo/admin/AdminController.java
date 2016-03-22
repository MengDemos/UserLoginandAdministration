package org.springframework.demo.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.dao.UserDao;
import org.springframework.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * View controller for admin ui.
 * @author 
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private UserDao userDao;

	/**
	 * Handles HTTP GET request for "/admin/userlist", displays a list of all users for admin.
	 * @return userlist.jsp
	 */
	@RequestMapping(value = "/admin/userlist", method = RequestMethod.GET)
	public String showUserList(ModelMap model) {
		
		model.addAttribute("users", userDao.getAllUser());
		return "userlist";
	}

	/**
	 * Handles HTTP GET request for "/admin/adduser", shows adduser page 
	 * @return adduser.jsp
	 */
	@RequestMapping(value = "/admin/adduser", method = RequestMethod.GET)
	public String showAddUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "adduser";
	}

	/**
	 * Handles HTTP POST request for "/admin/adduser", the validation process ensures that requested object User match validation constraints.
	 * @param user User object
	 * @return adduser.jsp if a validation error occurs, otherwise redirect to userlist.jsp
	 */
	@RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
	public String addUser(ModelMap model, @Valid User user, BindingResult result) {

		if (result.hasErrors()){
			return "adduser";
		}
		userDao.addUser(user);
		model.clear();
		return "redirect:/admin/userlist";
	}


	/**
	 * Handles HTTP GET request for "/admin/updateuser", shows adduser page and displays requested object User.
	 * @return adduser.jsp
	 */
	@RequestMapping(value = "/admin/updateuser", method = RequestMethod.GET)
	public String showUpdateUserPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("user", userDao.getUser(id));
		return "adduser";
	}

	/**
	 * Handles HTTP POST request for "/admin/updateuser"
	 * @param user User object
	 * @return adduser.jsp if a validation error occurs, otherwise redirect to userlist.jsp
	 */
	@RequestMapping(value = "/admin/updateuser", method = RequestMethod.POST)
	public String updateTodo(@Valid User user, BindingResult result) {
		
		if (result.hasErrors()){
			return "adduser";
		}
		
		int id = user.getId();
		userDao.updateUser(id, user);

		return "redirect:/admin/userlist";
	}

	/**
	 * Handles HTTP GET request for "/admin/deleteuser".
	 * @param id user id
	 * @return userlist.jsp
	 */
	@RequestMapping(value = "/admin/deleteuser", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		
		userDao.deleteUser(id);
		return "redirect:/admin/userlist";
	}
	
}
