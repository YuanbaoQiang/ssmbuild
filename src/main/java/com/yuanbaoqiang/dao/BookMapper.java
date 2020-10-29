package com.yuanbaoqiang.dao;

import com.yuanbaoqiang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    // 增加一本书
    int addBook(Books book);

    // 根据id删除一本书
    int deleteBookById(@Param("bookId") int id);

    // 更新book
    int updateBook(Books book);

    // 根据id查询，返回一本书
    Books queryBookById(@Param("bookId") int id);

    // 查询全部的Book，返回list集合
    List<Books> queryAllBooks();

    // 查询书籍
    Books queryBookByName(@Param("bookName") String bookName);

}
