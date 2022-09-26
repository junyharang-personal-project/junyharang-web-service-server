package com.junyharang.common.common_enum;

import lombok.Getter;

/**
 * <b>검색 구분을 위한 Enum Class</b>
 *
 * @author 주니하랑
 * @version 1.0.0, 2022.08.19 초기구성
 */

@Getter
public enum SearchType {

    ALL(0),
    TITLE(1),
    CONTENT(2);

    private final int searchTypeValue;

    SearchType(int searchTypeValue) {this.searchTypeValue = searchTypeValue;}
    public int getSearchTypeValue() {return searchTypeValue;}

}
