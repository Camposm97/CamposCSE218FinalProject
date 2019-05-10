package camposfx.event;

import java.util.Iterator;
import java.util.LinkedList;

import campos.model.Company;
import campos.model.ChosenOnes;
import campos.model.Symbol;
import camposfx.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioMenuItem;

public class CompanyChooserHandler implements EventHandler<ActionEvent> {
	private String name;
	private LinkedList<Company> companyBag;
	
	public CompanyChooserHandler(RadioMenuItem menuItem, LinkedList<Company> companyBag) {
		this.name = menuItem.getText().toUpperCase();
		this.companyBag = companyBag;
	}
	
	@Override
	public void handle(ActionEvent e) {
		switch(name) {
		case "AMAZON":
			findCompanyBySymbol(Symbol.AMZN);
			break;
		case "APPLE":
			findCompanyBySymbol(Symbol.AAPL);
			break;
		}
	}
	
	public void findCompanyBySymbol(Symbol symbol) {
		Iterator<Company> iter = companyBag.iterator();
		while (iter.hasNext()) {
			Company c = iter.next();
			if (c.getSymbol().equals(symbol)) {
				ChosenOnes.setCompany(c);
				ChosenOnes.root.setCenter(FXUtil.loadBackground());
			}
		}
	}
}
