package com.example.restapi.dto.response;

import com.example.restapi.model.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardResponse {
    private Integer boardId;
    private String boardTitle;
    private String boardContent;
    private String boardUserName;
    private LocalDateTime createAt;
    private String deleteYN;

    public BoardResponse(Integer boardId, String boardTitle, String boardContent, String boardUserName, LocalDateTime createAt, String deleteYN) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardUserName = boardUserName;
        this.createAt = createAt;
        this.deleteYN = deleteYN;
    }

    public static BoardResponse from(Board board) {
        return new BoardResponse(
                board.getBoardId(),
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getBoardUserName(),
                board.getCreateAt(),
                board.getDeleteYN()
        );
    }
}
