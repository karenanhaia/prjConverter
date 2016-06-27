package prjConverter;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppConverter extends Application
{	
	ConverterWindow converterWindow=null;
	Converter converter=null;
	
	public AppConverter()
	{
		converterWindow = new ConverterWindow();
		converter = new Converter(converterWindow);
	}
	@Override
	public void start(Stage stage) throws Exception 
	{
		stage.setScene(converterWindow);		
		stage.show();
	}	
	
	
	public static void main(String args[])
	{
		launch();
	}
}
