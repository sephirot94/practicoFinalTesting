package Truco;


public class Carta {
	
	private Palo palo;
	private Integer numero;
	private Integer valor;

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
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public Boolean esFigura(Carta carta){
		if(carta.getNumero().equals(10) || carta.getNumero().equals(11) || carta.getNumero().equals(12) ){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esAnchoEspada(Carta carta){
		if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.espada)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esAnchoBasto(Carta carta){
		if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.basto)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esSieteEspada(Carta carta){
		if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.espada)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean esSieteOro(Carta carta){
		if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.oro)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public String compararCartas(Carta carta1, Carta carta2){
		if(carta1.getValor() > carta2.getValor()){
			return "ganador carta 1";
		}
		if(carta1.getValor() < carta2.getValor()){
			return "ganador carta 2";
		}
		if(carta1.getValor().equals(carta2.getValor())){
			return "empate";
		}
		return "";
	}
	
}
