package com.knitting.datasource;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;


public class JFreeChartResidual {
	
	enum SeriesKey implements DataSeriesKey {RESIDUAL, OTHER};
	
	private JFrame frame;
	private JPanel contentPane;
	private JComponent chartComponent;

	public JFreeChartResidual() {
		frame = new JFrame("JFreeChart Residual Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel(new BorderLayout());
		frame.setContentPane(contentPane);
		
		JPanel header = buildHeader();
		contentPane.add(header, BorderLayout.NORTH);
	}

	private JPanel buildHeader() {
		JPanel header = new JPanel(new FlowLayout());

		JButton button = new JButton("Open");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dlg = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text and CSV files", "txt", "c");
				
				dlg.setFileFilter(filter);
				int returnVal = dlg.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = dlg.getSelectedFile();
					removeChart();
					try {
						DataSet ds = loadDataSet(file);
						loadChart(ds, file.getName());
					} catch (Exception e) {
						e.printStackTrace(System.err);
						chartComponent = new JLabel("Error loading chart: " + e.getMessage());
						contentPane.add(chartComponent, BorderLayout.CENTER);
					}
					frame.pack();
				}			
			}

		});
		
		header.add(button);

		return header;
	}

	private void show() {
		frame.pack();
		frame.setVisible(true);
	}

	private DataSet loadDataSet(File file) throws IOException, ParseException 
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
		DataSet ds = new DataSet();
		DataSeries series = ds.createDataSeries(SeriesKey.RESIDUAL);
		try {
			String line;
			int lineNo = 0;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) { // ignore blank lines
					String[] parts = line.split(",");
					if (parts.length < 3) {
						System.err.println("Ignoring line " + lineNo);
					} else {
						series.setValue(df.parse(parts[0]), Double.parseDouble(parts[2]));
					}
				}
				
				++lineNo;
			}
		}
		finally {
			reader.close();
		}
		return ds;
	}

	private void loadChart(DataSet ds, String label) {
		chartComponent = buildChart(ds, label);
		contentPane.add(chartComponent, BorderLayout.CENTER);
	}

	private JComponent buildChart(DataSet ds, String label) {
		XYDataset xyDataSet = buildDataSet(ds);
		JFreeChart chart = ChartFactory.createXYLineChart("title", "value", "time", xyDataSet, PlotOrientation.HORIZONTAL, false, false, false);
//		XYPlot plot = (XYPlot) chart.getPlot();
//		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//		rangeAxis.setAutoRangeIncludesZero(false);
		return new ChartPanel(chart);
	}

	private XYDataset buildDataSet(DataSet ds) {
		DefaultXYDataset xyDataSet = new DefaultXYDataset();
		Date firstDate = null;
		
		List<Double> values = ds.getSeries(SeriesKey.RESIDUAL).getValues(0);
		double [][] series = new double[2][values.size()];
		for (int index =0; index < values.size(); index++) {
			series[0][index] = values.get(index);
			series[1][index] = index;
		}
		
		xyDataSet.addSeries((Integer)1, series);
		
		return xyDataSet;
	}

	private void removeChart() {
		if (chartComponent != null) {
			int count = contentPane.getComponentCount();
			for (int index = 0; index < count; ++index) {
				Component component = contentPane.getComponent(index);
				if (component.equals(chartComponent)) {
					contentPane.remove(component);
					chartComponent = null;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		new JFreeChartResidual().show();
	}


}
