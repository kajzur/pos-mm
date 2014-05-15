package devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Main.Panel;
import Main.Product;

public class DeviceController  {

	private HashMap<OutputDevice, Panel> output = new HashMap<OutputDevice,Panel>();
	private InputDevice input;
	private Panel inputPanel;
	public DeviceController() {

	}
	
	public void addOutputDevice(OutputDevice d, String name)
	{
			output.put(d, new Panel(name));
	}
	public void setInputDevice(InputDevice id, String name)
	{
		input = id;
		inputPanel = new Panel(name);
	}

	public void run() throws InterruptedException {
		
		ArrayList<Product> prods = new ArrayList<Product>();
		int i=13; // number of product which will be scanned before exit;
		while(true){
			if(i==0)
			{
				for (Map.Entry<OutputDevice, Panel> entry : output.entrySet()) {
					OutputDevice key = entry.getKey();
					Panel value = entry.getValue();
					String txt = key.print(prods).toString();
					value.printString(txt, false);
				}
				inputPanel.printString("Exit", false);
				break;
			}
			int randonBarCode = input.rand();
			inputPanel.printString(randonBarCode+"", true);
			for (Map.Entry<OutputDevice, Panel> entry : output.entrySet()) {
				OutputDevice key = entry.getKey();
				Panel value = entry.getValue();
			    Product p = key.print(randonBarCode);
			    if(p!=null){
				    value.printPoduct(p);
				    prods.add(p);
			    }
			}
			Thread.sleep(1000);
			i--;
		}
		
	}
	
}
