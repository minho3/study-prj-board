package com.study.prjboard.dto;


/**
 * A DTO for the {@link com.study.prjboard.domain.Article} entity
 */
public record ArticleUpdateDto(String title, String content, String hashtag){
    public static ArticleUpdateDto of (String title, String content, String hashtag) {
        return new ArticleUpdateDto(title, content, hashtag);
    }
}