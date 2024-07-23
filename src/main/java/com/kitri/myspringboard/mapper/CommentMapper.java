package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import org.apache.ibatis.annotations.*;
import com.kitri.myspringboard.domain.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment WHERE board_id = #{boardId}")
    List<Comment> findCommentsByBoardId(long boardId);

    @Insert("INSERT INTO comment (content, username, board_id, created_at) VALUES (#{content}, #{username}, #{boardId}, NOW())")
    void insertComment(Comment comment);

//    @Update("UPDATE comment set content=#{content},username=#{username},board_id=#{boardId} where id =#{boardId}")
//    void updateComment((Board board);

    @Delete("DELETE FROM comment WHERE id =#{boardId}")
    void deleteComment(long boardId);

}
