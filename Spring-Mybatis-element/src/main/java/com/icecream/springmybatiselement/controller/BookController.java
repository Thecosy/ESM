package com.icecream.springmybatiselement.controller;


import com.icecream.springmybatiselement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaohaotian
 * @since 2022-01-05
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndVide = new ModelAndView();
        modelAndVide.setViewName("index");
        modelAndVide.addObject("list",bookService.list());
        return modelAndVide;
    }
}

