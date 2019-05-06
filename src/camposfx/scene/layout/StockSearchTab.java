package camposfx.scene.layout;

import campos.model.ChosenOnes;
import campos.model.Company;
import camposfx.scene.control.NonEditTextField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class StockSearchTab extends Tab {
	protected Company c;
	protected TextField tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;

	public StockSearchTab(String string) {
		super(string);
		initControls();
	}

	protected void initControls() {
		this.c = ChosenOnes.company;
		tfOpenValue = new NonEditTextField();
		tfHighValue = new NonEditTextField();
		tfLowValue = new NonEditTextField();
		tfCloseValue = new NonEditTextField();
		tfVolume = new NonEditTextField();
	}

	public TextField getTfOpenValue() {
		return tfOpenValue;
	}

	public TextField getTfHighValue() {
		return tfHighValue;
	}

	public TextField getTfLowValue() {
		return tfLowValue;
	}

	public TextField getTfCloseValue() {
		return tfCloseValue;
	}

	public TextField getTfVolume() {
		return tfVolume;
	}
}
