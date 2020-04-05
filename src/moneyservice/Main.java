package moneyservice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	private JFrame window;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JTextField fromTextField;
	private JTextField toTextField;
	private JComboBox<String> fromComboBox;
	private JComboBox<String> toComboBox;
	private JButton convertButton;
	
	private Converter converter;
	private String from;
	private String to;
	
	public Main() {
		converter = new Converter();
		
		window = new JFrame("MoneyService - South Group V1.0");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		JPanel panel2 = new JPanel(new FlowLayout());
		fromLabel = new JLabel("From: ");
		fromTextField = new JTextField(5);
		fromComboBox = new JComboBox<String>(createCurrencyNamesVector());
		fromComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> combo = (JComboBox<?>) e.getSource();
				String selected = (String) combo.getSelectedItem();
				
				for (Currency currency : Currency.values()) {
					if(currency.getCurrencyCodeFullName().equals(selected)){
						from = currency.getCurrencyCode();
					}
				}
				
			}
		});
		
		panel2.add(fromLabel);
		panel2.add(fromTextField);
		panel2.add(fromComboBox);
		
		JPanel panel3 = new JPanel(new FlowLayout());
		toLabel = new JLabel("   To:   ");
		toTextField = new JTextField(5);
		toTextField.setEditable(false);
		toComboBox = new JComboBox<String>(createCurrencyNamesVector());
		toComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> combo = (JComboBox<?>) e.getSource();
				String selected = (String) combo.getSelectedItem();
				
				for (Currency currency : Currency.values()) {
					if(currency.getCurrencyCodeFullName().equals(selected)){
						to = currency.getCurrencyCode();
					}
				}
				
			}
		});
		
		panel3.add(toLabel);
		panel3.add(toTextField);
		panel3.add(toComboBox);
		
		panel.add(panel2);
		panel.add(panel3);
		
		convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double value = Double.valueOf(fromTextField.getText());
				double result = converter.getConvertedValue(value,from,to);
				toTextField.setText(String.valueOf(result));
			}
		});
		
		window.getContentPane().add(panel);
		window.getContentPane().add(convertButton, BorderLayout.SOUTH);
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	private Vector<String> createCurrencyNamesVector(){
		Vector<String> names = new Vector<String>();
		names.add(" ");
		for (Currency currency : Currency.values()) {
			names.add(currency.getCurrencyCodeFullName());
		}
		
		return names;
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
