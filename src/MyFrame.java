import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class MyFrame extends JFrame {
    private Color color1 = Color.lightGray;
    private Color color2 = Color.white;
    private Color color3 = Color.black;
    private Color color4 = Color.green;

    private Font font1 = new Font("Arial", Font.PLAIN, 25);
    private Font font2 = new Font("Arial", Font.PLAIN, 20);
    private Border border1 = BorderFactory.createLineBorder(Color.black, 3);
    private Border border2 = BorderFactory.createLineBorder(Color.black, 1);
    private Border border3 = BorderFactory.createLineBorder(Color.lightGray, 1);

    private int frameW = 1000;
    private int frameH = 600;

    private int panelW = (int) (frameW * 0.3);
    private int panelH = (int) (frameH * 0.6);

    private int inputL = (int) (frameW * 0.1);
    private int inputT = (int) (frameH * 0.1);
    private int outputL = (int) (frameW * 0.1 * 2 + frameW * 0.3);
    private int outputT = (int) (frameH * 0.1);

    private int textW = (int) (panelW * 0.9);
    private int textH = (int) (panelH * 0.6);
    private int textL = (int) (panelW * 0.05);
    private int textT = (int) (panelH * 0.3);

    private int btnW = 70;
    private int btnH = 40;
    private int btnL = (int) (frameW / 2 - btnW * 1.2);
    private int btnT = (int) (frameH * 0.8);

    public MyFrame() {
        // frame //
        this.setSize(1000, 600);
        this.setTitle("Compilation TP1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(color1);

        this.setLayout(null);
        // //

        // input panel //
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(inputL, inputT, panelW, panelH);
        inputPanel.setBackground(color2);
        inputPanel.setBorder(border1);
        inputPanel.setLayout(null);

        JLabel inputLabel = new JLabel("Input");
        inputLabel.setBounds(70, 10, 100, 30);
        inputLabel.setFont(font1);
        inputPanel.add(inputLabel);

        JTextArea inputText = new JTextArea();
        inputText.setBounds(textL, textT, textW, textH);
        inputText.setBackground(color2);
        inputText.setOpaque(true);
        inputText.setBorder(border2);
        inputText.setFont(font2);
        inputText.setForeground(color3);
        inputText.setLayout(null);
        inputPanel.add(inputText);

        this.add(inputPanel);
        // //

        // output panel //
        JPanel outputPanel = new JPanel();
        outputPanel.setBounds(outputL, outputT, panelW, panelH);
        outputPanel.setBackground(color2);
        outputPanel.setBorder(border1);
        outputPanel.setLayout(null);

        JLabel outputLabel = new JLabel("Output");
        outputLabel.setBounds(70, 10, 100, 30);
        outputLabel.setFont(font1);
        outputPanel.add(outputLabel);

        JLabel outputText = new JLabel("The Result Will Showed Here");
        outputText.setBounds(textL, textT, textW, textH);
        outputText.setBackground(color2);
        outputText.setOpaque(true);
        outputText.setBorder(border2);
        outputText.setFont(font2);
        outputText.setForeground(color3);
        outputPanel.add(outputText);

        this.add(outputPanel);
        // //

        // Run Button //
        JButton btn = new JButton("OK");
        btn.setBounds(btnL, btnT, btnW, btnH);
        btn.setBackground(color4);
        btn.setOpaque(true);
        btn.setBorder(border3);
        btn.setFont(font2);
        btn.setForeground(color3);
        btn.setFocusable(false);

        btn.addActionListener(e -> {
            outputText.setText(TP01_EX01.splitToWords(inputText.getText()));
        });

        this.add(btn);
        // //

        this.setVisible(true);
    }

}
