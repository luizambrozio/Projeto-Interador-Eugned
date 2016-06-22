package model;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exception.IncidenteException;
import util.MaskFields;

public class IncidenteEnderecoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ENDERECO = 0;
	private static final int COL_CIDADE = 1;
	private static final int COL_ESTADO = 2;

	// List que recebe o resultados do IncidenteDao para ser manipulado e exibido na jTable
	private List<IncidenteEndereco> valores;

	
	
	public IncidenteEnderecoTableModel() {
		super();
	}

	public IncidenteEnderecoTableModel(List<IncidenteEndereco> valores) {
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
		if (column == COL_ENDERECO) return "Endereço";
		if (column == COL_CIDADE) return "Cidade";
		if (column == COL_ESTADO) return "Estado";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column)  {
		//Precisamos retornar o valor da coluna column e da linha row.
		IncidenteEndereco incidenteEndereco = valores.get(row);
		if (column == COL_ENDERECO)
			return incidenteEndereco.getEndereco().getRua() +" - "+
					incidenteEndereco.getEndereco().getNumero() +" - "+
						incidenteEndereco.getEndereco().getBairro() +" - Cep "+
					incidenteEndereco.getEndereco().getCep();
		else 
			if (column == COL_CIDADE) 
				return (incidenteEndereco.getEndereco().getCidade());
			else 
				if (column == COL_ESTADO) 
					return 	incidenteEndereco.getEndereco().getEstado();
		return ""; //Nunca deve ocorrer
	}
	 
	public IncidenteEndereco get(int row) throws IncidenteException {
		if (row < 0){
			throw new IncidenteException("Selecione um endereço de incidente");
		}
		return valores.get(row);
	}

}
