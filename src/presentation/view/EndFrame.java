package presentation.view;

import java.awt.Font;
import javax.swing.JLabel;
import presentation.constant.ColorConstant;
import presentation.template.TemplateFrame;


public class EndFrame extends TemplateFrame{
    
    private Font labelsFont;
    private JLabel succesText;
    private JLabel retireText;
    private JLabel warningText;

    public EndFrame() {
            labelsFont = new Font("Comic Sans MS", Font.BOLD, 100);
            succesText = new JLabel();
            retireText = new JLabel();
            warningText = new JLabel();
    }

    @Override
    public void addComponents() {
        add(succesText);
        add(retireText);
        add(warningText);
    }
    

    @Override
    public void setComponentsProperties() {
        setSuccesTextProperties();
        setRetireTextProperties();
        setWarningTextProperties();
    }
    public void showWarningMessage(String text) {
        warningText.setText(text);
        succesText.setVisible(false);        
        warningText.setVisible(true);
    }
    
    public void setSuccesTextProperties(){
        succesText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        succesText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        succesText.setForeground(ColorConstant.BLACK);
        succesText.setFont(labelsFont);
        succesText.setText("Transaccion Realizada");
        succesText.setHorizontalAlignment(JLabel.CENTER);
        succesText.setVerticalAlignment(JLabel.CENTER);
        
    }
    public void setRetireTextProperties(){
        retireText.setLocation(succesText.getX(), succesText.getY() + succesText.getHeight() + 20);
        retireText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        retireText.setForeground(ColorConstant.BLACK);
        retireText.setFont(labelsFont);
        retireText.setText("Retire su tarjeta");
        retireText.setHorizontalAlignment(JLabel.CENTER);
        retireText.setVerticalAlignment(JLabel.CENTER);
        
    }
    public void setWarningTextProperties(){
        warningText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        warningText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        warningText.setForeground(ColorConstant.BLACK);
        warningText.setFont(labelsFont);       
        warningText.setHorizontalAlignment(JLabel.CENTER);
        warningText.setVerticalAlignment(JLabel.CENTER);
        warningText.setVisible(false); 
    }
}
