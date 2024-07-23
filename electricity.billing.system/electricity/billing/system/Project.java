package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
	String atype;
	String meter;
	Project(String atype , String meter){
		this.atype = atype;
		this.meter = meter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu master = new JMenu("Master");
		master.setForeground(Color.BLUE);
		
		JMenuItem newcustomer = new JMenuItem("New Customer");
		newcustomer.setFont(new Font("monospace",Font.PLAIN,12));
		newcustomer.setBackground(Color.WHITE);
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newcustomer.setIcon(new ImageIcon(image1));
		newcustomer.setMnemonic('D');
		newcustomer.addActionListener(this);
		newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		master.add(newcustomer);
		
		JMenuItem customerdetails = new JMenuItem("Customer Details");
		customerdetails.setFont(new Font("monospace",Font.PLAIN,12));
		customerdetails.setBackground(Color.WHITE);
		ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		customerdetails.setIcon(new ImageIcon(image2));
		customerdetails.setMnemonic('M');
		customerdetails.addActionListener(this);
		customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		master.add(customerdetails);

		JMenuItem depositedetails = new JMenuItem("Deposite Details");
		depositedetails.setFont(new Font("monospace",Font.PLAIN,12));
		depositedetails.setBackground(Color.WHITE);
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
		Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		depositedetails.setIcon(new ImageIcon(image3));
		depositedetails.setMnemonic('N');
		depositedetails.addActionListener(this);
		depositedetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		master.add(depositedetails);
		
		JMenuItem calculatebill = new JMenuItem("Calculate Bill");
		calculatebill.setFont(new Font("monospace",Font.PLAIN,12));
		calculatebill.setBackground(Color.WHITE);
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculatebill.setIcon(new ImageIcon(image4));
		calculatebill.setMnemonic('B');
		calculatebill.addActionListener(this);
		calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		
		master.add(calculatebill);
		
		JMenu info = new JMenu("Information");
		info.setForeground(Color.RED);
		
		JMenuItem updateinfo = new JMenuItem("Update Information");
		updateinfo.setFont(new Font("monospace",Font.PLAIN,12));
		updateinfo.setBackground(Color.WHITE);
		ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
		Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		updateinfo.setIcon(new ImageIcon(image5));
		updateinfo.setMnemonic('P');
		updateinfo.addActionListener(this);
		updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		
		info.add(updateinfo);
		
		JMenuItem viewInfo = new JMenuItem("View Information");
		viewInfo.setFont(new Font("monospace",Font.PLAIN,12));
		viewInfo.setBackground(Color.WHITE);
		ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewInfo.setIcon(new ImageIcon(image6));
		viewInfo.setMnemonic('L');
		viewInfo.addActionListener(this);
		viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		
		info.add(viewInfo);
		
		JMenu user = new JMenu("User");
		user.setForeground(Color.BLUE);
		
		JMenuItem payBill = new JMenuItem("Pay Bill");
		payBill.setFont(new Font("monospace",Font.PLAIN,12));
		payBill.setBackground(Color.WHITE);
		ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		payBill.setIcon(new ImageIcon(image5));
		payBill.setMnemonic('R');
		payBill.addActionListener(this);
		payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		
		user.add(payBill);
		
		JMenuItem billDetails = new JMenuItem("Bill Details");
		billDetails.setFont(new Font("monospace",Font.PLAIN,12));
		billDetails.setBackground(Color.WHITE);
		ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
		Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		billDetails.setIcon(new ImageIcon(image8));
		billDetails.setMnemonic('D');
		billDetails.addActionListener(this);
		billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		user.add(billDetails);
		
		JMenu report = new JMenu("Report");
		report.setForeground(Color.RED);
		
		JMenuItem generateBill = new JMenuItem("Generate Bill");
		generateBill.setFont(new Font("monospace",Font.PLAIN,12));
		generateBill.setBackground(Color.WHITE);
		ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		generateBill.setIcon(new ImageIcon(image9));
		generateBill.setMnemonic('G');
		generateBill.addActionListener(this);
		generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		
		report.add(generateBill);
		
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.BLUE);
		
		JMenuItem notePad = new JMenuItem("Note Pad");
		notePad.setFont(new Font("monospace",Font.PLAIN,12));
		notePad.setBackground(Color.WHITE);
		ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
		Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		notePad.setIcon(new ImageIcon(image10));
		notePad.setMnemonic('N');
		notePad.addActionListener(this);
		notePad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		utility.add(notePad);
		
		JMenuItem calculator = new JMenuItem("Calculator");
		calculator.setFont(new Font("monospace",Font.PLAIN,12));
		calculator.setBackground(Color.WHITE);
		ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
		Image image11 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculator.setIcon(new ImageIcon(image11));
		calculator.setMnemonic('C');
		calculator.addActionListener(this);
		calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		utility.add(calculator);
		
		JMenu mexit = new JMenu("Exit");
		mexit.setForeground(Color.RED);
		
		if(atype.equals("Admin")) {
			mb.add(master);
		}else {
			mb.add(info);
			mb.add(user);
			mb.add(report);
		}
		mb.add(utility);
		mb.add(mexit);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setFont(new Font("monospace",Font.PLAIN,12));
		exit.setBackground(Color.WHITE);
		ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
		Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(image12));
		exit.setMnemonic('W');
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		
		mexit.add(exit);

		setLayout(new FlowLayout());
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		if(msg.equals("New Customer")) {
			new NewCustomer();
		}else if(msg.equals("Customer Details")) {
			new CustomerDetails();
		}else if (msg.equals("Deposite Details")) {
			new DepositeDetails();
		}else if ( msg.equals("Calculate Bill")) {
			new CalculateBill();
		}else if(msg.equals("View Information")) {
			new ViewInformation(meter);
		}else if(msg.equals("Update Information")) {
			new UpdateInformation(meter);
		}else if(msg.equals("Bill Details")) {
			new BillDetails(meter);
		}else if(msg.equals("Note Pad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(msg.equals("Exit")) {
			setVisible(false);
			new Login();
		}else if (msg.equals("Pay Bill")) {
			new PayBill(meter);
		}else if(msg.equals("Generate Bill")){
			new GenerateBill(meter);
		}
	}
	public static void main(String[] args) {
		new Project("" , "");
	}
} 
