package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.payload.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
}
