/**
 * 
 */
package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

/**
 * @author Stagiaires10P
 *
 */
@Controller
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
										@RequestParam(name="keyword", defaultValue = "") String kw) {
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5)); //récup tous les articles
		
		//pour récupérer sous forme de liste la page pointée
		model.addAttribute("listArticle", articles.getContent()); //insert les articles dans le model
		
		//pour afficher des liens de pagination permettant à l'utilisateur de passer d'une page à l'autre, il faut :
		//- récupérer le nombre total de pages
		//- injecter dans le model sous forme de tableau d'enteirs
		//- sur la partie html, il suffira de boucler sur ce tableau pour afficher toutes les pages
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		
		//On transmet la page courante à la vue, thymeleaf pourra vérifier si la page courante est égale à l'index de la page active
		model.addAttribute("currentPage", page);

		model.addAttribute("keyword", kw);
		
		return "articles/articles"; //cette méthode retourne au dispacterServlet une vue
	}
	
	@GetMapping("/delete")
	public String delete(Long id, int page, String keyword) {
		articleRepository.deleteById(id);
		
		return "redirect:/index?page=" + page + "&keyword=" + keyword;
	}
	
	//lien vers la page article
	@GetMapping("/article")
	public String article(Model model) {
		model.addAttribute("article", new Article());
		return "articles/article";
	}
	
	@PostMapping("/save")
	public String save(Model model, @Valid Article article, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "article";
		
		articleRepository.save(article);
		return "redirect:/index";
	}
	
//	@GetMapping("/displayArticlesByCat")
//	public String displayArticlesByCat(Model model, @RequestParam(name="page", defaultValue = "0") int page,
//								@RequestParam(name="category", defaultValue = "0") Long idCat){
//		Page<Article> articles = articleRepository.findAllByCategoryId(idCat, PageRequest.of(page, 5));
//		
//		model.addAttribute("listArticlesByCat", articles);
//		
//		return "articles";
	//}
}
