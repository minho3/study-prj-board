package com.study.prjboard.repository;

import com.study.prjboard.config.JpaConfig;
import com.study.prjboard.domain.Article;
import com.study.prjboard.domain.UserAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JPARepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final UserAccountRepository userAccountRepository;


    public JPARepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository,
            @Autowired UserAccountRepository userAccountRepository){
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @DisplayName("Select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then

        assertThat(articles)
                .isNotNull()
                .hasSize(123);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //given
        long previousCount = articleRepository.count();
        UserAccount userAccount = userAccountRepository.save(UserAccount.of("newuno", "pw", null, null, null));
        Article article = Article.of(userAccount, "new article", "new content", "#spring");
        //when
        articleRepository.save(article);
        //then

        assertThat(articleRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);

        //when
        Article savedArticle = articleRepository.saveAndFlush(article);
        //then

        assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag",updatedHashtag);
    }

    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();

        //when
        articleRepository.delete(article);

        //then

        assertThat(articleRepository.count())
                .isEqualTo(previousArticleCount-1);
        assertThat(articleCommentRepository.count())
                .isEqualTo(previousArticleCommentCount-deletedCommentsSize);
    }
}