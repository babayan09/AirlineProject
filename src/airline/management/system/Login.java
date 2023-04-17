package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    TextField t1,t2;
    Label l1,l2;
    Button b3,b4,b5; // <-- add a new button for SignUp
    GridBagLayout gbl;  
    GridBagConstraints gbc; 
    Font f1,f2;
    public Login(){
        super("Login");
        
        
                
        //setBackground(Color.WHITE);
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
        t2 = new TextField(20); 
        t2.setEchoChar('*');
        
        

        b3 = new Button("Submit");
        b3.setFont(f2);
		
        b4 = new Button("Close");
	    b4.setFont(f2);
		
        b5 = new Button("SignUp"); // <-- add a new button for SignUp
        b5.setFont(f2); // <-- set font for SignUp button
        
        
		
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
        
	
        gbc.gridx=1;
        gbc.gridy=10;
        gbl.setConstraints(b5,gbc); // <-- add SignUp button to the UI
        add(b5);
	
        gbc.gridx=2;
        gbc.gridy=10;
        gbl.setConstraints(b4,gbc);
        add(b4);
        
        

        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this); // <-- listen to clicks on SignUp button
        
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
        if(ae.getSource()==b4){
            System.exit(0); 
        }
        if(ae.getSource()==b3){
            try{
                conn c1 = new conn();
                
                String s1 = t1.getText();
                String s2 = t2.getText();
            
                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet rs = c1.s.executeQuery(str);  
                
                if(rs.next()){
                    new Mainframe();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false); 
                }
            
            }catch(Exception e){
            }
	}
        if(ae.getSource() == b5){ // <-- if SignUp button is clicked
            new Signup(); // <-- open SignUp window
            setVisible(false); // <-- hide the current window (Login)
        }
    }     
    public static void main(String[] args){
            new Login();
    }
}