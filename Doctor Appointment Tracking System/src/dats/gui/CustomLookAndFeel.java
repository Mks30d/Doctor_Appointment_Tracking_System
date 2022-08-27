package dats.gui;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class CustomLookAndFeel 
{
	
	public static void setLookAndFeel()
	{
		try
		{
			
			
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
