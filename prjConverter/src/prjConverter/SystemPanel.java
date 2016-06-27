package prjConverter;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class SystemPanel extends GridPane 
{
	Label lName;
	Slider slider;
	Label lSliderValue;
	ComboBox<String> cBox;
	
	public SystemPanel()
	{
		super();
		super.setMinSize(250, 75);
		super.setMaxSize(250, 75);
		createControls();
		doLayout();
		doBindings();
	}
	private void createControls()
	{
		lName = new Label("noname");
		lName.setStyle("-fx-font: 13 arial; -fx-font-weight: bold; ");
		slider = new Slider();
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(0);
		slider.showTickMarksProperty().set(true);
		slider.setMajorTickUnit(50);
		slider.setMinorTickCount(10);
		
		lSliderValue = new Label();
		cBox = new ComboBox<>();
		cBox.setVisibleRowCount(5);
		cBox.setEditable(false);
	}
	
	private void doLayout()
	{
		super.setHgap(2);
		super.add(lName,0,0);
		super.setColumnSpan(lName, 3);
		super.add(lSliderValue, 0, 1);
		super.add(new Label(), 1, 1);
		super.add(cBox, 2, 1);
		super.add(slider, 0, 2);
		super.setColumnSpan(slider, 2);
		super.add(new Label(), 1, 2);
		
	}
	private void doBindings()
	{
		lSliderValue.textProperty().bind(slider.valueProperty().asString("%5.3f"));
	}
	
	public void setSystemName(String name)
	{
		this.lName.setText(name);
	}
	
	public String getSystemName()
	{
		return this.lName.getText();
	}
	
	public void setSliderValue(float fv)
	{
		this.slider.setValue(fv);
	}
	
	public Slider getSlider()
	{
		return this.slider;
	}
	
	public void fetchIntoComboBox(String[] list)
	{
		this.cBox.getItems().addAll(list);
	}
	
	public ComboBox<?> getComboBox()
	{
		return this.cBox;
	}
}
