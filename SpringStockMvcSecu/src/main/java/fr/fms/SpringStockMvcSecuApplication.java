package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringStockMvcSecuApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecuApplication.class, args);
	}
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
  
	@Override
	public void run(String... args) throws Exception {
//		articleRepository.save(new Article(null, "Apple - iPhone 13", 1023));
//		articleRepository.save(new Article(null, "Apple - iPhone 13 - Lumière Stellaire", 1209.0));
//		articleRepository.save(new Article(null, "Samsung - S20", 250));
//		articleRepository.save(new Article(null, "Samsung - S15+", 28));
//		articleRepository.save(new Article(null, "Samsung - S10+", 350));
//		articleRepository.save(new Article(null, "Xiaomi - MI10", 100));
//		articleRepository.save(new Article(null, "Samsung - GalaxyTab", 450));
//		articleRepository.save(new Article(null, "Apple - Ipad Pro", 850));
//		articleRepository.save(new Article(null, "Asus - R510", 600));	
		
//		for(String article: articleRepository.findOneByCategoryId((long) 3)) {
//			System.out.println(article);
//		}	
		 
		System.out.println("--------");
		Article art = new Article((long)125, "apple", 100, new Category((long) 12, "test"));
		System.out.println(art);
		System.out.println(art.getCategory().getId());
		
		System.out.println("---");
//		if(articleRepository.findAllByCategoryId((long) 1) != null) 	
//			System.out.println(articleRepository.findAllByCategoryId((long) 1));
//		else
//			System.out.println("dommage");
		
//		for(Article article: articleRepository.findAllByCategoryId((long) 1)) {
//			System.out.println(article.toString());
//		}	
		
//		categoryRepository.save(new Category(null, "Smartphone"));
//		categoryRepository.save(new Category(null, "Tablette"));
//		categoryRepository.save(new Category(null, "PC"));
		
//		articleRepository.findAll().forEach(a -> System.out.println(a));
	}

}
