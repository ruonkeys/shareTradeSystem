package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class EditFrame extends JFrame {
	private int cmpnyId;
	private EditPanel editPanel;
	public EditFrame(String title, int cmpnyId)
	{
		super(title);
		this.cmpnyId=cmpnyId;
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(600,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		editPanel = new EditPanel(cmpnyId);
		add(editPanel, BorderLayout.CENTER);
	}
}
