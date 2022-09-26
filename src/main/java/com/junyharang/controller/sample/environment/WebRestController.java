package com.junyharang.controller.sample.environment;

import com.junyharang.constant.APIUriInfo;
import com.junyharang.constant.DefaultResponseMessage;
import com.junyharang.constant.SwaggerApiInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <b>구동 환경 별 Profile 확인 API</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

@RestController
@AllArgsConstructor
@RequestMapping(APIUriInfo.NOW_VERSION)
public class WebRestController {

    private Environment env;

    @ApiOperation(value = SwaggerApiInfo.TEST, notes = "현재 구동중인 환경 Test API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(code = DefaultResponseMessage.OK, message = DefaultResponseMessage.KOREAN_200),
            @ApiResponse(code = DefaultResponseMessage.NOT_FOUND, message = DefaultResponseMessage.KOREAN_404),
            @ApiResponse(code = DefaultResponseMessage.UN_AUTHORIZATION, message = DefaultResponseMessage.KOREAN_401),
            @ApiResponse(code = DefaultResponseMessage.SERVER_ERROR, message = DefaultResponseMessage.KOREAN_500)
    })

    @GetMapping(APIUriInfo.TEST_PROFILE)
    public String getEnvironmentProfile() {
        return "Current environment information : " + Arrays.stream(env.getActiveProfiles())
                .filter(env -> "local".equals(env) || "dev".equals(env) || "operation".equals(env))
                .findFirst()
                .orElse("");
    }
}
