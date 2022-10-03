package com.example.restapi.service;

import com.example.restapi.dao.BoardDAO;
import com.example.restapi.dto.request.BoardCreateRequest;
import com.example.restapi.dto.request.BoardRequest;
import com.example.restapi.dto.response.BoardResponse;
import com.example.restapi.exception.BoardException;
import com.example.restapi.exception.ErrorCode;
import com.example.restapi.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDAO boardDAO;

    public List<BoardResponse> boards(BoardRequest boardRequest) {
        return boardDAO.list(boardRequest).stream().map(BoardResponse::from).collect(Collectors.toList());
    }

    public Integer totalCount() {
        return boardDAO.totalCount();
    }

    public Integer createBoard(BoardCreateRequest request) {
        return boardDAO.createBoard(request);
    }

    public BoardResponse getBoard(Integer boardId) {
        return BoardResponse.from(boardDAO.getBoard(boardId));
    }

    public Integer updateBoard(Integer boardId, BoardCreateRequest request) {
        Board board = boardDAO.getBoard(boardId);
        if (!board.getBoardPassword().equals(request.getBoardPassword())) {
            throw new BoardException(ErrorCode.INVALID_PASSWORD, String.format("%s INVALID_PASSWORD", request.getBoardPassword()));
        }

        Map<String, Object> map = new HashMap<>();
        map.put("boardId", boardId);
        map.put("boardTitle", request.getBoardTitle());
        map.put("boardContent", request.getBoardContent());
        return boardDAO.updateBoard(map);
    }
}
