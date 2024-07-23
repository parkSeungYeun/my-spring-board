package com.kitri.myspringboard.Controller;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.service.CommentService;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public String addComment(@RequestParam("boardId") Long boardId, @RequestParam("content") String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();

        Comment comment = new Comment();
        comment.setBoardId(boardId);
        comment.setContent(content);
        comment.setUsername(username);
        commentService.addComment(comment);

        return "redirect:/board/" + boardId; // 해당 게시글 상세 페이지로 리다이렉트
    }

//    //수정
//    @GetMapping("/{id}/editBoard")
//    public String editBoardview(@PathVariable long id, Model model) {
//        Board board=boardService.findById(id);
//        model.addAttribute("board",board);
//        return "board/editBoard";
//    }
//    @PostMapping("/{id}/editBoard")
//    public String editBoard(@PathVariable long id, @ModelAttribute("board") Board board) {
//        boardService.update(board);
//        return "redirect:/board/list";
//    }
    //삭제
    @PostMapping("/comment/{id}/{boardId}/delete")
    public String delete(@PathVariable long id, @PathVariable long boardId) {
        commentService.deleteComment(id);
        return "redirect:/board/{boardId}";
    }
}
