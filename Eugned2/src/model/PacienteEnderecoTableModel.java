package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PacienteEnderecoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
//	private static final int COL_ID = 3;
	private static final int COL_TIPO = 0;
	private static final int COL_ENDERECO = 1;

	private List<PacienteEndereco> valores;
	

	//Esse � um construtor, que recebe a nossa lista de produtos
	public PacienteEnderecoTableModel(List<PacienteEndereco> valores) {
		this.valores = new ArrayList<PacienteEndereco>(valores);
	}
	
	public PacienteEnderecoTableModel() {
		this.valores = new ArrayList<PacienteEndereco>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	public String getColumnName(int column) {
		//Qual � o nome das nossas colunas?
		//if (column == COL_ID) return "ID";
		if (column == COL_TIPO) return "Tipo";
		if (column == COL_ENDERECO) return "Endereço";
		return ""; //Nunca deve ocorrer
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) { 
		PacienteEndereco pacienteEndereco = valores.get(rowIndex);
			if (columnIndex == COL_TIPO) 
					return pacienteEndereco.getTipo().getDescricao();
			else 
				if (columnIndex == COL_ENDERECO)
										
					return pacienteEndereco.getEndereco().getRua() + " - " 
						+ pacienteEndereco.getEndereco().getNumero() + " - " +
						pacienteEndereco.getEndereco().getBairro() + " - " +
						pacienteEndereco.getEndereco().getCidade()+ " - " +
						pacienteEndereco.getEndereco().getEstado();
		return ""; //Nunca deve ocorrer
	}
	


	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, � string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a c�lula da rowIndex e da columnIndex � edit�vel. Nossa tabela toda �.
		return true;
	}
	//J� que esse tableModel � de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public PacienteEndereco get(int row) {
		return valores.get(row);
	}
}






	

