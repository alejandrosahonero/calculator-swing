package dev.alejandrosahonero.app;

import dev.alejandrosahonero.gui.Calculadora;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora().setVisible(true));
    }
}