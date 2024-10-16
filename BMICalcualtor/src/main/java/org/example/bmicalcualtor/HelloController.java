package org.example.bmicalcualtor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.swing.plaf.basic.BasicMenuUI;

public class HelloController {

    @FXML
    private TextField bmiOutput;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Text close;

    @FXML
    private TextField heightInput;

    @FXML
    private ImageView image;

    @FXML
    private TextField statusOutput;

    @FXML
    private TextField weightInput;
    @FXML
    private RadioButton unitSwitcher;


    @FXML
    void calculate(ActionEvent event) {
        try
        {
            Double weightValue = Double.parseDouble(weightInput.getText());
            Double heightValue = Double.parseDouble(heightInput.getText());
            Double bmiValue;
            {
                if (!unitSwitcher.isSelected()) {
                    bmiValue = weightValue / (heightValue * heightValue);
                }
                else {
                    bmiValue = 703*weightValue / (heightValue*heightValue);

                }
            }

            weightInput.clear();
            heightInput.clear();
            setResult(bmiValue);

        }
        catch (Exception e)
        {

        }
    }
    void setResult(double bmiValue)
    {
        bmiOutput.setText(String.valueOf(bmiValue));
        if(bmiValue <= 18.5)
        {
            statusOutput.setText("Underweight");
        }
        else if(18.6<= bmiValue && bmiValue <= 24.9)
        {
            statusOutput.setText("Normal");
        }
        else if(25 <= bmiValue && bmiValue <= 29.9)
        {
            statusOutput.setText("Overweight");
        }
        else {
            statusOutput.setText("Obese");
        }
    }

    @FXML
    void close(MouseEvent event)
    {
        System.exit(0);
    }
    @FXML
    void clear(MouseEvent event)
    {
        bmiOutput.clear();
        heightInput.clear();
        weightInput.clear();
        statusOutput.clear();
    }
}
