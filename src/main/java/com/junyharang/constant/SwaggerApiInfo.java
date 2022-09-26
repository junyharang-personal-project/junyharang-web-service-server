package com.junyharang.constant;

/**
 * <b>Service 별 Swagger 내용 관련 인터페이스</b>
 *
 * @author 주니하랑
 * @version 1.0.0, 2022.08.19 초기구성
 */

public interface SwaggerApiInfo {

    String POSTING = "게시판 서비스";
    String GET_POSTS_LIST = "게시글 목록 조회";
    String GET_POSTS_ONE_THING = "게시글 단건 조회";
    String WRITE_POSTS = "게시글 등록";
    String DELETE_POSTS = "게시글 삭제";
    String MODIFY_POSTS = "게시글 수정";
    String POST_LIKE = "게시글 좋아요";
    String TITLE_SEARCH = "게시글 제목 검색";
    String CONTENT_SEARCH = "게시글 내용 검색";
    String TITLE_CONTENT_SEARCH = "게시글 제목+내용 검색";
    String TAG_SEARCH = "게시글 TAG 검색";

    String COMMENT = "댓글 서비스";
    String WRITE_COMMENT = "댓글 등록";
    String GET_COMMENT_LIST = "댓글 목록 조회";
    String DELETE_COMMENT = "댓글 삭제";
    String MODIFY_COMMENT = "댓글 수정";
    String COMMENT_LIKE = "댓글 좋아요";

    String AUTHORIZE = "인증 서비스";
    String SIGN_IN = "로그인 서비스";
    String SIGN_UP = "회원 가입 서비스";

    String REPLACE_TOKEN = "JWT 재발행 서비스";
    String FILE_UPLODER = "파일 업로드 서비스";

    String TEST = "테스트 용 입니다.";

}
