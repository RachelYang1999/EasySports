package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.User;

import java.util.List;

public interface CommentDao {
    public List<Comment> getCommentList(int userID);
    public void deleteComment(int commentID);
    public List<Comment> getCommentByPlayground(int playGroundID);
    Comment saveComment(Comment comment);
}
