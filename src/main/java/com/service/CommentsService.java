package com.service;

import com.dao.CommentsDAO;
import com.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/21.
 */
@Service
@Transactional
public class CommentsService {

    @Autowired
    CommentsDAO commentsDAO;

    //添加评价
    public void addComment(Comments comments){
        commentsDAO.addComment(comments);
    }
}
