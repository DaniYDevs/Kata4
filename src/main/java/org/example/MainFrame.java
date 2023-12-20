package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private HistoDisplay histoDisplay;

    public MainFrame() throws HeadlessException {
        this.setTitle("Histograma de Edades");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistoDisplay());
    }

    private Component createHistoDisplay() {
        JFChartDisplay display = new JFChartDisplay();
        this.histoDisplay = display;
        return display;
    }

    public HistoDisplay histogramDisplay() {
        return histoDisplay;
    }
}
