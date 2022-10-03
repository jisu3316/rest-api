package com.example.restapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {

    private int page;
    private int perPageNum;
    private int total;

    public BoardRequest() {
        //최초 게시판에 진입할 때를 위해서 기본 값을 설정 해야 한다.
        this.page = 1;
        this.perPageNum = 10;
    }

    public BoardRequest(int page, int perPageNum) {
        this.page = page;
        this.perPageNum = perPageNum;
    }

    public int getTotalPages() {
        int tempEndPage = (int) (Math.ceil(getTotal() / (double) getPerPageNum()));
        System.out.println("tempEndPage = " + tempEndPage);
        return tempEndPage;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /* limit 구문에서 시작 위치를 지정할 때 사용된다. 예를 들어 10개씩 출력하는 경우 3페이지의 데이터는 linit 20, 10 과 같은 형태가 되어야 한다. */
    /* this.page 가 1이면 0이 되어야 한다 mysql limit 0, 10 해야 처음부터 10개씩 나온다. */
    /* 마이바티스 조회쿼리의 #{pageStart}에 전달된다. */
    public int getPageStart() {
        return (this.page -1) * perPageNum;
    }

    public String toString() {
        return "BoardRequest [page=" + page + ", perPageNum=" + perPageNum + "]";
    }
}
