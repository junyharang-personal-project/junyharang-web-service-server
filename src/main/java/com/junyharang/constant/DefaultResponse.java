package com.junyharang.constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <b>Response 처리를 위한 Class</b>
 *
 * @author 주니하랑
 * @version 1.0.0, 2022.08.19 초기구성
 */

@Data
@AllArgsConstructor
@Builder
public class DefaultResponse<T> {

    // API 상태 코드
    private Integer statusCode;

    // API 부가 설명 (한글)
    private String MessageKo;

    // API 부가 설명 (영어)
    private String MessageEn;

    // API 응답 데이터
    private T data;

    // 페이징 처리
    private Pagination pagination;

    /**
     * <b>상태 코드 + 부가 설명 반환</b>
     *
     * @param statusCode Http Status Code Number
     * @param MessageKo Response Body에 응답할 Message (한글)
     * @param MessageEn Response Body에 응답할 Message (영어)
     * @return <T> DefaultResponse<T> Response Body 응답값
     */

    public static <T> DefaultResponse<T> response(final Integer statusCode, final String MessageKo, final String MessageEn){
        return (DefaultResponse<T>) DefaultResponse.builder()
                .statusCode(statusCode)
                .MessageKo(MessageKo)
                .MessageEn(MessageEn)
                .build();
    }

    /**
     * <b>상태 코드 + 부가 설명 + 응답 데이터 반환</b>
     *
     * @param statusCode Http Status Code Number
     * @param MessageKo Response Body에 응답할 Message (한글)
     * @param MessageEn Response Body에 응답할 Message (영어)
     * @param data 연산 뒤 처리 결과값 객체
     * @return <T> DefaultResponse<T> Response Body 응답값
     */

    public static <T> DefaultResponse<T> response(final Integer statusCode, final String MessageKo, final String MessageEn, final T data){
        return (DefaultResponse<T>) DefaultResponse.builder()
                .statusCode(statusCode)
                .MessageKo(MessageKo)
                .MessageEn(MessageEn)
                .data(data)
                .build();
    }

    /**
     * <b>상태 코드 + 부가 설명 + 응답 데이터 + 페이징 처리 반환</b>
     *
     * @param statusCode Http Status Code Number
     * @param MessageKo Response Body에 응답할 Message (한글)
     * @param MessageEn Response Body에 응답할 Message (영어)
     * @param data 연산 뒤 처리 결과값 객체
     * @param pagination Paging 관련 값
     * @return <T> DefaultResponse<T> Response Body 응답값
     */

    public static <T> DefaultResponse<T> response(final Integer statusCode, final String MessageKo, final String MessageEn, final T data, final Pagination pagination){
        return (DefaultResponse<T>) DefaultResponse.builder()
                .statusCode(statusCode)
                .MessageKo(MessageKo)
                .MessageEn(MessageEn)
                .data(data)
                .pagination(pagination)
                .build();
    }
}
