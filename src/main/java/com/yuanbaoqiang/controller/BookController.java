package com.yuanbaoqiang.controller;

import com.yuanbaoqiang.pojo.Books;
import com.yuanbaoqiang.service.BookService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YuanbaoQiang
 * @time: 2020/10/25 14:02
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查阅书籍的操作
    @RequestMapping("/allBooks")
    public String list(Model model){
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBooks";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBooks";
    }

    // 添加书籍的请求
    @RequestMapping("/addBooks")
    public String addBook(Books books){
        System.out.println("addBooks=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBooks"; // 重定向到我们的@RequestMapping("/allBooks")请求
    }

    // 删除书籍的操作
    @RequestMapping("/deleteBooks/{bookId}")
    public String deleteBooks(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBooks"; // 重定向到我们的@RequestMapping("/allBooks")请求
    }

    // 修改书籍的操作
    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBooks")
    public String toUpdateBooks(Model model, int id){ // id从上一个修改表单的action链接中获得  ?id=${book.bookId}
        // 将要修改的书籍查询出来
        Books books = bookService.queryBookById(id);
        // 将这本书存进model
        model.addAttribute("QBook",books);
        // 跳转到修改书籍页面
        return "updateBooks";
    }

    // 修改书籍
    @RequestMapping("/updateBooks")
    public String updateBooks(Books books){
        System.out.println("updateBook=>" + books);
        int i = bookService.updateBook(books);
        if(i > 0){
            System.out.println("书籍修改成功：" + books);
        }
        return "redirect:/book/allBooks"; // 重定向到我们的@RequestMapping("/allBooks")请求
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("queryBook=>" + books);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books == null){
            list = bookService.queryAllBooks();
        }
        model.addAttribute("list",list);
        return "allBooks";
    }

}
