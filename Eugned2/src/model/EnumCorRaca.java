package model;
/**
 * 
 * @author wagmattei
 * Enum utilizado para os campo que registram a cor e a raça das pessoas
 * Esta informação facilitará o preenchimento dos combobox e lists e a 
 * tabulação dos dados em relatório e gráfico 
 *
 */

public enum EnumCorRaca {
	
	 BRANCO(1,"Branco"), 
	 NEGRO(2,"Negro"), 
	 PARDOMULATO(3,"Pardo/Mulato"), 
	 AMARELO(4,"Amarelo (Oriental)"), 
	 INDIGENA(5,"Indigena");
	
	private int codigo;
	private String descricao;
	
	private EnumCorRaca(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}

}
