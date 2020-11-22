package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface CommentService {
    public String getAllComments(int userID) throws IOException;//return json string
    public String getCommentsByPlayground(int playgroundID) throws IOException;
    public Comment insert(Comment comment);
}
