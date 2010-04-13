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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataset;

public class JFreeChartDemo {
	
	private JFrame frame;
	private JPanel contentPane;
	private JComponent chartComponent;

	public JFreeChartDemo() {
		frame = new JFrame("JFreeChart OHLC Demo");
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
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		DataSet ds = new DataSet();
		OHLCAdapter adapter = new OHLCAdapter(ds);
		try {
			String line;
			int lineNo = 0;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) { // ignore blank lines
					String[] parts = line.split(",");
					if (parts.length != 6) {
						throw new RuntimeException("Invalid line " + lineNo + "; expecting 6 tokens, got " + parts.length);
					}
					
					adapter.addBar(df.parse(parts[0]),
							       Double.parseDouble(parts[1]),
							       Double.parseDouble(parts[2]),
							       Double.parseDouble(parts[3]),
							       Double.parseDouble(parts[4]),
							       Long.parseLong(parts[5]));
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
		OHLCDataset jfDataSet = buildOHLCDataSet(ds);
		JFreeChart chart = ChartFactory.createHighLowChart(label, "Time", "Price", jfDataSet, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setAutoRangeIncludesZero(false);
		return new ChartPanel(chart);
	}

	private OHLCDataset buildOHLCDataSet(DataSet ds) {
		int domainSize = ds.domainSize();
		Date[] dates = new Date[domainSize];
		double[] high = new double[domainSize];
		double[] low = new double[domainSize];
		double[] open = new double[domainSize];
		double[] close = new double[domainSize];
		double[] volume = new double[domainSize];
		
		copySeriesData(ds.getSeries(OHLCSeriesKey.OPEN), open);
		copySeriesData(ds.getSeries(OHLCSeriesKey.HIGH), high);
		copySeriesData(ds.getSeries(OHLCSeriesKey.LOW), low);
		copySeriesData(ds.getSeries(OHLCSeriesKey.CLOSE), close);
		copySeriesData(ds.getSeries(OHLCSeriesKey.VOLUME), volume);
		
		int index = 0;
		for (Date date : ds.getDomainDates()) {
			dates[index++] = date;
		}
		
		return new DefaultHighLowDataset("series", dates, high, low, open, close, volume);
	}

	private void copySeriesData(DataSeries series, double[] ary) {
		int index = 0;
		for (Double D : series.getValues(0)) {
			if (D != null) {
				ary[index] = D;
			}
			++index;
		}
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
		new JFreeChartDemo().show();
	}


}
