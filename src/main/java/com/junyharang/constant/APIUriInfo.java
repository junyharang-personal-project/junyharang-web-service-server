package com.junyharang.constant;

/**
 * <b>Hard Coding 방지용 URI 관리 Class</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

public interface APIUriInfo {

    /* Test Service URI */
    String TEST_BOARD = "/test/board";
    String TEST_PROFILE = "/test/profile";
    String TEST_LOG_BACK = "/test/logback-test";

    /* 정식 Service URI */
    String NOW_VERSION = "/api/v1";
    String NOW_VERSION_MEMBER = NOW_VERSION+"/member";

    String NOW_VERSION_GUEST = NOW_VERSION+"/guest";
    String NOW_VERSION_FRIEND = NOW_VERSION+"/friend";
    String NOW_VERSION_ADMIN = NOW_VERSION+"/admin";

}
