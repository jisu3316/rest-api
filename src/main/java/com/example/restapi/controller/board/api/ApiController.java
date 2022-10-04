package com.example.restapi.controller.board.api;

import com.example.restapi.dto.request.BoardCreateRequest;
import com.example.restapi.dto.response.BoardResponse;
import com.example.restapi.dto.response.Response;
import com.example.restapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class ApiController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Integer> createBoard(@RequestBody BoardCreateRequest request) {
        System.out.println("request = " + request.getBoardTitle());
        System.out.println("request = " + request.getBoardContent());
        System.out.println("request = " + request.getBoardUserName());
        System.out.println("request = " + request.getBoardPassword());
        boardService.createBoard(request);
        System.out.println("request.getBoardId = " + request.getBoardId());
        return ResponseEntity.ok().body(request.getBoardId());
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardCreateRequest> updateBoard(@PathVariable Integer boardId, @RequestBody BoardCreateRequest request) {
        System.out.println("boardId = " + boardId);
        System.out.println("request.getBoardId = " + request.getBoardId());
        System.out.println("request.getBoardTitle = " + request.getBoardTitle());
        System.out.println("request.getBoardContent = " + request.getBoardContent());
        System.out.println("request.getBoardUserName = " + request.getBoardUserName());
        System.out.println("request.getBoardPassword = " + request.getBoardPassword());
        boardService.updateBoard(boardId, request);
        return ResponseEntity.ok().body(request);
    }
}
