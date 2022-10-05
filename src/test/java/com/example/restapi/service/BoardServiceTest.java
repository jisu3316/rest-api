package com.example.restapi.service;

import com.example.restapi.dao.BoardDAO;
import com.example.restapi.dto.request.BoardRequest;
import com.example.restapi.dto.response.BoardResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("BoardService Test")
@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @InjectMocks
    private BoardService boardService;

    @Mock
    BoardDAO boardDAO;

    @DisplayName("게시글 리스트 조회")
    @Test
    void givenNoSearchParameters_whenBoards_thenReturnBoardPage() {
        BoardRequest boardRequest = createBoardRequest();
        given(boardService.boards(boardRequest)).willReturn(List.of());

        List<BoardResponse> boards = boardService.boards(boardRequest);

        Assertions.assertThat(boards).isEmpty();
        then(boardDAO).should().list(boardRequest);
    }

    private BoardRequest createBoardRequest() {
        return new BoardRequest();
    }
}
