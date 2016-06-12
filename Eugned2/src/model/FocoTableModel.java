package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import exception.FocoException;

public class FocoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_DATA = 0;
	private static final int COL_BAIRRO = 1;
	private static final int COL_ENDERECO = 2;

	// List que recebe o resultados do FocoDao para ser manipulado e exibido na jTable
	private List<Foco> valores;

	
	
	public FocoTableModel() {
		super();
	}

	public FocoTableModel(List<Foco> valores) {
		super();
		this.valores = valores;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		//Qual é o nome das nossas colunas?
		if (column == COL_DATA) return "Data";
		if (column == COL_BAIRRO) return "Bairro";
		if (column == COL_ENDERECO) return "Endereço";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column)  {
		//Precisamos retornar o valor da coluna column e da linha row.
		Foco foco = valores.get(row);
		if (column == COL_DATA)
			return foco.getDataFoco();
		else 
			if (column == COL_BAIRRO) 
					return foco.getEndereco().getBairro();
			else 
				if (column == COL_ENDERECO) 
					return 	foco.getEndereco().getRua() +", "+
							foco.getEndereco().getNumero() + " - " +
							foco.getEndereco().getCidade() +"-"+
							foco.getEndereco().getEstado();
		return ""; //Nunca deve ocorrer
	}
	
	//J� que esse tableModel � de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Foco get(int row) throws FocoException {
		if (row < 0){
			throw new FocoException("Selecione um cliente");
		}
		return valores.get(row);
	}

}
