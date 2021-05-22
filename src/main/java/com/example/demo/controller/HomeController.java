package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.MaterialRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserVerificationRepo;
import com.example.demo.service.Admin;
import com.example.demo.service.User;
import com.example.demo.entity.MaterialEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserVerification;

@RestController("api")
public class HomeController {
	
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserVerificationRepo userVerificationRepo;
	
	@Autowired
	Admin admin;
	
	@Autowired
	User user;
	
	@Autowired
	MaterialRepo materialRepo;
	
	
//	@GetMapping("registration")
//	public ModelAndView start()
//	{
//		ModelAndView mv = new ModelAndView("registration");
//		return mv;
//	}
	
//	@RequestMapping("home")
//	public String POCServlet(HttpServletRequest rqst)
//	{
//		HttpSession session = rqst.getSession();
//		String name = rqst.getParameter("name");
//		System.out.println("In POC for : "+name);
//		session.setAttribute("name", name);
//		return "Home";
//	}
	
	
	
//	@RequestMapping("home")
//	public ModelAndView POCSpring(@RequestParam("name") String myName)
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",myName);
//		mv.setViewName("Home");
//		return mv;
//	}
	//"@RequestParam" does aliasing
	//View is webpage("Home")
	//Model is data(myname)

	
//	@RequestMapping("home")
//	public ModelAndView POCSpring(Student student)
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("student",student);
//		mv.setViewName("Home");
//		return mv;
//	}
//	
//	@RequestMapping("addStudent")
//	public ModelAndView addStudent(Student student)
//	{
//		ModelAndView mv = new ModelAndView();
//		stRepo.save(student);
//		mv.setViewName("Home");
//		return mv;
//	}
//	
//	@RequestMapping("getStudent")
//	public ModelAndView getStudent(Student student)
//	{
//		ModelAndView mv = new ModelAndView();
//		Student st = stRepo.findByName(student.getName());
//		mv.addObject("student",st);
//		mv.setViewName("Home");
//		return mv;
//	}
//	
	//"@ResponseBody" sends response as web page but we should send data in response not page itself
//	@GetMapping("registration")
//	public ModelAndView getRegistration()
//	{
//		System.out.println("Returning Registration");
//		return new ModelAndView("registrationView");
//	}
//	
//	@GetMapping("login")
//	public ModelAndView getLogin()
//	{
//		System.out.println("Returning login");
//		return new ModelAndView("login");
//	}
	
	@GetMapping("{page}")
	public ModelAndView getPage(@PathVariable String page)
	{
		System.out.println("Returning : "+page);
		return new ModelAndView(page);
	}
	
	
	@GetMapping("verification/{email}")
	public ModelAndView verification(@PathVariable String email )
	{
		System.out.println("Returning Verification with : "+email);
//		System.out.println("Calling Verification for : "+alien.getEmail());
		ModelAndView mv = new ModelAndView("verification");
		mv.addObject("email", email);
		return mv;
	}
	
	@PostMapping("getMaterial")
	@ResponseBody
	public List<MaterialEntity> getMaterial(@RequestBody() Map<String,Integer> data)
	{
		System.out.println(data.get("page")+" "+data.get("dataPerPage"));
		List<MaterialEntity> mData = materialRepo.findAll();
		System.out.println("Returning material data");
		return mData;
	}
	
	@PostMapping("verifyUser")
	@ResponseBody
	public Object verifyUser(@RequestBody UserVerification userVerification)
	{
		System.out.println("User Verification for : "+userVerification.getEmail());
		
		Optional<UserVerification> found;
		
		if( userVerificationRepo.existsById(userVerification.getEmail()) )
		{
			found=userVerificationRepo.findById(userVerification.getEmail());
			if(found.get().getVerificationCode() == (userVerification.getVerificationCode()))
			{
				System.out.println("User Verified!");
				UserEntity entity = userRepo.findById(userVerification.getEmail()).orElse(null);
				entity.setStatus(true);
				userRepo.save(entity);
				return 1; //User Found and verified
			}
			System.out.println("Worng code");
			return 2; //Wrong code
		}
		
		return 3;//
	}
	
