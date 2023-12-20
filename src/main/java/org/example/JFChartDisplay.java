package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.util.ArrayList;

public class JFChartDisplay extends JPanel implements HistoDisplay {
    @Override
    public void show(DataProvider provider) {
        ArrayList<Integer> edades = provider.getEdades();
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Edades", edades.stream().mapToDouble(Integer::doubleValue).toArray(), 5);

        JFreeChart histo = ChartFactory.createHistogram(
                "",
                "ages",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false,false,false
        );
        XYPlot plot = (XYPlot) histo.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setTickUnit(new NumberTickUnit(5));
        xAxis.setRange(20,30);
        yAxis.setTickUnit(new NumberTickUnit(1));
        yAxis.setRange(0,7);
        add(new ChartPanel(histo));
    }
}
