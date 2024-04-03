package com.vaccination.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vaccination.dao.UserDao;
import com.vaccination.model.Admin;
import com.vaccination.model.User;
import com.vaccination.model.Vaccination;

@Controller
public class UserController 
{
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("/")
	public ModelAndView getStartupPage()
	{
		mv.setViewName("index.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="user" , params="us")
	public ModelAndView getUserLoginPage()
	{
		mv.setViewName("UserLogin.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="admin" , params="ad")
	public ModelAndView getAdminLoginPage()
	{
		mv.setViewName("adminLogin.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="login" , params="usersignup")
	public ModelAndView getUserSignUpPage()
	{
		mv.setViewName("usersignup.jsp");
		return mv;
		
	}
	
	@RequestMapping("sign")
	public ModelAndView insertUser(HttpServletRequest request)
	{
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPassword");
		long m = Long.parseLong(request.getParameter("tbMob"));
		long a = Long.parseLong(request.getParameter("tbAadhar"));
		
		User user = new User(n,e,p,m,a);
		
		UserDao.insertUserDao(user);
		
		mv.setViewName("UserLogin.jsp");
		return mv;
		
	}
	
	@RequestMapping("home")
	public ModelAndView getHomePage()
	{
		mv.setViewName("UserHome.jsp");
		return mv;
		
	}
	
	@RequestMapping("adminLogin")
	public ModelAndView HomePage(HttpServletRequest request, HttpServletResponse response)
	{
		
		String email = request.getParameter("tbEmail");
		String password = request.getParameter("tbPassword");
		
		
		Admin a = new Admin(email,password);
		UserDao ad = new UserDao();
		String status = ad.checkLogin(a);
		if(status.equals("success"))
		{
			mv.setViewName("adminHome.jsp");
		}
		else
		{
			mv.setViewName("adminLogin.jsp");
		}
		
	
		//mv.setViewName("home.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="addvaccination" , params="add")
	public ModelAndView getAddVaccineCenterPage()
	{
		mv.setViewName("AddVaccination.jsp");
		return mv;
		
	}
	
	@RequestMapping("addvc")
	public ModelAndView insertVaccineCenter(HttpServletRequest request)
	{
		int cn = Integer.parseInt(request.getParameter("tbCvcno"));
		String s = request.getParameter("tbSupervisor");
		String vc = request.getParameter("tbVaccinecenter");
		String vn = request.getParameter("tbvaccinename");
		String d = request.getParameter("tbDose");
		String n = request.getParameter("tbNameperson");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		String dt = request.getParameter("tbDatetime");
		
		Vaccination vaccination = new Vaccination(cn,s,vc,vn,d,n,m,dt);
		
		UserDao.insertVaccineCenterDao(vaccination);
		
		mv.setViewName("adminHome.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="displayvaccination", params="display")
	public ModelAndView displayDoseDetails()
	{
		//read the data we got from student table
		ArrayList<Vaccination> vac = UserDao.getAllDoseDetailsDao();
		
		//store the above arraylist in atrribute
		
		mv.addObject("vaccinations",vac);
		//redirect user to display.jsp
		mv.setViewName("adminHome.jsp");
		return mv;
		
	}
	
	
	@RequestMapping("delete")
	public ModelAndView deleteUser(int cvcno)
	{
		UserDao.delete(cvcno);
		
		mv.setViewName("adminHome.jsp");
		return mv;
		
	}
	
	@RequestMapping(value = "search", params = "btnSearch")
	public ModelAndView displayVaccineCenterDetails(HttpServletRequest request)
	{
		String vaccineCenter = request.getParameter("tbVaccinecenter");
	   // String workingHour = request.getParameter("tbDatetime");
	    
		//read the data we got from student table
		ArrayList<Vaccination> vac = UserDao.getAllCenterDeatilDao(vaccineCenter);
	    //ArrayList<Vaccination> vac = UserDao.getAllCenterDeatilDao(vaccineCenter);
		//store the above arraylist in atrribute
		
		if (vac.isEmpty()) {
	        // If the result is empty, set an error message
	        mv.addObject("errorMessage", "No matching records found.");
	        mv.setViewName("UserHome.jsp");
	    } else {
	        // If records are found, add them to the model and set the view to UserHome.jsp
	        mv.addObject("searchs", vac);
	        mv.setViewName("UserHome.jsp");
	    }
		return mv;
		
	}
	
	@RequestMapping(value = "logout", params = "log")
	public ModelAndView logout(HttpServletRequest request) {
	    // Invalidate the user session
	    request.getSession().invalidate();

	    // Redirect to the login page or any other page after logout
	    ModelAndView mv = new ModelAndView("index.jsp");
	    return mv;
	}

	
}
