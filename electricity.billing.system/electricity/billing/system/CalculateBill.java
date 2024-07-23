package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener  {
	
	JTextField tfname  ,tfaddress , tfstate , tfunits , tfemail , tfphone;
	JButton next , cancel ;
	JLabel lblname ,labelAdress;
	Choice meterNumber , cmonth;
	
	CalculateBill(){
		setSize(700 , 500);
		setLocation(400 , 150);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173 , 216 , 230));
		add(p);
		
		JLabel heading = new JLabel("Calculate Electricity Bill");
		heading.setBounds(100 , 10 ,400 ,25 );
		heading.setFont(new Font("Tahoma",Font.PLAIN,24));
		p.add(heading);
		
		JLabel lblmeterNumber = new JLabel("Meter Number");
		lblmeterNumber.setBounds(100 , 80 ,100 ,20 );
		p.add(lblmeterNumber);
		
		meterNumber = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				meterNumber.add(rs.getString("meter_no"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		meterNumber.setBounds(240 , 80 ,200 ,20 );
		p.add(meterNumber);
		
		JLabel lblmeterno = new JLabel("Name");
		lblmeterno.setBounds(100 , 120 ,100 ,20 );
		p.add(lblmeterno);
		
		
		lblname = new JLabel("");
		lblname.setBounds(240 , 120 ,100 ,20 );
		p.add(lblname);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(100 , 160 ,100 ,20 );
		p.add(lbladdress);
		
		labelAdress = new JLabel("");
		labelAdress.setBounds(240 , 160 , 100 ,20 );
		p.add(labelAdress);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s	.executeQuery("select * from customer where meter_no = '"+meterNumber.getSelectedItem()+"'");
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				labelAdress.setText(rs.getString("address"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		meterNumber.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meterNumber.getSelectedItem()+"'");
					while(rs.next()) {
						lblname.setText(rs.getString("name"));
						labelAdress.setText(rs.getNString("address"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		JLabel lblcity = new JLabel("Units Consumed");
		lblcity.setBounds(100 , 200 ,100 ,20 );
		p.add(lblcity);
		
		tfunits = new JTextField();
		tfunits.setBounds(240 , 200 , 200 ,20 );
		p.add(tfunits);
		
		JLabel lblstste = new JLabel("Month");
		lblstste.setBounds(100 , 240 ,100 ,20 );
		p.add(lblstste);
		
		cmonth = new Choice();
		cmonth.setBounds(240 , 240 , 200 ,20 );
	    cmonth.add("January");
	    cmonth.add("February");
	    cmonth.add("March");
	    cmonth.add("April");
	    cmonth.add("May");
	    cmonth.add("June");
	    cmonth.add("July");
	    cmonth.add("August");
	    cmonth.add("September");
	    cmonth.add("Octomber");
	    cmonth.add("November");
	    cmonth.add("December");
	    p.add(cmonth);
		
		next = new JButton("Submit");
		next.setBounds(120, 350  ,100 , 25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(250, 350  ,100 , 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		
		add(p , "Center");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150 , 300 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image , "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae ) {
		if(ae.getSource() == next) {
			String meter = meterNumber.getSelectedItem();
			String units = tfunits.getText();
			String month =cmonth.getSelectedItem();

			int totalBill = 0;
			int unit_consumed = Integer.parseInt(units);
			
			String query = "select * from tax";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				
				while(rs.next()) {
					totalBill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
					totalBill += Integer.parseInt(rs.getString("meter_rent"));
					totalBill += Integer.parseInt(rs.getString("service_charge"));
					totalBill += Integer.parseInt(rs.getString("service_tax"));
					totalBill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
					totalBill += Integer.parseInt(rs.getString("fixed_tax"));
				}

				}catch(Exception e ) {
				e.printStackTrace();
			}
			String query2 = "insert into bill values('"+meter+"' , '"+month+"' , '"+units+"','"+totalBill+"' , 'Not Paid')";
			
			try {
				Conn c =new Conn();
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null ,"Customer Bill Update Successfully");
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main (String [] args ) {
		new CalculateBill();
	}
}
