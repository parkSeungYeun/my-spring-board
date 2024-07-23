package com.kitri.myspringboard.Controller;
import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.mapper.BoardMapper;
import com.kitri.myspringboard.service.BoardService;
import com.kitri.myspringboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private CommentService commentService;



    //목록보기
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/list";
    }
    //상세조회
    @GetMapping("/{id}")
    public String detail(@PathVariable long id, Model model) {
        Board board=boardService.findById(id);
        model.addAttribute("board",board);

        List<Comment> comments = commentService.findCommentsByBoardId(id);
        model.addAttribute("comments", comments);
        return "board/detail";
    }

    // 생성
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/new";
    }

    @PostMapping("/new")
    public String processNewForm(@ModelAttribute("board") Board board) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        board.setUsername(username);
        boardService.save(board);
        return "redirect:/board/list";
    }
    //수정
    @GetMapping("/{id}/editBoard")
    public String editBoardview(@PathVariable long id, Model model) {
        Board board=boardService.findById(id);
        model.addAttribute("board",board);
        return "board/editBoard";
    }
    @PostMapping("/{id}/editBoard")
    public String editBoard(@PathVariable long id, @ModelAttribute("board") Board board) {
        boardService.update(board);
        return "redirect:/board/list";
    }
    //삭제
    @PostMapping("/comment/{id}/delete")
    public String delete(@PathVariable long id) {
        boardMapper.delete(id);
        return "redirect:/board/list";
}
}


