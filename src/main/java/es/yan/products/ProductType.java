package es.yan.products;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {

	Productos(Arrays.asList("Arroz", "Frijoles", "Harina", "Cerveza", "Malta")),
	Servicios(Arrays.asList("Reparar carros", "Cuidado de ancianos"));

	private List<String> lista;

	private ProductType(List<String> list) {
		this.lista = list;
	}

	@JsonValue
	public List<String> getList() {
		return lista;
	}

}
