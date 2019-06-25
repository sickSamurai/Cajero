package presentation.view;

import java.awt.Font;
import javax.swing.JLabel;

import presentation.template.ColorConstants;
import presentation.template.TemplateButton;
import presentation.template.TemplateFrame;

public class OperationFrame extends TemplateFrame{
    
    private JLabel operationText;   
    private Font labelsFont;
    private TemplateButton withdrawButton;
    private TemplateButton insertButton;
    
    public OperationFrame (){
        operationText = new JLabel();
        withdrawButton = new TemplateButton();
        insertButton = new TemplateButton();
        labelsFont = new Font("Comic Sans MS", Font.BOLD, 70);        
    }
    
    @Override
    public void addComponents() {        
        add(operationText);
        add(withdrawButton);
        add(insertButton);
    }
    
    @Override
    public void setComponentsProperties() {
        setOperationTextProperties(); 
        setWithdrawButtonProperties();  
        setInsertButtonProperties();  
        
    }
    private void setOperationTextProperties() {
        operationText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        operationText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        operationText.setForeground(ColorConstants.getBlack());
        operationText.setFont(labelsFont);
        operationText.setText("¿Qué desea hacer?");
        operationText.setHorizontalAlignment(JLabel.CENTER);
        operationText.setVerticalAlignment(JLabel.CENTER);
    }
    
    private void setWithdrawButtonProperties(){
        withdrawButton.setLocation((int) (getWidth() * 0.72), (int) (getHeight() * 0.50)); 
        withdrawButton.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));  
        withdrawButton.setText("Retirar dinero");
        
    }
     private void setInsertButtonProperties(){
        insertButton.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.50));
        insertButton.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));           
        insertButton.setText("Insertar dinero");
        
    }
    
     
}
