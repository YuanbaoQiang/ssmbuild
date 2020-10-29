package com.yuanbaoqiang.service;

import com.yuanbaoqiang.dao.BookMapper;
import com.yuanbaoqiang.pojo.Books;

import java.util.List;

/**
 * @description:
 * @author: YuanbaoQiang
 * @time: 2020/10/24 21:28
 */
public class BookServiceImpl implements BookService{
    // 调用dao层，设置一个set接口，方便Spring管理
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books book) {
        System.out.println("BookServiceImpl: updateBook=>" + book);
        return bookMapper.updateBook(book);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
