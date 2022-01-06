package com.icecream.springmybatiselement.service.impl;

import com.icecream.springmybatiselement.entity.Book;
import com.icecream.springmybatiselement.mapper.BookMapper;
import com.icecream.springmybatiselement.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaohaotian
 * @since 2022-01-05
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
