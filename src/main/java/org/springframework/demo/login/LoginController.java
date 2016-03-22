package org.springframework.demo.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * View controller for HTTP request of Login and logout actions.
 */
@Controller
public class LoginController {

	/**
	 * Handles HTTP GET request for "/login" and "/", if authentication failed, errormessage will be displayed on login.jsp.
	 * @return login.jsp 
	 */
	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public String showLoginPage(ModelMap model, @RequestParam(value = "error", required = false) String error){
		if (error != null) {
			model.put("errormessage", "Invalid Credentials");
		}
		return "login";
	}
	
	/**
	 * Handles HTTP GET request for "/welcome", returned pages depends on the authorization.
	 * @return welcome.jsp for "ROLE_USER", userlist.jsp for "ROLE_ADMIN"
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(HttpServletRequest request){
		if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/userlist";
        }
		return "welcome";
        
	}
	
	/**
	 * Handles HTTP GET request for "/403", "/403" is requested when authorization failed.
	 * @return 403.jsp
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String showAccessDenied(ModelMap model) {
		model.put("username", getLoggedInUserName());
        return "403";
	}
	
	/**
	 * Handles HTTP GET request for "/logout".
	 * @return default root path
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
            HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
	
	/**
	 * retrieves username of Logged in user with SecurityContext in current execution thread.
	 * @return
	 */
	private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }
	
	
}
