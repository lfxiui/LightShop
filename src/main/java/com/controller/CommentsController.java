package com.controller;

import com.entity.Comments;
import com.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Fuxi on 2017/5/21.
 */
@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    //添加评价
    @RequestMapping("/addComment")
    @ResponseBody
    public String addComment(int lightId, String comments, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Comments comment = new Comments();
        comment.setComments(comments);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        comment.setDate(ts);
        comment.setLightId(lightId);
        comment.setUserId(userId);
        commentsService.addComment(comment);
        return "success";
    }
}