	@PostMapping("userLogin")
	@ResponseBody
	public Object userLogin(@RequestBody UserEntity alien)
	{
		System.out.println(alien.getEmail()+" "+alien.getPassword());
		Optional<UserEntity> found;
		
		if( userRepo.existsById(alien.getEmail()) )
		{
			found=userRepo.findById(alien.getEmail());
			if(found.get().getPassword().equals(alien.getPassword()))
			{
				if(found.get().isStatus())
				{
					System.out.println("User Found!");
					return 1; //User Found
				}
				else
				{
					System.out.println("User Found but not verified!");
					return 4; //User Found
				}
			}
			System.out.println("Worng Password");
			return 2; //Wrong password
		}
		System.out.println("Worng email");
		return 3; // Wrong email
	}
	
	@ResponseBody @PostMapping(path="addUser",consumes="application/json",produces="application/json")
	public Object addUser(@RequestBody UserEntity alien)
	{
//		System.out.println(alien.getFname()+" "+alien.getLname()+" "+alien.getPassword()+" "+alien.getDob()+" "+alien.getEmail());
		if(!userRepo.findById(alien.getEmail()).isPresent())
		{
			
			UserVerification userVerification = new UserVerification();
			int code;
			
			userVerification.setEmail(alien.getEmail());
			userVerification.setVerificationCode(code=user.getAccessCode());
			user.sendVerificationEmail(userVerification); //Sends email verification code
			
			user.addUser(alien);
			System.out.println("User Added");
			
			userVerificationRepo.save(userVerification);
			System.out.println("Verfication code generated for email="+alien.getEmail() +" Access Code = "+code);
			
			return alien;
		}
		System.out.println("User Already exists!");
		return false;
		
	}
	
	
	
//	@GetMapping("goto")
//	public ModelAndView gotoPage(String sel)
//	{
//		return this.getPage(sel);
//	}
	
	
//	@PostMapping("login")
//	public ModelAndView login(UserEntity alien)
//	{
//		UserEntity found = userRepo.findById(alien.getEmail()).orElse(null);
//		ModelAndView mv ;
//		if(found!=null && alien.getPassword().equals(found.getPassword()))
//		{
//			mv = new ModelAndView("screenMaterial_U");
//			System.out.println("Recieved : id="+alien.getEmail()+" passowrd="+alien.getPassword());
//			System.out.println("found : id="+found.getEmail()+" passowrd="+found.getPassword());
//		}
//		else
//			mv = new ModelAndView("userLogin");
//	
//		return mv;
//	}
	
	
//	@PostMapping("register")
//	public ModelAndView setAlien(UserEntity alien)
//	{
//		ModelAndView mv = new ModelAndView("userLogin");
//		System.out.println(alien.toString());
//		user.addUser(alien);
//		return mv;
//	}
	
	
	
	
	
	//Use of "produces="application/xml" restricts response only to xml, Now it won't send back JSON(default) even if client asks for it"
	//Use of "consumes="application/json" means server will only accept JSON(default) from client"
	
//	@GetMapping(path="getAliens/{id}",produces="application/json",consumes="application/json")
//	public Optional<UserEntity> getAliens(@PathVariable int id)
//	{
//		return userRepo.findById(id);
//	}
	
	
	//"@RequestBody" states that data is coming in raw form(text,JSON,XML)
//	@PutMapping("addAlien")
//	public List<UserEntity> setOrUpdateAlien(@RequestBody UserEntity alien)
//	{
//		if(alien!=null)
//		{
//			userRepo.save(alien);
//		}
//		return userRepo.findAll();
//	}
	
	//"@PathVariable" states that element is sent embeded in URL
//	@DeleteMapping("deleteAlien/{id}")
//	public List<UserEntity> deleteAlien(@PathVariable int id)
//	{
//		UserEntity a = userRepo.getOne(id);
//		userRepo.delete(a);
//		return userRepo.findAll();
//	}
}
