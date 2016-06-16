package model;
/**
 * 
 * @author wagmattei
 * Enum utilizado para os campo que registram o sexo das pessoas
 * Esta informação facilitará o preenchimento dos combobox e lists e a 
 * tabulação dos dados em relatório e gráficos 
 *
 */

public enum EnumSexo {
	
	 MASCULINO(1,"Masculino"), 
	 FEMININO(2,"Feminino");
	
	private int codigo;
	private String descricao;
	
	private EnumSexo(int codigo, String descricao) {
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
