package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    /*@Autowired tells the compiler to instantiate the repository object when the application runs,
    * so you don’t have to type out that line (JobRespository jobRespository = new JobRespository(); )
    *  so many times!*/
    @Autowired
    JobRespository jobRespository;

    /*   The user will see a list of recordes that have been saved in the data base
    * Job Respository is used to retrive all avaiable data i*/
    @RequestMapping("/")
    public String listJobs(Model model){
        //findAll() gets any data saved inside the jobRespository
        model.addAttribute("jobs", jobRespository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("job", new Job());
        return"jobform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Job job, BindingResult result){
        if(result.hasErrors()){
            return "jobform";
        }
        else {
            jobRespository.save(job);
            return "redirect:/";

        }
    }

}
