package com.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {
	
	@RequestMapping(value="/*", method = {RequestMethod.GET})
    public ModelAndView urlTest(){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.setViewName("urltest");  
        return modelAndView;
    }

	@RequestMapping(value={"/index","/hello"})
    public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("message", "Hello World!");  
		modelAndView.setViewName("index");  
        return modelAndView;
    }
	
	@RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
    public ModelAndView getDetail(@PathVariable(value="id") Integer id){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("id", id);  
		modelAndView.setViewName("detail");  
        return modelAndView;
    }
	
	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}", method = {RequestMethod.GET})
    public ModelAndView regUrlTest(@PathVariable(value="name") String name, @PathVariable(value="age") Integer age){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.addObject("name", name); 
		modelAndView.addObject("age", age); 
		modelAndView.setViewName("regurltest");  
        return modelAndView;
    }
	
	//@RequestMapping(value="/paramstest", params="example", method = {RequestMethod.GET})
	//@RequestMapping(value="/paramstest", params="!example", method = {RequestMethod.GET})
	@RequestMapping(value="/paramstest", params="example=AAA", method = {RequestMethod.GET})
	//@RequestMapping(value="/paramstest", params="example!=AAA", method = {RequestMethod.GET})
	public ModelAndView paramsTest(){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.setViewName("paramstest");  
        return modelAndView;
	}
	
}
