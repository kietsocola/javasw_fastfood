package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class chart extends JFrame {

    public chart(String title) {
        super(title);

        // Create a dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(15, "Series 1", "Category 2");
        dataset.addValue(20, "Series 1", "Category 3");
        dataset.addValue(25, "Series 2", "Category 1");
        dataset.addValue(30, "Series 2", "Category 2");
        dataset.addValue(35, "Series 2", "Category 3");

        // Create a chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart Example",      // chart title
                "Category",               // domain axis label
                "Value",                  // range axis label
                dataset);                // data

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	chart example = new chart("Bar Chart Example");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
