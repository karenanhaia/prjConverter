package prjConverter;

import javafx.beans.value.ObservableValue;

public class Converter 
{
	ConverterWindow cw = null;
	String[] international = {"Centímetro", "Metro", "Kilometro", "Grama", "Kilo" , "Litro"}; 
	String[] english       = {"Polegada"  , "Jarda", "Milha"    , "Onça" , "Libra", "Galão"};
	
	
	private void englishFromInternational(ObservableValue<?> obs, Number ov, Number nv)
	{
		switch(cw.currentSelectionProperty().intValue())
		{
		case 0:
			cw.setValueForSystemB(nv.floatValue() * 0.393701f);
		break;
		case 1:
			cw.setValueForSystemB(nv.floatValue() * 1.09361f);
		break;
		case 2:
			cw.setValueForSystemB(nv.floatValue() * 0.621371f);
		break;
		case 3:
			cw.setValueForSystemB(nv.floatValue() * 0.035274f);
		break;
		case 4:
			cw.setValueForSystemB(nv.floatValue() * 2.20462f);
		break;
		case 5:
			cw.setValueForSystemB(nv.floatValue() * 0.264172f);
		break;
		}
	}
	
	private void internationalFromEnglish(ObservableValue<?> obs, Number ov, Number nv)
	{
		switch(cw.currentSelectionProperty().intValue())
		{
		case 0:
			cw.setValueForSystemA(nv.floatValue()*2.54f);
		break;
		case 1:
			cw.setValueForSystemA(nv.floatValue()*0.9144f);
		break;
		case 2:
			cw.setValueForSystemA(nv.floatValue()*1.60934f);
		break;
		case 3:
			cw.setValueForSystemA(nv.floatValue()*28.3495f);
		break;
		case 4:
			cw.setValueForSystemA(nv.floatValue()*0.453592f);
		break;
		case 5:
			cw.setValueForSystemA(nv.floatValue()*3.78541f);
		break;
		}
	}
	public Converter(ConverterWindow _cw)
	{
		super();
		cw = _cw;
		cw.fetchIntoSystemA(international);
		cw.setNameSystemA("Sistema Internacional");
		cw.fetchIntoSystemB(english);
		cw.setNameSystemB("Sistema Inglês");
		
		cw.addSliderListenerToSystemA(this::englishFromInternational);
		cw.addSliderListenerToSystemB(this::internationalFromEnglish);
	}
}

