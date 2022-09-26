package com.junyharang.model.entity.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * <b>DB에 공통으로 들어갈 값 처리 Class</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDateTime;           // 생성일시

    @LastModifiedDate
    private LocalDateTime modifiedDateTime;           // 수정일시
}
