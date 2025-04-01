package dev.alejandrosahonero.logic;

import dev.alejandrosahonero.gui.Calculadora;
import dev.alejandrosahonero.gui.CalculadoraScientific;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private Calculadora calc;
    private CalculadoraScientific calcScientific;
    private String operador = "";
    private double primerNumero = 0;
    private boolean nuevaEntrada = false;

    public CalculatorController(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getText();
        String contenido = calc.getDisplay().getText();

        switch (textoBoton) {
            case "AC":
                calc.getDisplay().setText("");
                operador = "";
                primerNumero = 0;
                nuevaEntrada = false;
                break;

            case "C":
                if (!contenido.isEmpty()) {
                    contenido = contenido.substring(0, contenido.length() - 1);
                    calc.getDisplay().setText(contenido);
                }
                break;

            case "+":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "+";
                    nuevaEntrada = true;
                }
                break;
            case "-":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "-";
                    nuevaEntrada = true;
                }
                break;
            case "*":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "*";
                    nuevaEntrada = true;
                }
                break;
            case "/":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "/";
                    nuevaEntrada = true;
                }
                break;
            case "√":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "√";
                    double resSquare = Math.sqrt(primerNumero);
                    calc.getDisplay().setText(resSquare + "");
                    nuevaEntrada = true;
                }
                break;

            case "=":
                if (!contenido.isEmpty() && !operador.isEmpty()) {
                    double segundoNumero = Double.parseDouble(contenido);
                    double resultado = 0;
                    switch (operador) {
                        case "+":
                            resultado = primerNumero + segundoNumero;
                            break;
                        case "-":
                            resultado = primerNumero - segundoNumero;
                            break;
                        case "*":
                            resultado = primerNumero * segundoNumero;
                            break;
                        case "/":
                            resultado = primerNumero / segundoNumero;
                            break;
                    }
                    calc.getDisplay().setText(String.valueOf(resultado));
                    operador = "";
                    nuevaEntrada = true;
                }
                break;
            case "Change":
                calc.setVisible(false);
                calcScientific = new CalculadoraScientific();
                calcScientific.setVisible(true);
                break;


            default:
                if (nuevaEntrada) {
                    calc.getDisplay().setText(textoBoton);
                    nuevaEntrada = false;
                } else {
                    calc.getDisplay().setText(contenido + textoBoton);
                }
                break;
        }
    }
}
