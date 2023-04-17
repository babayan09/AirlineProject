package airline.management.system;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JPasswordField;

public class Signup extends JFrame implements ActionListener{
    TextField t1;
    JPasswordField t2;
    Label l1,l2;
    Button b3,b4;
    GridBagLayout gbl;  
    GridBagConstraints gbc; 
    Font f1,f2;
    
    public Signup(){
        super("Signup");
        
        getContentPane().setBackground(Color.RED); 
        f1 = new Font("TimesRoman",Font.BOLD,25);
        f2 = new Font("TimesRoman",Font.BOLD,20);
        
        gbl=new GridBagLayout(); 
        gbc=new GridBagConstraints();
        setLayout(gbl); 
	
        l1 = new Label("Username");
        l1.setFont(f1);
	
        l2 = new Label("Password");
        l2.setFont(f1);

	
        t1 = new TextField(20); 
		
        t2 = new JPasswordField(20); 
        t2.setEchoChar('*');
	
		
        b3 = new Button("Submit");
        b3.setFont(f2);
		
        b4 = new Button("Close");
        b4.setFont(f2);
        
        gbc.gridx=0;
        gbc.gridy=0; 
        gbl.setConstraints(l1,gbc);
        add(l1);
        
        gbc.gridx=2;
        gbc.gridy=0;
        gbl.setConstraints(t1,gbc);
        add(t1);
		
        gbc.gridx=0;
        gbc.gridy=2;
        gbl.setConstraints(l2,gbc);
        add(l2);

        gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(t2,gbc);
        add(t2);
				

        gbc.gridx=0;
        gbc.gridy=10;
        gbl.setConstraints(b3,gbc);
        add(b3);
	
        gbc.gridx=2;
        gbc.gridy=10;
        gbl.setConstraints(b4,gbc);
        add(b4);
        

        b3.addActionListener(this);
        b4.addActionListener(this);
                
        setVisible(true);   
        setSize(1000,800); 
        setLocation(400,200);
        
        Label welcomeLabel = new Label("Welcome to Kratos Airline");
        welcomeLabel.setFont(f1);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(-250, 0, 40, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbl.setConstraints(welcomeLabel, gbc);
        add(welcomeLabel);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b3){
            String username = t1.getText();
            String password = new String(t2.getPassword());
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql:///airline","root","11906504");
                Statement st=con.createStatement();
                String str = "INSERT INTO login values('"+username+"','"+password+"')";
                        
                st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Registered successfully!"); //pop up
                setVisible(false);
                con.close();
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }
   
    public static void main(String[] args){
        new Signup();
    }    
}
