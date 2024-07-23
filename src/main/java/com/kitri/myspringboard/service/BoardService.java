package com.kitri.myspringboard.service;
import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.domain.User;
import com.kitri.myspringboard.mapper.BoardMapper;
import com.kitri.myspringboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BoardService {
    @Autowired
     BoardMapper boardMapper;
    @Autowired
    CommentService commentService;

    //목록
    public List<Board> findAll() {
        return boardMapper.findAll();
    }
    // 생성
    public void save(Board board) {
        boardMapper.insert(board);
    }
    //수정
    public void update(Board board) {
        boardMapper.update(board);
    }

    public Board findById(long id) {
        Board board = boardMapper.findById(id);
        if (board != null) {
            List<Comment> comments = commentService.findCommentsByBoardId(id);
            board.setComments(comments);
        }
        return board;
    }


}
