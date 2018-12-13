package fr.formation.sdj.beans;

import java.util.List;

import fr.formation.sdj.entities.Stock;

public class CommandForm {

	private List<Stock> suppliersCommand;

	public List<Stock> getSuppliersCommand() {
		return suppliersCommand;
	}

	public void setSuppliersCommand(List<Stock> suppliersCommand) {
		this.suppliersCommand = suppliersCommand;
	}

	
}
