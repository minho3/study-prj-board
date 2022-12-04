package com.study.prjboard.dto;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.study.prjboard.domain.ArticleComment} entity
 */
public record ArticleCommentDto(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy,
                                String content) {
    public static ArticleCommentDto of (LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}