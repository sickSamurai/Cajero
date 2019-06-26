package logic.database.card;

public class CardDTO {

	private String clave;
	private String numeroTarjeta;		
	
	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getClave() {
		return clave;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

}