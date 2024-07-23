package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void findAll() {
        List<Board> boards = boardMapper.findAll();
        assertThat(boards).hasSize(5);
    }

    @Test
    void findById() {
        //Given, When, Then
        Board board= new Board();
        long id =21L;
        board.setId(id);
        board.setTitle("Test Title");
        board.setContent("Test Content");
        board.setWriter("Test Writer");

        boardMapper.insert(board);;
        Board foundBoard =boardMapper.findById(board.getId());

        assertThat(foundBoard).isNotNull();
        assertThat(foundBoard.getTitle()).isEqualTo("Test Title");
        assertThat(foundBoard.getContent()).isEqualTo("Test Content");
        assertThat(foundBoard.getWriter()).isEqualTo("Test Writer");
    }

    @Test
    void insert() {
        Board board= new Board();
        board.setTitle("Test Title");
        board.setContent("Test Content");
        board.setWriter("Test Writer");
        boardMapper.insert(board);
        System.out.println(board.getId());
    }

    @Test
    void update() {
        // 빈셀
        Board boardU= new Board();
        boardU.setTitle("Valid Title");
        boardU.setContent("Test Content");
        boardU.setWriter("Test Writer");

        // 등록
        boardMapper.insert(boardU);

        //빈셀 자동생성된 id, title, 등 등
        Board foundBoard = boardMapper.findById(boardU.getId());

        //수정
        foundBoard.setTitle("Update Test Title");
        foundBoard.setContent("Update Test Content");
        foundBoard.setWriter("Update Test Writer");
        boardMapper.update(foundBoard);

        // boardU 의 데이터를 가짐
        Board  updateBoard = boardMapper.findById(foundBoard.getId());

        //확인
        assertThat(updateBoard.getTitle()).isEqualTo("Update Test Title");
        assertThat(updateBoard.getContent()).isEqualTo("Update Test Content");
        assertThat(updateBoard.getWriter()).isEqualTo("Update Test Writer");
    }

    @Test
    void delete() {
        Board boardD= new Board();
        boardD.setTitle("Delete Test Title");
        boardD.setContent("Delete Test Content");
        boardD.setWriter("Delete Test Writer");
        boardMapper.insert(boardD);

        Board foundBoard = boardMapper.findById(boardD.getId());
        boardMapper.delete(foundBoard.getId());
        Board deletedBoard = boardMapper.findById(boardD.getId());
        assertThat(deletedBoard).isNull();
    }
}
