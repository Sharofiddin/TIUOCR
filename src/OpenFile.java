import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class OpenFile
{
	private File file = null;
	private File chFile = null;
	private BufferedImage img;
	private JFileChooser fileChooser = new JFileChooser();
	public String sb;
	private String chiq = "";
	public String chiq1 = "";
	public String chiq2 = "";
	public String chiq3 = "";
	
	
	public void PickMe() throws Exception
	{
		if ( fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			file = fileChooser.getSelectedFile();
			try 
			{
				img = ImageIO.read(file); 
				sb = file.getAbsolutePath();
				int k = 0;
				for( int i = 0; i < sb.length(); i++ )
				{
					if( sb.charAt(i) == '.') k = i;
				}
				for(int i = 0; i < k; i++ )
				{
					chiq += sb.charAt(i);
				}
				chiq1 = chiq + "extract.txt";
				chiq2 = chiq + "extract.doc";
				chiq3 = chiq + "extract.pdf";
				
			} catch (Exception e) {
				// TODO: handle exception
			} 
			
		}
		else
		{
			sb =  "No files was selected";
		}
	}

}
