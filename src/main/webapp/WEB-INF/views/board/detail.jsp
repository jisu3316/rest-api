<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Uno Kim">
    <title>게시글 페이지</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="/css/articles/article-content.css" rel="stylesheet">
</head>

<body>

<!-- ======= Header ======= -->
<jsp:include page="../header.jsp" flush="true"/>
<!-- End Header -->

<main id="article-main" class="container">
    <header id="article-header" class="py-5 text-center">
        <h1>${board.boardTitle}</h1>
    </header>

    <div class="row g-5">
        <section class="col-md-3 col-lg-4 order-md-last">
            <aside>
                <p><span id="boardUserName">${board.boardUserName}</span></p>
                <p><a id="email" href="mailto:djkehh@gmail.com">jisu3316@naver.com</a></p>
                <p><time id="createdAt" >
                    <fmt:parseDate value="${ board.createAt }" pattern="yyyy-MM-dd'T'HH:mm:SS" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm:SS" value="${ parsedDateTime }" /></time></p>
                <p><span id="hashtag">#java</span></p>
            </aside>
        </section>

        <article id="boardContent" class="col-md-9 col-lg-8">
            <pre>${board.boardContent}</pre>
        </article>
    </div>

    <div class="row g-5" id="article-buttons">
        <form id="delete-article-form">
            <div class="pb-5 d-grid gap-2 d-md-block">
                <a class="btn btn-success me-md-2" role="button" id="update-article" href="/view/board/${board.boardId}/form">수정</a>
                <button class="btn btn-danger me-md-2" type="submit">삭제</button>
            </div>
        </form>
    </div>

    <div class="row g-5">
        <section>
            <form class="row g-3" id="comment-form">
                <input type="hidden" class="article-id">
                <div class="col-md-9 col-lg-8">
                    <label for="comment-textbox" hidden>댓글</label>
                    <textarea class="form-control" id="comment-textbox" placeholder="댓글 쓰기.." rows="3" required></textarea>
                </div>
                <div class="col-md-3 col-lg-4">
                    <label for="comment-submit" hidden>댓글 쓰기</label>
                    <button class="btn btn-primary" id="comment-submit" type="submit">쓰기</button>
                </div>
            </form>

            <ul id="article-comments" class="row col-md-10 col-lg-8 pt-3">
                <li>
                    <form class="comment-form">
                        <input type="hidden" class="article-id">
                        <div class="row">
                            <div class="col-md-10 col-lg-9">
                                <strong>Uno</strong>
                                <small><time>2022-01-01</time></small>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                                    Lorem ipsum dolor sit amet
                                </p>
                            </div>
                            <div class="col-2 mb-3 align-self-center">
                                <button type="submit" class="btn btn-outline-danger" id="delete-comment-button">삭제</button>
                            </div>
                        </div>
                    </form>
                </li>
                <li>
                    <div class="row">
                        <div class="col-md-10 col-lg-9">
                            <strong>jisu2</strong>
                            <small><time>2022-01-01</time></small>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                                Lorem ipsum dolor sit amet
                            </p>
                        </div>
                        <div class="col-2 mb-3 align-self-center">
                            <button type="submit" class="btn btn-outline-danger" hidden>삭제</button>
                        </div>
                    </div>
                </li>
            </ul>

        </section>
    </div>

    <div class="row g-5">
        <nav id="pagination" aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo; prev</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">next &raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</main>

<!-- ======= Footer ======= -->
<jsp:include page="../footer.jsp" flush="true"/>
<!-- End Footer -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>