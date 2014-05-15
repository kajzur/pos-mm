package devices;

import java.util.ArrayList;
import java.util.List;

import Main.Product;


public abstract class OutputDevice extends Device {

	protected List<Product> list =  new ArrayList<Product>();
	public OutputDevice(String name, List<Product> prods) {
		super(name);
		list = prods;
	}

	public abstract Product print(int p);
	public abstract StringBuffer print(ArrayList<Product> p);
	
}
