package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class meterInfo extends JFrame implements ActionListener  {
	
	JTextField tfname  ,tfaddress , tfstate , tfcity , tfemail , tfphone;
	JButton next , cancel ;
	JLabel lblmeter;
	Choice meterLocation , meterType , phaseCode , billType;
	String meterNumber;
	
	meterInfo(String meterNumber){
		this.meterNumber = meterNumber;
		
		setSize(700 , 500);
		setLocation(400 , 200);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173 , 216 , 230));
		add(p);
		
		JLabel heading = new JLabel("Meter Information");
		heading.setBounds(180 , 10 ,200 ,20 );
		heading.setFont(new Font("Tahoma",Font.PLAIN,24));
		p.add(heading);
		
		JLabel lblname = new JLabel("Meter Number");
		lblname.setBounds(100 , 80 ,100 ,20 );
		p.add(lblname);
		
		JLabel lblMeterNumber = new JLabel(meterNumber);
		lblMeterNumber.setBounds(240 , 80 ,100 ,20 );
		p.add(lblMeterNumber);
		
		
		JLabel lblmeterno = new JLabel("Meter Location");
		lblmeterno.setBounds(100 , 120 ,100 ,20 );
		p.add(lblmeterno);
		 
		meterLocation = new Choice();
		meterLocation.add("Outside");
		meterLocation.add("Inside");
		meterLocation.setBounds(240 , 120 , 200 ,20 );
		p.add(meterLocation);
		
		JLabel lbladdress = new JLabel("Meter Type");
		lbladdress.setBounds(100 , 160 ,100 ,20 );
		p.add(lbladdress);
		
		meterType = new Choice();
		meterType.add("Electric Meter");
		meterType.add("Solar Meter");
		meterType.add("Smart Meter");
		meterType.setBounds(240 , 160 , 200 ,20 );
		p.add(meterType);
		
		JLabel lblcity = new JLabel("Phase Code");
		lblcity.setBounds(100 , 200 ,100 ,20 );
		p.add(lblcity);
		
		phaseCode = new Choice();
		phaseCode.add("011");
		phaseCode.add("022");
		phaseCode.add("033");
		phaseCode.add("044");
		phaseCode.add("055");
		phaseCode.add("066");
		phaseCode.add("077");
		phaseCode.add("088");
		phaseCode.add("099");

		phaseCode.setBounds(240 , 200 , 200 ,20 );
		p.add(phaseCode);
		
		JLabel lblstste = new JLabel("Bill Type");
		lblstste.setBounds(100 , 240 ,100 ,20 );
		p.add(lblstste);
		
		billType = new Choice();
		billType.add("Normal");
		billType.add("Industrial");
		billType.setBounds(240 , 240 , 200 ,20 );
		p.add(billType);
		
		
		JLabel lblemail = new JLabel("30 Days");
		lblemail.setBounds(240 , 280 ,100 ,20 );
		p.add(lblemail);
		
		JLabel lblphone = new JLabel("Note");
		lblphone.setBounds(100 , 320 ,100 ,20 );
		p.add(lblphone);
		
		JLabel lblphones = new JLabel("By Defoult Billis calculated for 30 days only ");
		lblphones.setBounds(240 , 360 ,500 ,20 );
		p.add(lblphones);
		
		next = new JButton("Submit");
		next.setBounds(220, 390  ,100 , 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		
		setLayout(new BorderLayout());
		
		add(p , "Center");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150 , 300 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image , "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae ) {
		if(ae.getSource() == next) {
			String meter = meterNumber;
			String location = meterLocation.getSelectedItem();
			String type = meterType.getSelectedItem();
			String code = phaseCode.getSelectedItem();
			String typeBill = billType.getSelectedItem();
			String days = "30";
			
			String query = "insert into meter_info values ('"+meter+"','"+location+"','"+type+"','"+code+"','"+typeBill+"','"+days+"')";
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
				setVisible(false);
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main (String [] args ) {
		new meterInfo("");
	}
}
