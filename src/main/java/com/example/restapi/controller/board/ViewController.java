package com.example.restapi.controller.board;

import com.example.restapi.dto.request.BoardRequest;
import com.example.restapi.dto.response.BoardResponse;
import com.example.restapi.service.BoardService;
import com.example.restapi.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/board")
public class ViewController {

    private final BoardService boardService;
    private final PaginationService paginationService;

    @GetMapping
    public String board(Model model, BoardRequest boardRequest) {
        List<BoardResponse> boards = boardService.boards(boardRequest);
        Integer totalCount = boardService.totalCount();
        boardRequest.setTotal(totalCount);
        List<Integer> paginationBarNumbers = paginationService.getPaginationBarNumbers(boardRequest.getPage(), boardRequest.getTotalPages());

        System.out.println("boardRequest = " + boardRequest);
        System.out.println("totalCount = " + totalCount);
        System.out.println("boardRequest.getPage() = " + boardRequest.getPage());
        System.out.println("paginationBarNumbers = " + paginationBarNumbers.toString());

        model.addAttribute("paginationBarNumbers", paginationBarNumbers);
        model.addAttribute("boards", boards);
        model.addAttribute("totalCount", totalCount);
        return "board/list";
    }

    @GetMapping("/new")
    public String createBoard() {
        return "board/new-board";
    }

    @GetMapping("/{boardId}")
    public String detail(@PathVariable Integer boardId, Model model) {
        BoardResponse board = boardService.getBoard(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/{boardId}/form")
    public String updateBoard(@PathVariable Integer boardId, Model model) {
        BoardResponse board = boardService.getBoard(boardId);
        System.out.println("board = " + board.getBoardContent());
        model.addAttribute("board", board);
        return "board/form";
    }
}
