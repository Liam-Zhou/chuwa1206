package com.chuwa.cassandrablog.service.impl;

import com.chuwa.cassandrablog.dao.PostRepository;
import com.chuwa.cassandrablog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    
}
