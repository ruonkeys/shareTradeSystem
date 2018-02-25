package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewShares extends JPanel{
	private ArrayList<Record> cmpnyList;
	private JButton editBtn;
	private JButton delBtn;
	public ViewShares()
	{
//		final DBConnect db = new DBConnect();
//		cmpnyList = (ArrayList<Record>) db.getCmpnyList();
//	
//		setLayout(new GridBagLayout());
//		GridBagConstraints gc = new GridBagConstraints();
//		
//		//////////////////titles////////////////
//		gc.weightx=0.05;
//		gc.weighty=1;
//		
//		gc.gridy=0;
//		gc.gridx=0;
//		gc.fill = GridBagConstraints.NONE;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Company Name"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Company Logo"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Company Code"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Company Link"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Address"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("No. of Shares"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Share Cost"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Company Description"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Phone No."), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Edit Details"), gc);
//		
//		gc.gridx++;
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
//		gc.insets = new Insets(0,0,0,0);
//		add(new JLabel("Delete Company"), gc);
//		
//		for(int i=0; i<cmpnyList.size(); i++)
//		{
//			final Record record = cmpnyList.get(i);
//			
//			gc.weightx=0.005;
//			gc.weighty=1;
//			
//			gc.gridy++;
//			
//			////col1////
//			gc.gridx=0;
//			
//			gc.fill=GridBagConstraints.NONE;
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(record.getCmpnyName()), gc);
//			
//		    /////next col////
//			File icon = new File("images/"+record.getCmpnyLogoPath()+"");
//			BufferedImage img = null;
//			try
//			{
//				img = ImageIO.read(icon);
//			}
//			catch(Exception e5)
//			{
//				e5.printStackTrace();
//			}
//			
//            gc.gridx++;
//			
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(new ImageIcon(img)), gc);
//			
//			/////col2////
//			gc.gridx++;
//			
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(Integer.toString(record.getCmpnyCode())), gc);
//			
//		    /////next col////
//			gc.gridx++;
//			
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(record.getCmpnyLink()), gc);
//			
//			////next col////
//            gc.gridx++;
//			
//			gc.fill=GridBagConstraints.NONE;
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(record.getAddress()), gc);
//			
//			////col3///
//			gc.gridx++;
//			
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(Integer.toString(record.getShareTotal())), gc);
//			
//			////col4///
//			gc.gridx++;
//			
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(Integer.toString(record.getShareCost())), gc);
//			
//		////next col////
//            gc.gridx++;
//			
//			gc.fill=GridBagConstraints.NONE;
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(record.getCmpnyDescription()), gc);
//			
//		////next col////
//            gc.gridx++;
//			
//			gc.fill=GridBagConstraints.NONE;
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(new JLabel(record.getPhone()), gc);
//			
//			////col5////
//			gc.gridx++;
//			
//			editBtn = new JButton("Edit");
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(editBtn, gc);
//			
//			////col6////
//			gc.gridx++;
//			
//			delBtn = new JButton("Delete");
//			gc.anchor=GridBagConstraints.FIRST_LINE_START;
//			gc.insets = new Insets(0,0,0,0);
//			add(delBtn, gc);
//			
//			delBtn.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e) {
//					boolean del=db.deleteCmpny(record.getCmpnyCode());//wanting modifier as final
//					if(del)
//					{
//						JOptionPane.showMessageDialog(ViewShares.this, 
//								"Successfully deleted...", "Status", JOptionPane.INFORMATION_MESSAGE);
////						MainFrame mf = new MainFrame();
////						mf.refreshMainFrame();
//						
//						TabPanel tb=new TabPanel();
//						tb.refreshTabPanel();
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(ViewShares.this, 
//								"ERROR while deleting...", "Status", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			});
//			
//			editBtn.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e) {
//					new EditFrame("Edit Company Data", record.getCmpnyId());
//				}
//			});
//		}
		
		
	}
	
	public void viewAllCompanies()
	{
		System.out.println("click working");
		
		
		final DBConnect db = new DBConnect();
		cmpnyList = (ArrayList<Record>) db.getCmpnyList();
	
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//////////////////titles////////////////
		gc.weightx=0.05;
		gc.weighty=1;
		
		gc.gridy=0;
		gc.gridx=0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Company Name"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Company Logo"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Company Code"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Company Link"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Address"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("No. of Shares"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Share Cost"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Company Description"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Phone No."), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Edit Details"), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(new JLabel("Delete Company"), gc);
		
		for(int i=0; i<cmpnyList.size(); i++)
		{
			final Record record = cmpnyList.get(i);
			
			gc.weightx=0.005;
			gc.weighty=1;
			
			gc.gridy++;
			
			////col1////
			gc.gridx=0;
			
			gc.fill=GridBagConstraints.NONE;
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(record.getCmpnyName()), gc);
			
		    /////next col////
			File icon = new File("images/"+record.getCmpnyLogoPath()+"");
			BufferedImage img = null;
			try
			{
				img = ImageIO.read(icon);
			}
			catch(Exception e5)
			{
				e5.printStackTrace();
			}
			
            gc.gridx++;
			
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(new ImageIcon(img)), gc);
			
			/////col2////
			gc.gridx++;
			
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(Integer.toString(record.getCmpnyCode())), gc);
			
		    /////next col////
			gc.gridx++;
			
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(record.getCmpnyLink()), gc);
			
			////next col////
            gc.gridx++;
			
			gc.fill=GridBagConstraints.NONE;
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(record.getAddress()), gc);
			
			////col3///
			gc.gridx++;
			
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(Integer.toString(record.getShareTotal())), gc);
			
			////col4///
			gc.gridx++;
			
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(Integer.toString(record.getShareCost())), gc);
			
		////next col////
            gc.gridx++;
			
			gc.fill=GridBagConstraints.NONE;
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(record.getCmpnyDescription()), gc);
			
		////next col////
            gc.gridx++;
			
			gc.fill=GridBagConstraints.NONE;
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(new JLabel(record.getPhone()), gc);
			
			////col5////
			gc.gridx++;
			
			editBtn = new JButton("Edit");
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(editBtn, gc);
			
			////col6////
			gc.gridx++;
			
			delBtn = new JButton("Delete");
			gc.anchor=GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0,0,0,0);
			add(delBtn, gc);
			
			delBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					boolean del=db.deleteCmpny(record.getCmpnyCode());//wanting modifier as final
					if(del)
					{
						JOptionPane.showMessageDialog(ViewShares.this, 
								"Successfully deleted...", "Status", JOptionPane.INFORMATION_MESSAGE);
//						MainFrame mf = new MainFrame();
//						mf.refreshMainFrame();
						
//						TabPanel tb=new TabPanel();
//						tb.refreshTabPanel();
						removeAll();
						revalidate();
						repaint();
						viewAllCompanies();
					}
					else
					{
						JOptionPane.showMessageDialog(ViewShares.this, 
								"ERROR while deleting...", "Status", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			editBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new EditFrame("Edit Company Data", record.getCmpnyId());
				}
			});
		}
	
	}

}
