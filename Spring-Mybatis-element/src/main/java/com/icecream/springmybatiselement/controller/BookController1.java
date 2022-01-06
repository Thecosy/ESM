package com.icecream.springmybatiselement.controller;


import com.icecream.springmybatiselement.entity.Book;
import com.icecream.springmybatiselement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaohaotian
 * @since 2022-01-05
 */
@RestController
@RequestMapping("/book1")
//@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class BookController1 {

    @Autowired
    private BookService bookService;


    //查找
    //解决跨越问题
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/list")
    public List<Book> list() {
        return this.bookService.list();
    }

    //id查找
    //解决跨越问题
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return this.bookService.getById(id);
    }

    //删除
    //解决跨越问题
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return this.bookService.removeById(id);
    }

    //添加
    //解决跨越问题
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/add")
    public boolean add(@RequestBody Book book) {
        return this.bookService.save(book);
    }

    //修改
    //解决跨越问题
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/update")
    public boolean update(@RequestBody Book book) {
        return this.bookService.updateById(book);
    }


}
