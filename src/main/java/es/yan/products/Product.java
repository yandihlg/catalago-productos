package es.yan.products;

import es.yan.categorys.Category;
import es.yan.mipymes.Mipymes;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cp_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descriptions;
	private double cost;
	private int existence;
	private String image;
	@Enumerated(EnumType.STRING)
	private State state;
	@ManyToOne
	private Category productCategory;
	@ManyToOne
	private Mipymes mipymes;
	private boolean enable;

	// se hace necesario agregar un comentario o reseña del producto de tal forma
	// que nos permita valorar el mismo eso es otro modulo

}
