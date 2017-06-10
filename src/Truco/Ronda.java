package Truco;

public class Ronda {
	
	private Boolean envido;
	private Boolean truco;
	private Boolean reTruco;
	private Boolean valeCuatro;
	private Boolean flor;
	
	public Ronda(){
		this.setEnvido(Boolean.FALSE);
		this.setTruco(Boolean.FALSE);
		this.setReTruco(Boolean.FALSE);
		this.setValeCuatro(Boolean.FALSE);
		this.setFlor(Boolean.FALSE);
	}

	public Boolean getEnvido() {
		return envido;
	}

	public void setEnvido(Boolean envido) {
		this.envido = envido;
	}

	public Boolean getTruco() {
		return truco;
	}

	public void setTruco(Boolean truco) {
		this.truco = truco;
	}

	public Boolean getReTruco() {
		return reTruco;
	}

	public void setReTruco(Boolean reTruco) {
		this.reTruco = reTruco;
	}

	public Boolean getValeCuatro() {
		return valeCuatro;
	}

	public void setValeCuatro(Boolean valeCuatro) {
		this.valeCuatro = valeCuatro;
	}

	public Boolean getFlor() {
		return flor;
	}

	public void setFlor(Boolean flor) {
		this.flor = flor;
	}
	
	
	public void truco(){
		this.setTruco(Boolean.TRUE);
	}
	
	public void reTruco(){
		this.setReTruco(Boolean.TRUE);
	}
	
	public void valeCuatro(){
		this.setValeCuatro(Boolean.TRUE);
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
