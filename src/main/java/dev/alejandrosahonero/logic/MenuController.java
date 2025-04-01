package dev.alejandrosahonero.logic;

import dev.alejandrosahonero.gui.Calculadora;
import dev.alejandrosahonero.gui.CalculadoraScientific;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private Calculadora calc;
    private CalculadoraScientific calcScientific;
    public MenuController(Calculadora calc) {
        this.calc = calc;
    }
    public MenuController(CalculadoraScientific calcScientific) {
        this.calcScientific = calcScientific;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculadora Científica")) {
            calc.setVisible(false);
            calcScientific = new CalculadoraScientific();
            calcScientific.setVisible(true);
        } else if (e.getActionCommand().equals("Calculadora Básica")) {
            calcScientific.setVisible(false);
            calc = new Calculadora();
            calc.setVisible(true);
        }
    }
}
