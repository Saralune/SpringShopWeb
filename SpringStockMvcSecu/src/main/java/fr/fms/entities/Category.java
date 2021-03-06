/**
 * 
 */
package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Stagiaires10P
 *
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Category implements Serializable {
	private static final long serialVersionUID = 2L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "category")
	private Collection<Article> articles; //Une catégorie est liée à plusieurs articles

	/**
	 * @param id
	 * @param name
	 */
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}	
}
