

package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;



public class Mainframe extends JFrame{
    static String pass_number = new String();
    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE MANAGEMENT SYSTEM");
      setForeground(Color.CYAN);
        setLayout(null); 

        JLabel NewLabel = new JLabel("");
NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/biman.jpg")));
//        System.out.println(ClassLoader.getSystemResource(""));
        NewLabel.setBounds(0, 0, 3000, 1400); // x , y, length, breath
	add(NewLabel); 
        
        JLabel AirlineManagementSystem = new JLabel("WELCOME TO KRATOS AIRLINES");
	AirlineManagementSystem.setForeground(Color.RED);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	AirlineManagementSystem.setBounds(500, 60, 1000, 55);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        
        
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT INFO");
	AirlineSystem.add(FlightDetails);


	JMenuItem PassengerDetails = new JMenuItem("JOURNEY DETAILS");
	AirlineSystem.add(PassengerDetails);
	
	JMenuItem ReservationDetails = new JMenuItem("ADD CUSTOMER DETAILS");
	AirlineSystem.add(ReservationDetails);
		

		

		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
	
	
	JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.GREEN);
	menuBar.add(Ticket);
        
        JMenuItem TicketGen = new JMenuItem("DOWNLOAD TICKET");
	Ticket.add(TicketGen);
        
        
        JMenu CreatedBy = new JMenu("CREATED BY: FAISAL SAIFI          ARYAN KASHYAP          SAYAN");
        CreatedBy.setForeground(Color.BLACK);
	menuBar.add(CreatedBy);
        

        


		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {  
                     conn c = new conn();
                     String str = "select pnr_no from passenger where pnr_no = (select max(pnr_no) from passenger)";
                     ResultSet rs = c.s.executeQuery(str);
                      while (rs.next()){
//                       int number = pnr_no+1;
                        pass_number = rs.getString("pnr_no");

//                        System.out.println(pass_number);
                        }


                  
                    
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
       	
        setSize(1950,1090);
	setVisible(true);
    }

    
}
