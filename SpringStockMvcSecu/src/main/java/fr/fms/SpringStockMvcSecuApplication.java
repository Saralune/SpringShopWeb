package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@SpringBootApplication
public class SpringStockMvcSecuApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecuApplication.class, args);
	}
	
	@Autowired
	private ArticleRepository articleRepository;
  
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
		
//		articleRepository.findAll().forEach(a -> System.out.println(a));
	}

}
