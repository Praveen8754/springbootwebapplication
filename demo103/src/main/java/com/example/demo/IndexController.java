package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    EmployeeRecords er;

    @RequestMapping("home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("request.jsp");
        return mv;
    }

    @RequestMapping("addEmployee")
    public ModelAndView addEmp(Employee emp) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("empDetails", emp);
        mv.setViewName("index.jsp");
        er.save(emp);
        System.out.println(emp.getName());
        System.out.println("Web Home page");
        return mv;
    }

    @RequestMapping("getDetails")
    public ModelAndView getEmp(Employee emp) {
        int eid = emp.getEmpId();
        Optional<Employee> op = er.findById(eid);
        ModelAndView mv = new ModelAndView();
        if (op.isPresent()) {
            Employee employee = op.get();
            mv.addObject("empDetails", employee);
            mv.setViewName("display.jsp");
        } else {
            mv.setViewName("error.jsp"); 
        }
        return mv;
    }
    
    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmp(Employee emp) {
       er.deleteById(emp.getEmpId());
       ModelAndView mv=new ModelAndView();
       mv.addObject("empDetails",emp);
       mv.setViewName("delete.jsp");
       return mv;
    }
    
    @RequestMapping("updateEmployee")
    public ModelAndView updateEmp(Employee emp) {
   
       ModelAndView mv=new ModelAndView();
       Optional<Employee> op=er.findById(emp.getEmpId());
       Employee employee=op.get();
       er.setEmployeeById(emp.getName(), emp.getEmpId());
       er.save(emp);
       mv.addObject("empDetails",emp);
       mv.setViewName("update.jsp");
       return mv;
    }
}
