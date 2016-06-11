package model;
/**
 * 
 * @author wagmattei
 * Enum utilizado para os campo que registram o estado civil das pessoas
 * Esta informação facilitará o preenchimento dos combobox e lists e a 
 * tabulação dos dados em relatório e gráficos 
 *
 */

public enum EnumEstadoCivil {
	
	SOLTEIRO(1,"Solteiro"),
	CASADO(2,"Casado"),
	DIVORCIADO(3,"Divorciado"),
	VIUVO(4,"Viúvo");
	
	private int codigo;
	private String descricao;
	
	private EnumEstadoCivil(int codigo, String descricao) {
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
