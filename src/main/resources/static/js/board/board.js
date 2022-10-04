function createBoard() {
// document.getElementById("board-form").onsubmit = function () {
    let boardTitle = document.getElementById('boardTitle').value;
    let boardContent = document.getElementById('boardContent').value;
    let boardUserName = document.getElementById('boardUserName').value;
    let boardPassword = document.getElementById('boardPassword').value;
    console.log("boardTitle= " + boardTitle+ ", boardContent=" + boardContent+ ", boardUserName=" + boardUserName + ", boardPassword= " + boardPassword);
    let result = {"board_title" : boardTitle, "board_content" : boardContent, "board_user_name" : boardUserName, "board_password" : boardPassword};
    $.ajax({
        url: "/api/board",
        type: "POST",
        dataType: "json",
        data: JSON.stringify({"boardTitle" : boardTitle, "boardContent" : boardContent, "boardUserName" : boardUserName, "boardPassword" : boardPassword}),
        contentType: "application/json",
        success: function (data) {
            console.log("data: ", data);
            // location.href = "/view/board/" + data;
            alert(data);
            // console.log(data);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            let err = JSON.parse(request.responseText);
            console.log("에러: " + err);
        }
    });
}

function updateBoard() {
// document.getElementById("board-form").onsubmit = function () {
    let boardId = document.getElementById('boardId').value;
    let boardTitle = document.getElementById('boardTitle').value;
    let boardContent = document.getElementById('boardContent').value;
    let boardUserName = document.getElementById('boardUserName').value;
    let boardPassword = document.getElementById('boardPassword').value;
    console.log("boardTitle= " + boardTitle+ ", boardContent=" + boardContent+ ", boardUserName=" + boardUserName + ", boardPassword= " + boardPassword);
    let result = {"board_title" : boardTitle, "board_content" : boardContent, "board_user_name" : boardUserName, "board_password" : boardPassword};
    $.ajax({
        url: "/api/board/" + boardId,
        type: "PUT",
        dataType: "json",
        data: JSON.stringify({"boardId": boardId, "boardTitle" : boardTitle, "boardContent" : boardContent, "boardUserName" : boardUserName, "boardPassword" : boardPassword}),
        contentType: "application/json",
        success: function (data) {
            console.log("data: ", data);
            // location.href = "/view/board/" + data.result.boardId;
            // alert(data.result.boardId);
            // console.log(data);
        },
        error: function (request, status, error) {
            console.log("request: ", request);
            console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            // let err = JSON.parse(request.responseText);
            // alert(err.resultCode)
            console.log("에러: " , err);
        }
    });
}