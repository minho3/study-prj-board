package com.study.prjboard.repository;

import com.study.prjboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
}
