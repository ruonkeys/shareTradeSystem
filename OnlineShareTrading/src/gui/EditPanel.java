package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class EditPanel extends JPanel {
	private JLabel cmpnyNameLabel;
	private JTextField cmpnyNameField;
	private JLabel cmpnyLogoLabel;
	private JTextField cmpnyLogoField;
	private JLabel cmpnyCodeLabel;
	private JTextField cmpnyCodeField;
	private JLabel cmpnyLinkLabel;
	private JTextField cmpnyLinkField;
	private JLabel addressLabel;
	private JTextArea addressField;
//	private JLabel sharesLabel;
//	private JTextField sharesField;
//	private JLabel shareCostLabel;
//	private JTextField shareCostField;
//	private JLabel dateLabel;
//	private JTextField dateField;
	private JLabel cmpnyDescLabel;
	private JTextArea cmpnyDescField;
	private JLabel phLabel;
	private JTextField phField;
	private JButton updateBtn;
	private int cmpnyId;
	private JFileChooser fileChooser;
	private JButton browseLogoBtn;
	private File icon;
	private String iconPath;
	private boolean browseBtnPressed;
	
	public EditPanel(final int cmpnyId)
	{
		this.cmpnyId=cmpnyId;
		
		cmpnyNameLabel = new JLabel("Company Name: ");
		cmpnyNameField = new JTextField(25);
		cmpnyNameField.setPreferredSize(new Dimension(200,40));
		Font font1 = new Font("SansSerif", Font.PLAIN, 15);
		cmpnyNameField.setFont(font1);
		
		cmpnyLogoLabel = new JLabel("Company Logo: ");
		cmpnyLogoField = new JTextField(25);
		cmpnyLogoField.setPreferredSize(new Dimension(200,40));
		cmpnyLogoField.setFont(font1);
		
		browseLogoBtn = new JButton("Browse");
		
		fileChooser = new JFileChooser();
		
	    cmpnyCodeLabel = new JLabel("Company Code(4-digit): ");
	    cmpnyCodeField = new JTextField(25);
	    cmpnyCodeField.setPreferredSize(new Dimension(200,40));
	    cmpnyCodeField.setFont(font1);
	    
	    cmpnyLinkLabel = new JLabel("Company Link: ");
	    cmpnyLinkField = new JTextField(25);
	    cmpnyLinkField.setPreferredSize(new Dimension(200,40));
	    cmpnyLinkField.setFont(font1);
		
		addressLabel = new JLabel("Address: ");
		addressField = new JTextArea();
		addressField.setPreferredSize(new Dimension(330,100));
		addressField.setFont(font1);
		Border border=BorderFactory.createEtchedBorder();
		addressField.setBorder(border);
		
//		sharesLabel = new JLabel("No. of Shares: ");
//		sharesField = new JTextField(25);
//		sharesField.setPreferredSize(new Dimension(200,40));// width, height
//		sharesField.setFont(font1);
		
//		shareCostLabel = new JLabel("Cost of one Share: ");
//		shareCostField = new JTextField(25);
//		shareCostField.setPreferredSize(new Dimension(200,40));// width, height
//		shareCostField.setFont(font1);
		
//		dateLabel = new JLabel("Date(dd/mm/yyyy): ");
//		dateField = new JTextField(25);
//		dateField.setPreferredSize(new Dimension(200,40));// width, height
//		dateField.setFont(font1);
		
		cmpnyDescLabel = new JLabel("Company Description: ");
		cmpnyDescField = new JTextArea();
		cmpnyDescField.setPreferredSize(new Dimension(330,150));
		cmpnyDescField.setFont(font1);
		cmpnyDescField.setBorder(BorderFactory.createEtchedBorder());
		
		
		phLabel = new JLabel("Phone No.: ");
		phField = new JTextField(25);
		phField.setPreferredSize(new Dimension(200,40));
		phField.setFont(font1);
		
		updateBtn = new JButton("Update");
		
		final DBConnect db = new DBConnect();
		ResultSet rs=db.getDetails(cmpnyId);
		try
		{
			rs.next();
			cmpnyNameField.setText(rs.getString("cmpnyname"));
			cmpnyLogoField.setText(rs.getString("cmpnylogopath"));
			cmpnyCodeField.setText(Integer.toString(rs.getInt("cmpnycode")));
			cmpnyLinkField.setText(rs.getString("cmpnylink"));
			addressField.setText(rs.getString("address"));
//			sharesField.setText(Integer.toString(rs.getInt("sharetotal")));
//			shareCostField.setText(Integer.toString(rs.getInt("sharecost")));
			cmpnyDescField.setText(rs.getString("cmpnydescription"));
			phField.setText(rs.getString("phone"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		updateBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String cmpnyName = null;
				String cmpnyLogoPath = null;
				int cmpnyCode = 0;
				String cmpnyLink = null;
				String address = null;
				int shareTotal = 0;
				int shareCost = 0;
				String date = null;
				String cmpnyDescription = null;
				String phone = null;
				int status = 0;	
				try
				{
			     cmpnyName=cmpnyNameField.getText();
			     cmpnyLogoPath=cmpnyLogoField.getText();
			     cmpnyCode=Integer.parseInt(cmpnyCodeField.getText());
			     cmpnyLink=cmpnyLinkField.getText();
				 address=addressField.getText();
//				 shareTotal=Integer.parseInt(sharesField.getText());
//				 shareCost=Integer.parseInt(shareCostField.getText());
//				 date=dateField.getText();
				 cmpnyDescription=cmpnyDescField.getText();
				 phone=phField.getText();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					//System.out.println("reached new excep");
					status = -1;
				}
				GeneralDetails g = new GeneralDetails(cmpnyName,cmpnyLogoPath,cmpnyCode,cmpnyLink,address,cmpnyDescription,phone);
				int queryExecute = db.updateDetails(g, cmpnyId);// wanting modifier as final
				
		///////////image read write////////////
				if(browseBtnPressed)
				{
					imgUploadChange();
				}
				
		        ///////////image read write////////////
				
				if(queryExecute>0)
				{
					JOptionPane.showMessageDialog(EditPanel.this,
							"Successfully updated", "Status",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else if(status == -1)
				{
					//System.out.println("reached else");
					JOptionPane.showMessageDialog(EditPanel.this,
							"ERROR while updating...", "Status",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(EditPanel.this,
							"ERROR while updating...", "Status",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		browseLogoBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(EditPanel.this)==JFileChooser.APPROVE_OPTION)
				{
					browseBtnPressed=true;
					icon = fileChooser.getSelectedFile();
					String iconDest = icon.toString();
					int index = iconDest.lastIndexOf("\\");
					iconPath = iconDest.substring(index+1, iconDest.length());
					cmpnyLogoField.setText(iconPath);
				}
			}
		});
		
		setComponents();
	}
	
	public void imgUploadChange()
	{
		try
		{
		FileInputStream fi = new FileInputStream(icon);
		FileOutputStream fo = new FileOutputStream("images/"+iconPath+"");
		int i;
		  while((i=fi.read())!=-1)
		 {
			  fo.write(i);
	     }
		  
		  fi.close();
		  fo.close();
	 	}
		catch(Exception e7)
		{
			JOptionPane.showMessageDialog(EditPanel.this,
					"ERROR in image uploading...", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e7.printStackTrace();
		}
	}
	
	public void setComponents()
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
		add(cmpnyNameLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.LAST_LINE_START;
		gc.insets=new Insets(0,0,20,0);
		add(cmpnyNameField, gc);
		
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(cmpnyLogoLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(cmpnyLogoField, gc);
		
		gc.gridx=2;
		gc.weightx=0.02;
//		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(6,-430,0,200);
		add(browseLogoBtn, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(cmpnyCodeLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(cmpnyCodeField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(cmpnyLinkLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(cmpnyLinkField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);//top,left,bottom,right
		add(addressLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(addressField, gc);
////////////next row ///////////////////////////////////
//		gc.weightx=1;
//		gc.weighty=0.3;
//		
//		gc.gridy++;
//		
//		gc.gridx=0;
//		gc.fill=GridBagConstraints.NONE;
//		gc.anchor=GridBagConstraints.FIRST_LINE_END;
//		gc.insets=new Insets(0,0,0,5);
//		add(sharesLabel, gc);
//		
//		gc.gridx=1;
//		gc.anchor=GridBagConstraints.FIRST_LINE_START;
//		gc.insets=new Insets(0,0,0,0);
//		add(sharesField, gc);
////////////next row ///////////////////////////////////
//		gc.weightx=1;
//		gc.weighty=0.3;
//		
//		gc.gridy++;
//		
//		gc.gridx=0;
//		gc.fill=GridBagConstraints.NONE;
//		gc.anchor=GridBagConstraints.FIRST_LINE_END;
//		gc.insets=new Insets(0,0,0,5);
//		add(shareCostLabel, gc);
//		
//		gc.gridx=1;
//		gc.anchor=GridBagConstraints.FIRST_LINE_START;
//		gc.insets=new Insets(0,0,0,0);
//		add(shareCostField, gc);
////////////next row ///////////////////////////////////
//		gc.weightx=1;
//		gc.weighty=0.3;
//		
//		gc.gridy++;
//		
//		gc.gridx=0;
//		gc.fill=GridBagConstraints.NONE;
//		gc.anchor=GridBagConstraints.FIRST_LINE_END;
//		gc.insets=new Insets(0,0,0,5);
//		add(dateLabel, gc);
//		
//		gc.gridx=1;
//		gc.anchor=GridBagConstraints.FIRST_LINE_START;
//		gc.insets=new Insets(0,0,0,0);
//		add(dateField, gc);
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);
		add(cmpnyDescLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(cmpnyDescField, gc);
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=0.3;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,5);
		add(phLabel, gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(phField, gc);
		
////////////next row ///////////////////////////////////
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(updateBtn, gc);
	}

}
