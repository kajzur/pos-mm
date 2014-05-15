package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Panel extends JFrame {


	private JPanel area;
	private JTextArea jta;
	public Panel(String name) {
		area = new JPanel();
		this.setTitle(name);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta = new JTextArea(26,33);
		jta.setEditable(false);
		this.setResizable(false);
		area.add(jta);
		this.setSize(400, 500);
		this.add(area);
		this.setVisible(true);	
	}
	public void printPoduct(Product p) {
		if(p.price!=0)
			this.jta.append(p.name+": "+p.price+"\n");
		else
			this.jta.append(p.name+"\n");
	}
	public void printString(String string, boolean isScanner) {
		if(isScanner)
			this.jta.append("I'm scanning: "+string+"\n");
		else
			this.jta.append(string+"\n");

		
	}
	
}
