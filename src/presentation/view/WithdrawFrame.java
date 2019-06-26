package presentation.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import presentation.constant.ColorConstant;
import presentation.template.TemplateButton;
import presentation.template.TemplateFrame;

public class WithdrawFrame extends TemplateFrame {

    private Font labelsFont;
    private JLabel amountText;
    private JButton button10k;
    private JButton button30k;
    private JButton button60k;
    private JButton button80k;
    private JButton button100k;
    private JButton button200k;
    private JButton button300k;
    private JButton otherButton;

    public WithdrawFrame() {
        amountText = new JLabel();
        button10k = new TemplateButton();
        button30k = new TemplateButton();
        button60k = new TemplateButton();
        button80k = new TemplateButton();
        button100k = new TemplateButton();
        button200k = new TemplateButton();
        button300k = new TemplateButton();
        otherButton = new TemplateButton();
        labelsFont = new Font("Comic Sans MS", Font.BOLD, 70);
    }

    @Override
    public void addComponents() {
        add(amountText);
        add(button10k);
        add(button30k);
        add(button60k);
        add(button80k);
        add(button100k);
        add(button200k);
        add(button300k);
        add(otherButton);
    }

    public JButton getButton10k() {
        return button10k;
    }

    public JButton getButton30k() {
        return button30k;
    }

    public JButton getButton60k() {
        return button60k;
    }

    public JButton getButton80k() {
        return button80k;
    }

    public JButton getButton100k() {
        return button100k;
    }

    public JButton getButton200k() {
        return button200k;
    }

    public JButton getButton300k() {
        return button300k;
    }

    public JButton getOtherButton() {
        return otherButton;
    }

    public void setComponentsProperties() {
        setAmountTextProperties();
        setButton10kProperties();
        setButton30kProperties();
        setButton60kProperties();
        setButton80kProperties();
        setButton100kProperties();
        setButton200kProperties();
        setButton300kProperties();
        setOtherButtonProperties();
    }

    private void setAmountTextProperties() {
        amountText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.15));
        amountText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        amountText.setForeground(ColorConstant.getBlack());
        amountText.setFont(labelsFont);
        amountText.setText("Elige un monto");
        amountText.setHorizontalAlignment(JLabel.CENTER);
        amountText.setVerticalAlignment(JLabel.CENTER);
    }

    private void setButton10kProperties() {
        button10k.setLocation((int) (getWidth() * 0.20), (int) (getHeight() * 0.35));
        button10k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button10k.setText("$10.000");

    }

    private void setButton30kProperties() {
        button30k.setLocation((int) (getWidth() * 0.20), (int) (getHeight() * 0.50));
        button30k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button30k.setText("$30.000");

    }

    private void setButton60kProperties() {
        button60k.setLocation((int) (getWidth() * 0.20), (int) (getHeight() * 0.65));
        button60k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button60k.setText("$60.000");

    }

    private void setButton80kProperties() {
        button80k.setLocation((int) (getWidth() * 0.20), (int) (getHeight() * 0.80));
        button80k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button80k.setText("$80.000");

    }

    private void setButton100kProperties() {
        button100k.setLocation((int) (getWidth() * 0.67), (int) (getHeight() * 0.35));
        button100k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button100k.setText("$100.000");

    }

    private void setButton200kProperties() {
        button200k.setLocation((int) (getWidth() * 0.67), (int) (getHeight() * 0.50));
        button200k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button200k.setText("$200.000");

    }

    private void setButton300kProperties() {
        button300k.setLocation((int) (getWidth() * 0.67), (int) (getHeight() * 0.65));
        button300k.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        button300k.setText("$300.000");

    }

    private void setOtherButtonProperties() {
        otherButton.setLocation((int) (getWidth() * 0.67), (int) (getHeight() * 0.80));
        otherButton.setSize((int) (getWidth() * 0.125), (int) (getHeight() * 0.10));
        otherButton.setText("Otro");
    }

}
