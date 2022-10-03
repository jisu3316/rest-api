package com.example.restapi.dao;

import com.example.restapi.dto.request.BoardCreateRequest;
import com.example.restapi.dto.request.BoardRequest;
import com.example.restapi.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BoardDAO {

    List<Board> list(BoardRequest boardRequest);

    Integer totalCount();

    Integer createBoard(BoardCreateRequest request);

    Board getBoard(Integer boardId);

    Integer updateBoard(Map<String, Object> map);
}
