package com.mvc.Library.Management.System.controllers;

import com.mvc.Library.Management.System.entities.Publisher;
import com.mvc.Library.Management.System.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String savePublisher(@ModelAttribute Publisher publisher,Model model){
        if(publisher!=null){
            publisherService.addPublisher(publisher);
        }
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }
    @GetMapping(value = "/publishers")
    public String allPublishers(@ModelAttribute Publisher publisher,Model model){
        model.addAttribute("publishers",publisherService.publishers());
        return "publishers";
    }
}
