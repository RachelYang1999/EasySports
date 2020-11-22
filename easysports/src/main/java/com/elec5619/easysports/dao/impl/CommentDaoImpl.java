package com.elec5619.easysports.dao.impl;

import com.elec5619.easysports.dao.CommentDao;
import com.elec5619.easysports.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly = false)
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {

    @Override
    public List<Comment> getCommentList(int userID) {
        return getListByProperty(" userId", userID);
    }

    @Override
    public void deleteComment(int commentID) {

    }

    @Override
    public List<Comment> getCommentByPlayground(int playGroundID){
        return getListByProperty("playgroundId", playGroundID);
    }

    @Override
    public Comment saveComment(Comment comment) {
        save(comment);
        return comment;
    }
}
