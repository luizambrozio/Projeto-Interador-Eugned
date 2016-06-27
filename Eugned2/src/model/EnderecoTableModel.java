/**
 * @author ambrozio
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EnderecoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
//	private static final int COL_ID = 3;
	private static final int COL_NOME = 0;
	private static final int COL_CPF = 1;

	private List<Endereco> valores;       

	//Esse � um construtor, que recebe a nossa lista de produtos
	public EnderecoTableModel(List<Endereco> valores) {
		this.valores = new ArrayList<Endereco>(valores);
	}
	
	public EnderecoTableModel() {
		this.valores = new ArrayList<Endereco>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public String getColumnName(int column) {
		//Qual � o nome das nossas colunas?
		//if (column == COL_ID) return "ID";
		if (column == COL_NOME) return "Nome";
		if (column == COL_CPF) return "CPF";
		return ""; //Nunca deve ocorrer
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) { 
		Endereco endereco = valores.get(rowIndex);
			if (columnIndex == COL_NOME) 
					return endereco.getBairro();
			else 
				if (columnIndex == COL_CPF) 
					return endereco.getCep();
		return ""; //Nunca deve ocorrer
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Endereco endereco = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no par�metro.
		//Note que vc poderia alterar 2 campos ao inv�s de um s�.
//		if (columnIndex == COL_ID)
//			endereco.setId(Integer.parseInt(aValue.toString()));
//		else 
			if (columnIndex == COL_NOME) 
				endereco.setBairro(aValue.toString());
			else 
				if (columnIndex == COL_CPF) 
					endereco.setCep(aValue.toString());
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
	public Endereco get(int row) {
		return valores.get(row);
	}
}






	

