package model;
/**
 * 
 * @author wagmattei
 * Enum para registro do nível de escolaridade das pessoas
 * Esta informação facilitará o preenchimento dos combobox e lists e a 
 * tabulação dos dados em relatório e gráfico 
 *
 */

public enum EnumEscolaridade {
	
	FUNDAMENTAL(1,"Fundamental"),
	MEDIO(2,"Médio"),
	SUPERIOR(3,"Superior"),
	POSGRADUCAO(4,"Pós-Graduação"),
	MESTRADO(5,"Mestrado"),
	DOUTORADO(6,"Doutorado");
	 
	private int codigo;
	private String descricao;
	 
	 
	private EnumEscolaridade(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public String toString() {
		return descricao;
	}
	
}
