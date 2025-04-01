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
        String cmd = e.getActionCommand();
        if (cmd.equals("Calculadora Científica")) {
            calc.setVisible(false);
            calcScientific = new CalculadoraScientific();
            calcScientific.setVisible(true);
        } else if (cmd.equals("Calculadora Básica")) {
            calcScientific.setVisible(false);
            calc = new Calculadora();
            calc.setVisible(true);
        }
        else if (cmd.equals("Modo Oscuro")) {
            if(calc !=null && calc.isVisible()) {
                calc.setDarkMode();
            } else if (calcScientific !=null && calcScientific.isVisible()) {
                calcScientific.setDarkMode();
            }
        }
    }
}
