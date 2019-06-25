
package presentation.view;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import presentation.template.TemplateFrame;

public class TransferFrame extends TemplateFrame{
    
    private Font font;
    private JLabel lblNumeroCuenta;
    private JLabel lblMonto;
    private JFormattedTextField txtNumeroCuenta;
    private JFormattedTextField txtMonto;
    
    public TransferFrame(){
        this.font = new Font("Comic Sans MS", Font.BOLD, 25);
        this.lblNumeroCuenta = new JLabel();
        this.lblMonto = new JLabel();
        this.txtMonto = new JFormattedTextField(new Integer(0));
        this.txtNumeroCuenta = new JFormattedTextField(new Integer(0));
        this.init();   
    }

    @Override
    public void addComponents() {
        this.add(lblNumeroCuenta);
        this.add(lblMonto);
    }

    @Override
    public void setComponentsProperties() {
        this.setLblNumeroCuentaProperties();
        this.setLblMontoProperties();
        this.setTxtNumeroCuentaProperties();
        this.setTxtMontoProperties();
    }

    private void setLblNumeroCuentaProperties() {
        this.lblNumeroCuenta.setFont(font);
        this.lblNumeroCuenta.setText("Ingrese el número de cuenta Destino:");
        this.lblNumeroCuenta.setSize((int) (this.getWidth() * 0.25), (int) (this.getHeight()* 0.1));
        this.lblNumeroCuenta.setLocation((int) (this.getWidth() * 0.25), (int) (this.getHeight()* 0.3));
    }

    private void setLblMontoProperties() {
        this.lblMonto.setFont(font);
        this.lblMonto.setText("Ingrese el Valor a Transferir");
        this.lblMonto.setSize((int) (this.getWidth() * 0.25), (int) (this.getHeight()* 0.1));
        this.lblMonto.setLocation((int) (this.getWidth() * 0.5), (int) (this.getHeight()* 0.3));
    }

    private void setTxtNumeroCuentaProperties() {
        this.txtNumeroCuenta.setFont(font);
        this.txtNumeroCuenta.setSize((int) (this.getWidth() * 0.3), (int) (this.getHeight()* 0.1));
        this.txtNumeroCuenta.setLocation((int) (this.getWidth() * 0.35), (int) (this.getHeight()* 0.3));
    }

    private void setTxtMontoProperties() {
        this.txtMonto.setFont(font);
        this.txtMonto.setSize((int) (this.getWidth() * 0.3), (int) (this.getHeight()* 0.1));
        this.txtMonto.setLocation((int) (this.getWidth() * 0.35), (int) (this.getHeight()* 0.3));
    }
    
}
