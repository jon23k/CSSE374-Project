import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Java to Txt Converter!");
		
		JPanel topPanel = new JPanel();
		JTextField txtField = new JTextField("Put textfile name here");
		txtField.setPreferredSize(new Dimension(200,25));
		topPanel.add(txtField);
		JTextField txtField2 = new JTextField("Put datapath here");
		txtField2.setPreferredSize(new Dimension(200,25));
		topPanel.add(txtField2);

		JButton button = new JButton("Convert!");
		topPanel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JavaToText converter = new JavaToText(txtField.getText(), txtField2.getText());
				converter.run();
			}
		});
		frame.add(topPanel, BorderLayout.NORTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//JavaToText converter = new JavaToText();
	}

}
