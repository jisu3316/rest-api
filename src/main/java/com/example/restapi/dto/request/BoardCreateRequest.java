package com.example.restapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class BoardCreateRequest {

    private Integer boardId;
//    @JsonProperty("board_title")
    private String boardTitle;
//    @JsonProperty("board_content")
    private String boardContent;
//    @JsonProperty("board_user_name")
    private String boardUserName;
//    @JsonProperty("board_password")
    private String boardPassword;

    public BoardCreateRequest(Integer boardId, String boardTitle, String boardContent, String boardUserName, String boardPassword) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardUserName = boardUserName;
        this.boardPassword = boardPassword;
    }
}
