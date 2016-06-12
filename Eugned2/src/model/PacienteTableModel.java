package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PacienteTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_CPF = 1;

	private List<Paciente> valores;       

	//Esse é um construtor, que recebe a nossa lista de Pacientes
	public PacienteTableModel(List<Paciente> valores) {
		this.valores = new ArrayList<Paciente>(valores);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public String getColumnName(int column) {
		//Qual � o nome das nossas colunas?
		if (column == COL_NOME) return "Nome do Paciente";
		if (column == COL_CPF) return "CPF";
		return ""; //Nunca deve ocorrer
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}

