package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	private TabPanel tabPanel;
	public MainFrame()
	{
		
	}
	public MainFrame(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabPanel = new TabPanel("test");
		add(tabPanel, BorderLayout.CENTER);
	}
//	public void refreshMainFrame()
//	{
//		SwingUtilities.updateComponentTreeUI(new MainFrame("Admin Panel"));
//		invalidate();
//		validate();
//		repaint();
//	}
	
	public static void main(String args[])
	{
		new MainFrame("Admin Panel");
//		SwingUtilities.invokeLater(new Runnable(){
//			public void run()
//			{
//				new MainFrame("Admin Panel");
//			}
//		});
	}

}
