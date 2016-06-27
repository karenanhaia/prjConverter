package prjConverter;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ConverterWindow extends Scene
{	
	SystemPanel spSystemA = new SystemPanel();
	SystemPanel spSystemB = new SystemPanel();
	
	IntegerProperty currentSelection = new SimpleIntegerProperty();
	
	Group root=null;
	public ConverterWindow() 
	{
		super(new Group(), 270,160);
		root = (Group)super.getRoot();
		createScene();
		doBindings();
	}
	
	private void createScene()
	{
		
		spSystemA.getComboBox().setMinWidth(110);
		spSystemB.getComboBox().setMinWidth(110);
		VBox vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.getChildren().add(spSystemA);
		vb.getChildren().add(spSystemB);
		root.getChildren().add(vb);		
	}	
	
	private void doBindings()
	{
		ComboBox<?> cbInt = spSystemA.getComboBox();
		ComboBox<?> cbEng = spSystemB.getComboBox();
		
		cbInt.getSelectionModel().selectedIndexProperty().addListener(
				(obs, ov, nv)->cbEng.getSelectionModel().select(nv.intValue()));
		
		cbEng.getSelectionModel().selectedIndexProperty().addListener(
				(obs, ov, nv)->cbInt.getSelectionModel().select(nv.intValue()));
		
		currentSelection.bind(cbEng.getSelectionModel().selectedIndexProperty());
	}
	
	public int getCurrentSelection()
	{
		return currentSelection.get();
	}
	
	public IntegerProperty currentSelectionProperty()
	{
		return currentSelection;
	}
	
	public void fetchIntoSystemA(String unitList[])
	{
		spSystemA.fetchIntoComboBox(unitList);
	}
	
	public void fetchIntoSystemB(String unitList[])
	{
		spSystemB.fetchIntoComboBox(unitList);
	}
	
	public void setNameSystemA(String name)
	{
		spSystemA.setSystemName(name);
	}
	public void setNameSystemB(String name)
	{
		spSystemB.setSystemName(name);
	}
	
	public Slider getSliderForSystemA()
	{
		return spSystemA.getSlider();
	}
	
	public Slider getSliderForSystemB()
	{
		return spSystemB.getSlider();
	}
	
	
	public void addSliderListenerToSystemA (ChangeListener<? super Number> listener)
	{
		spSystemA.getSlider().valueProperty().addListener(listener);
	}
	
	public void addSliderListenerToSystemB (ChangeListener<? super Number> listener)
	{
		spSystemB.getSlider().valueProperty().addListener(listener);
	}
	
	
	public void setValueForSystemA(float value)
	{
		if(!spSystemA.getSlider().isValueChanging())
			spSystemA.getSlider().setValue(value);
	}
	
	public void setValueForSystemB(float value)
	{
		if(!spSystemB.getSlider().isValueChanging())
			spSystemB.getSlider().setValue(value);
	}
	
}
