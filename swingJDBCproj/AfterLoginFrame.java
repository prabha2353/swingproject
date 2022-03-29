package swingJDBCproj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AfterLoginFrame  extends JFrame implements ActionListener
{
	JMenuItem addmenuitemobj;
	JMenuItem delmenuitemobj;
	public AfterLoginFrame()
	{
		super("AFTER LOGIN FRAME");
		setLayout(null);
		
		// 1. CREATE MENUBAR
		JMenuBar mbrobj = new JMenuBar();
		
		// 2. CREATE MENU
		JMenu ummenuobj = new JMenu("MANAGE USER");
		
		//3. CREATE MENU ITEM
		addmenuitemobj = new JMenuItem("ADD USER");
		addmenuitemobj.addActionListener(this);
		
		delmenuitemobj = new JMenuItem("DELETE USER");
		delmenuitemobj.addActionListener(this);
		
		JMenuItem updatemenuitemobj = new JMenuItem("UPDATE USER");
				
		//4. ADD MENU ITEM INTO MENU
		ummenuobj.add(addmenuitemobj);
		ummenuobj.add(delmenuitemobj);
		ummenuobj.add(updatemenuitemobj);
		
		//5. ADD MENU TO MENUBAR
		mbrobj.add(ummenuobj);
		
		//6. DISPLAY MENU
		setJMenuBar(mbrobj);
		
		setSize(650, 425);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/*public static void main(String[] args) 
	{
		new AfterLoginFrame();

	}*/

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == addmenuitemobj)
		{
			 new RegistrationFrame();
		}
		else if(e.getSource() == delmenuitemobj)
		 {
			 new DeleteUser();
		 }
		
		
	}

}