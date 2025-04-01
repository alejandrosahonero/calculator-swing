package dev.alejandrosahonero.gui;

import dev.alejandrosahonero.logic.CalculatorScientificController;
import dev.alejandrosahonero.logic.MenuController;

import javax.swing.*;
import java.awt.*;

public class CalculadoraScientific extends JFrame {
    private JButton[] btnArray;
    private JTextField display;
    private JMenuBar menuBar;
    private JPanel CalcPanel;

    public CalculadoraScientific() {
        setTitle("Calculadora Científica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        initComponents();
    }
    private void initComponents() {
        CalcPanel = new JPanel(new BorderLayout());
        numPad();
        displayResult();
        add(CalcPanel, BorderLayout.CENTER);
        menu();
    }
    private void menu(){
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem menuBasic = new JMenuItem("Calculadora Básica");
        menuBasic.addActionListener(new MenuController(this));
        menu.add(menuBasic);
        add(menuBar, BorderLayout.NORTH);
    }
    private void displayResult() {
        display = new JTextField("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setPreferredSize(new Dimension(0, 80));
        display.setFont(new Font("Arial", Font.PLAIN, 40));
        CalcPanel.add(display, BorderLayout.NORTH);
    }
    private void numPad(){
        JPanel pad = new JPanel(new GridLayout(5, 5));
        pad.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        String[] botones = {
                "√", "3√", "C", "AC", "sen",
                "7", "8", "9", "/", "cos",
                "4", "5", "6", "*", "tan",
                "1", "2", "3", "-", "atan",
                "0", ".", "π", "+", "="
        };

        btnArray = new JButton[botones.length];
        CalculatorScientificController calculatorScientificController = new CalculatorScientificController(this);

        for (int i = 0; i < botones.length; i++) {
            btnArray[i] = new JButton(botones[i]);
            btnArray[i].setFont(new Font("Arial", Font.PLAIN, 25));
            btnArray[i].addActionListener(calculatorScientificController);
            pad.add(btnArray[i]);
        }
        CalcPanel.add(pad, BorderLayout.CENTER);
    }

    public JTextField getDisplay() {
        return display;
    }
}
