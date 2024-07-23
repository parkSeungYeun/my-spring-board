package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.mapper.CommentMapper;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;


    public List<Comment>findCommentsByBoardId(long boardId) {
        return commentMapper.findCommentsByBoardId(boardId);
    }
    public void addComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    public void updateComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    public void deleteComment(long boardId) {
        commentMapper.deleteComment(boardId);
    }

}
