package com.junyharang.controller.sample;

import com.junyharang.constant.APIUriInfo;
import com.junyharang.constant.DefaultResponseMessage;
import com.junyharang.constant.SwaggerApiInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Test Controller</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

@RequiredArgsConstructor
@Slf4j
@Api(tags = "Test Slack Alarm API")
@ApiOperation(value = SwaggerApiInfo.POSTING)
@RestController
public class SampleController {

    @ApiOperation(value = SwaggerApiInfo.TEST, notes = "Slack 및 Console Java Exception Logging Test 입니다.")
    @ApiResponses(value = {
            @ApiResponse(code = DefaultResponseMessage.OK, message = DefaultResponseMessage.KOREAN_200),
            @ApiResponse(code = DefaultResponseMessage.NOT_FOUND, message = DefaultResponseMessage.KOREAN_404),
            @ApiResponse(code = DefaultResponseMessage.UN_AUTHORIZATION, message = DefaultResponseMessage.KOREAN_401),
            @ApiResponse(code = DefaultResponseMessage.SERVER_ERROR, message = DefaultResponseMessage.KOREAN_500)
    })

    @GetMapping(value = APIUriInfo.TEST_LOG_BACK, produces = "text/plain;charset=UTF-8")
    public String logbackTest(HttpServletRequest request, HttpServletResponse response) {
        String requestURI = request.getRequestURI();

        try {
            String messagePrefix = "Slack 및 Console LogBack Test 중 입니다! 출력 Error 단계를 확인 하겠습니다! \n";

            log.debug(messagePrefix + "Debug 단계 Log 출력입니다!");
            log.info(messagePrefix + "Info 단계 Log 출력입니다! ");
            log.trace(messagePrefix + "trace 단계 Log 출력 입니다!");
            log.warn(messagePrefix + "warning 단계 Log 출력 입니다!");
            log.error(messagePrefix + "error 단계 Log 출력 입니다!");
            throw new IllegalArgumentException("test");
        } catch (RuntimeException e) {
            log.error("requestURI = ({}), request = ({}), e.getMessage = ({}), e = ({})", requestURI, request, e.getMessage(), e);
            return "Local 환경에서 해당 API 호출 시 IDE Console 확인해 주세요. DEV, Operation 환경에서 API 호출 시 Slack 확인 해 주세요. 헤헤";
        }
    }
}
