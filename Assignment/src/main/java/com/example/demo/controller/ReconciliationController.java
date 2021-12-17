package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ReconcilationModel;
import com.example.demo.reposistory.ReconcilationReposistory;

@Controller
public class ReconciliationController {

	@Autowired
	 ReconcilationReposistory reconcilationReposistory;


	
	
	@GetMapping(value="/")
	public String  data( ReconcilationModel  reconcilationModel) {
		
		return "index";
	}
	
	 

	@GetMapping(value="/addData")
	public String  adddata( ReconcilationModel  reconcilationModel) {
		
		return "addData";
	}
	
	
	@PostMapping("/addReconciliationRule")
    public String addUser(@Validated ReconcilationModel  reconcilationModel, BindingResult result, Model model) {
       try {
		if (result.hasErrors()) {
            return "addData";
        }
		reconcilationReposistory.save(reconcilationModel);
        return "redirect:/index";
       }
       catch(Exception e){
    	   e.printStackTrace();
    	   return null;
       }
       
}
	
	@GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("reconcilationModels", reconcilationReposistory.findAll());
        return "index";
    }
	
	
	 @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	System.out.println("inside in Getmapping");
	    	ReconcilationModel reconcilationModel = reconcilationReposistory.findById(id)
	         .orElseThrow(() -> new IllegalArgumentException("Invalid Service Id:" + id));
	        
	        model.addAttribute("reconcilationModel", reconcilationModel);
	        return "/update";
	    }
	    
	    
	    @PostMapping("/update/{id}")
	    public String updateService(@PathVariable("id") long id, @Validated ReconcilationModel reconcilationModel, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	reconcilationModel.setId(id);
	            return "update";
	        }
	            
	        reconcilationReposistory.save(reconcilationModel);
	        return "redirect:/index";
	    }
	        
	    @GetMapping("/delete/{id}")
	    public String deleteService(@PathVariable("id") long id, Model model) {
	    	ReconcilationModel reconcilationModel = reconcilationReposistory.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    	reconcilationReposistory.delete(reconcilationModel);
	        return "redirect:/index";
	    }
	
}


