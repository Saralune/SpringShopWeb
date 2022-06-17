/**
 * 
 */
package fr.fms.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Article;

/**
 * @author Stagiaires10P
 *
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Page<Article> findByDescriptionContains(String description, Pageable pageable);
	
	public List<Article> findAllByCategoryId(Long id);

	public Page<Article> findAllArticleByCategoryId(Long id, Pageable pageable);
	//public List<Article> findByCategoryId(Long catId);
	@Query("select A.id, A.description, A.price from Article A JOIN Category C ON (A.category = C.id) WHERE C.id = :x")
	public List<String> findOneByCategoryId(@Param("x") Long catId);
	
	public Page<Article> findByDescriptionContainsAndCategoryId(String description, Long categoryId, Pageable pageable);
}

