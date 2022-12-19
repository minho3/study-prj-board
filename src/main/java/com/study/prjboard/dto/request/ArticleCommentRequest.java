package com.study.prjboard.dto.request;

import com.study.prjboard.dto.ArticleCommentDto;
import com.study.prjboard.dto.UserAccountDto;

/**
 * A DTO for the {@link com.study.prjboard.domain.ArticleComment} entity
 */
public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}