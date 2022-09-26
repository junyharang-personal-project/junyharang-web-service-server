package com.junyharang.config.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * <b>JPA 사용을 위한 관리 설정 Class</b>
 *
 * @author 주니하랑
 * @version 1.0.0, 2022.08.19 초기구성
*/

@EnableJpaAuditing
@Configuration
public class JpaAuditingConfig {}
