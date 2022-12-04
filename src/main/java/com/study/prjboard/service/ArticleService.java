package com.study.prjboard.service;

import com.study.prjboard.domain.type.SearchType;
import com.study.prjboard.dto.ArticleDto;
import com.study.prjboard.dto.ArticleUpdateDto;
import com.study.prjboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly=true)
    public Page<ArticleDto> searchArticle(SearchType title, String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly=true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
