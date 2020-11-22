package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.CommentDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.impl.CommentDaoImpl;
import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private PlaygroundDao playgroundDao;

    @Override
    public String getAllComments(int userID) throws IOException {
        List<Comment> comments = commentDao.getCommentList(userID);

        for(Comment c : comments){
            c.setName(playgroundDao.getById(c.getPlaygroundId()).getName());
//            c.setName(playgroundDao.getById(2).getName());
        }
        return getString(comments);
    }

    @Override
    public String getCommentsByPlayground(int playgroundID) throws IOException {
        List<Comment> comments = commentDao.getCommentByPlayground(playgroundID);
        return getString(comments);
    }

    @Override
    public Comment insert(Comment comment) {
        return commentDao.saveComment(comment);
    }

    private String getString(List<Comment> comments) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();//jackson
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, comments);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }




}
