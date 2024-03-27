package es.yan.products;

public enum State {
	
	DISPONIBLE("Disponible"), 
	AGOTADO("Agotado"), 
	EN_ESPERA("En espera"), 
	RESERVADO("Reservado"),
	EN_TRANSITO("En tránsito"), 
	DEVUELTO("Devuelto"), 
	DESCATALOGADO("Descatalogado"), 
	EN_REVISION("En revisión"),
	RECHAZADO("Rechazado"), 
	PERSONALIZADO("Personalizado");

	private String estadoTexto;

	private State(String estadoTexto) {
            this.estadoTexto = estadoTexto;
    }

	public String getEstadoTexto() {
		return estadoTexto;
	}
}
