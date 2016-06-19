package model;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exception.IncidenteException;
import util.MaskFields;

public class IncidenteTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_DATA_INCIDENTE = 0;
	private static final int COL_DATA_SINTOMA = 1;
	private static final int COL_SINTOMA = 2;
	private static final int COL_IDPACIENTE = 3;

	// List que recebe o resultados do IncidenteDao para ser manipulado e exibido na jTable
	private List<Incidente> valores;

	
	
	public IncidenteTableModel() {
		super();
	}

	public IncidenteTableModel(List<Incidente> valores) {
		super();
		this.valores = valores;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		//Qual é o nome das nossas colunas?
		if (column == COL_DATA_INCIDENTE) return "DataIncidente";
		if (column == COL_DATA_SINTOMA) return "DataSintoma";
		if (column == COL_SINTOMA) return "Sintoma";
		if (column == COL_IDPACIENTE) return "idPaciente";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column)  {
		//Precisamos retornar o valor da coluna column e da linha row.
		Incidente incidente = valores.get(row);
		if (column == COL_DATA_INCIDENTE)
			return (new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataIncidente()));
		else 
			if (column == COL_DATA_SINTOMA) 
				return (new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataSintoma()));
			else 
				if (column == COL_SINTOMA) 
					return 	incidente.getSintomas();
				else 
					if (column == COL_IDPACIENTE)
						return incidente.getPaciente();
							
		return ""; //Nunca deve ocorrer
	}
	 
	public Incidente get(int row) throws IncidenteException {
		if (row < 0){
			throw new IncidenteException("Selecione um cliente");
		}
		return valores.get(row);
	}

}
