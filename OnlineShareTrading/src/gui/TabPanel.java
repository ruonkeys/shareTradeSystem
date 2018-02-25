package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabPanel extends JPanel{
	ViewShares v;
	public TabPanel()
	{
		System.out.println("default running");
	}
	public TabPanel(String test)
	{
		v = new ViewShares();
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Add New Company", new AddNewCompany());
		jtp.addTab("View Shares", new JScrollPane(v));
		jtp.addTab("Add More Shares", new AddMoreShares());
		setLayout(new BorderLayout());
		add(jtp, BorderLayout.CENTER);
		
		jtp.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				JTabbedPane jtp=(JTabbedPane) e.getSource();
				int tabIndex = jtp.getSelectedIndex();
				if(tabIndex==1)
				{
					v.removeAll();
					v.revalidate();
					v.repaint();
					v.viewAllCompanies();
				}
				
			}
			
		});
	}
	
//	public void refreshTabPanel()
//	{
//		invalidate();
//		validate();
//		repaint();
//	}
}
