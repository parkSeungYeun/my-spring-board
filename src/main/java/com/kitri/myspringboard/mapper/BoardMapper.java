package com.kitri.myspringboard.mapper;
import org.apache.ibatis.annotations.*;
import com.kitri.myspringboard.domain.Board;
import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board where id =#{id}")
    Board findById(long id);

    @Insert("INSERT INTO board(title, content,username) VALUES (#{title},#{content},#{username} )")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Board board);

    @Update("UPDATE board set title=#{title},content=#{content},username=#{username} where id =#{id}")
    void update(Board board);

    @Delete("DELETE FROM board WHERE id =#{id}")
    void delete(long id);
}
