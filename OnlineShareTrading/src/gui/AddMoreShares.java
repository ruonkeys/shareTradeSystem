package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMoreShares extends JPanel{
	private JLabel cmpnyCodeLabel;
	private JTextField cmpnyCodeField;
	private JLabel sharesLabel;
	private JTextField sharesField;
	private JLabel shareCostLabel;
	private JTextField shareCostField;
	private JLabel dateLabel;
	private JTextField dateField;
	private JButton addBtn;
	public AddMoreShares()
	{
		Font font1 = new Font("SansSerif", Font.PLAIN, 15);
		
	    cmpnyCodeLabel = new JLabel("Company Code(4-digit): ");
	    cmpnyCodeField = new JTextField(25);
	    cmpnyCodeField.setPreferredSize(new Dimension(200,40));
	    cmpnyCodeField.setFont(font1);
	    
	    sharesLabel = new JLabel("No. of Shares: ");
		sharesField = new JTextField(25);
		sharesField.setPreferredSize(new Dimension(200,40));// width, height
		sharesField.setFont(font1);
		
		shareCostLabel = new JLabel("Cost of one Share: ");
		shareCostField = new JTextField(25);
		shareCostField.setPreferredSize(new Dimension(200,40));// width, height
		shareCostField.setFont(font1);
		
		dateLabel = new JLabel("Date(dd/mm/yyyy): ");
		dateField = new JTextField(25);
		dateField.setPreferredSize(new Dimension(200,40));// width, height
		dateField.setFont(font1);
		
		addBtn = new JButton("Add");
		
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int cmpnyCode = 0;
				int shareTotal = 0;
				int shareCost = 0;
				String date = null;
				int status = 0;
				
				try
				{
					cmpnyCode = Integer.parseInt(cmpnyCodeField.getText());
					shareTotal = Integer.parseInt(sharesField.getText());
					shareCost = Integer.parseInt(shareCostField.getText());
					date = dateField.getText();
				}
				catch(Exception e3)
				{
					status = -1;
					e3.printStackTrace();
				}
				CompanyShares c = new CompanyShares(cmpnyCode,shareTotal,shareCost,date);
				DBConnect db = new DBConnect();
				int queryExecute = db.addMoreShares(c);
				
				if(queryExecute>0)
				{
					JOptionPane.showMessageDialog(AddMoreShares.this, "Successfully added",
							"Status", JOptionPane.INFORMATION_MESSAGE);
					
					cmpnyCodeField.setText("");
					sharesField.setText("");
					shareCostField.setText("");
					dateField.setText("");
				}
				else if(status == -1)
				{
					JOptionPane.showMessageDialog(AddMoreShares.this,
							"ERROR while adding...", "Status",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(AddMoreShares.this,
							"ERROR while adding...", "Status",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		addComponents();
	}
	
	public void addComponents()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=new Insets(0,0,45,5);
		add(cmpnyCodeLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.LAST_LINE_START;
		gc.insets=new Insets(0,0,20,0);
		add(cmpnyCodeField, gc);

////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(sharesLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);//top,left,bottom,right
		add(sharesField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(shareCostLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(shareCostField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);
		add(dateLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(dateField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(addBtn, gc);
	}
}
