package com.example.restapi.controller;

import com.example.restapi.controller.board.api.ApiController;
import com.example.restapi.dto.request.BoardCreateRequest;
import com.example.restapi.exception.BoardException;
import com.example.restapi.exception.ErrorCode;
import com.example.restapi.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean private BoardService boardService;

    @Test
    void 포스트작성() throws Exception {
        Integer boardId = 1;
        String boardTitle = "title";
        String boardContent = "body";
        String boardUserName = "jisu";
        String boardPassword = "1234";

        mvc.perform(post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new BoardCreateRequest(boardId, boardTitle, boardContent, boardUserName, boardPassword)))
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 피드목록() throws Exception {
        when(boardService.boards(any())).thenReturn(List.of());

        mvc.perform(get("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 포스트수정시_본인이_작성한_글이_아닌경우_에러발생() throws Exception {
        String title = "title";
        String body = "body";
        Integer postId = 1;

        //mocking
        doThrow(new BoardException(ErrorCode.INVALID_PERMISSION)).when(boardService).updateBoard(eq("title"), eq("body"), any(), eq(1));

        mockMvc.perform(put("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new PostModifyRequest(title, body)))
                ).andDo(print())
                .andExpect(status().is(ErrorCode.INVALID_PERMISSION.getStatus().value()));
    }
}
