package dev.alejandrosahonero.logic;

import dev.alejandrosahonero.gui.Calculadora;
import dev.alejandrosahonero.gui.CalculadoraScientific;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorScientificController implements ActionListener {
    private Calculadora calc;
    private CalculadoraScientific calcScientific;
    private String operador = "";
    private double primerNumero = 0;
    private boolean nuevaEntrada = false;

    public CalculatorScientificController(CalculadoraScientific calcScientific) {
        this.calcScientific = calcScientific;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getText();
        String contenido = calcScientific.getDisplay().getText();

        switch (textoBoton) {
            case "AC":
                calcScientific.getDisplay().setText("");
                operador = "";
                primerNumero = 0;
                nuevaEntrada = false;
                break;

            case "C":
                if (!contenido.isEmpty()) {
                    contenido = contenido.substring(0, contenido.length() - 1);
                    calcScientific.getDisplay().setText(contenido);
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
                    calcScientific.getDisplay().setText(resSquare + "");
                    nuevaEntrada = true;
                }
                break;
            case "3√":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "3√";
                    double resSquare = Math.pow(primerNumero, 1.0/3.0);
                    calcScientific.getDisplay().setText(resSquare + "");
                    nuevaEntrada = true;
                }
                break;
            case "sen":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "sen";
                    double res = Math.sin(Math.toRadians(primerNumero));
                    calcScientific.getDisplay().setText(res + "");
                    nuevaEntrada = true;
                }
                break;
            case "cos":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "cos";
                    double res = Math.cos(Math.toRadians(primerNumero));
                    calcScientific.getDisplay().setText(res + "");
                    nuevaEntrada = true;
                }
                break;
            case "tan":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "tan";
                    double res = Math.tan(Math.toRadians(primerNumero));
                    calcScientific.getDisplay().setText(res + "");
                    nuevaEntrada = true;
                }
                break;
            case "atan":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido);
                    operador = "atan";
                    double res = Math.atan(primerNumero);
                    calcScientific.getDisplay().setText(Math.toDegrees(res) + "");
                    nuevaEntrada = true;
                }
                break;
            case "π":
                if (!contenido.isEmpty()) {
                    primerNumero = Double.parseDouble(contenido+Math.PI);
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
                    calcScientific.getDisplay().setText(String.valueOf(resultado));
                    operador = "";
                    nuevaEntrada = true;
                }
                break;
            default:
                if (nuevaEntrada) {
                    calcScientific.getDisplay().setText(textoBoton);
                    nuevaEntrada = false;
                } else {
                    calcScientific.getDisplay().setText(contenido + textoBoton);
                }
                break;
        }
    }
}
