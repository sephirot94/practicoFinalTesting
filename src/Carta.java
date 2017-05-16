
public class Carta {
	
	private Palo palo;
	private Integer numero;
	
	public Carta(Integer numero, Palo palo){
		this.setNumero(numero);
		this.setPalo(palo);
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public void setPalo(Palo palo) {
		this.palo = palo;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Boolean esFigura(Carta carta){
		if(carta.getNumero().equals(10) || carta.getNumero().equals(11) || carta.getNumero().equals(12) ){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esAnchoEspada(Carta carta){
		if(carta.getNumero().equals(1) && carta.getPalo().equals(palo.espada)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esAnchoBasto(Carta carta){
		if(carta.getNumero().equals(1) && carta.getPalo().equals(palo.basto)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esSieteEspada(Carta carta){
		if(carta.getNumero().equals(7) && carta.getPalo().equals(palo.espada)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esSieteOro(Carta carta){
		if(carta.getNumero().equals(7) && carta.getPalo().equals(palo.oro)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
}
