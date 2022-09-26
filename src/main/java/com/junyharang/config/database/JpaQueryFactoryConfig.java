package com.junyharang.config.database;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <b>JPA Query Factory 설정</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

@Configuration
public class JpaQueryFactoryConfig {

    @PersistenceContext private EntityManager entityManager;

    @Bean public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
