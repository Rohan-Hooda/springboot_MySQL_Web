package com.example.test;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/posts")
public class RestController {
	
	@Autowired
    private DBTest repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("posts", repository.query());
        return "posts/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String id) {
        repository.delete(id);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "posts/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("Quantity") String Quantity,
    							@RequestParam("ItemID") String id) {
        repository.create(id,Quantity);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_id") String id,
                               @RequestParam("Quantity") String Quantity) {
        Post post = repository.find(id);
        post.setMessage(Quantity);
        repository.update(post);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable String id,
                       Model model) {
        Post post = repository.find(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

}
