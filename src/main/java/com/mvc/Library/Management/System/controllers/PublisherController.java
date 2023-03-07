package com.mvc.Library.Management.System.controllers;
import com.mvc.Library.Management.System.entities.Publisher;
import com.mvc.Library.Management.System.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublisherController {
    @Autowired
    PublisherService publisherService;
    @RequestMapping(value = "/addPublisher")
    public String showPublisherForm(Model model){
        model.addAttribute("publisher",new Publisher());
        return "add-publisher";
    }

    @PostMapping(value = "/publishers")
    public String savePublisher(@ModelAttribute Publisher publisher, Model model, BindingResult result){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.addPublisher(publisher);
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }
    @GetMapping(value = "/publishers")
    public String allPublishers(@ModelAttribute Publisher publisher,Model model){
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }
    @RequestMapping("/updatePublisher/{publisherId}")
    public String showUpdateForm(@PathVariable("publisherId") Integer publisherId,Model model){
        Publisher selectedPublisher =publisherService.getPublisherById(publisherId);
        model.addAttribute("publisher",selectedPublisher);
        return "update-publisher";
    }
    @PostMapping("/updatePublisher/{publisherId}")
    public String updatePublisher(@PathVariable("publisherId") Integer publisherId,@ModelAttribute Publisher publisher,Model model,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("publisher",publisher);
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher,publisherId);
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }

    @RequestMapping("/deletePublisher/{publisherId}")
    public String deletePublisher(@PathVariable("publisherId") Integer publisherId,Model model){
        publisherService.deletePublisher(publisherId);
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }




}
