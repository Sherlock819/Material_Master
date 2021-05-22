package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.UserRepo;

@Service
public class Admin {
	
	@Autowired
	UserRepo alRepo;
	
	public ModelAndView getUserDetailsForAdmin(String page)
	{
		List users = alRepo.findAll();
		ModelAndView mv = new ModelAndView(page);
		mv.addObject("users",users);
		
		return mv;
	}
}
