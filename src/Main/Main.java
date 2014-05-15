package Main;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import devices.DeviceController;
import devices.InputDevice;
import devices.OutputDevice;


public class Main {
	
	public static void main(String[] args) {
		
		List<Product> prods = getDataBase();
		OutputDevice LCD = new OutputDevice("LCD",prods) {
			
			@Override
			public Product print(int in) {
				
				
					Integer selected = (Integer) in;
					
					if(selected == 0){
						return new Product(0.00, "Invalid bar Code", 0);
					}
					Product dummy = new Product(0.00, "dummy",selected);
					if(list.contains(dummy))
						return list.get(list.indexOf(dummy));
					else
						return new Product(0.00, "Not Found", 0);

			}

			@Override
			public StringBuffer print(ArrayList<Product> p) {
				StringBuffer sb = new StringBuffer();

				double total=0;

				for(Product pp : p)
					total+=pp.price;
				sb.append("Total is "+total);
				return sb;
			}	
		};
		
		OutputDevice printer = new OutputDevice("Printer",prods) {
			
			@Override
			public StringBuffer print(ArrayList<Product> prods) {
				
					StringBuffer sb = new StringBuffer();

					double total=0;
					for(Product p : prods)
					{
						if(p.price!=0)
							sb.append(p.name+": "+p.price+"\n");
					}
					
					for(Product p : prods)
						total+=p.price;
					sb.append("\nTotal is "+total);
					return sb;

				
			}

			@Override
			public Product print(int p) {
				// TODO Auto-generated method stub
				return null;
			}	
		};

		
		
	InputDevice barScanner = new InputDevice("BarScanner") {
		
		@Override
		public int rand() {
			//1111-1120
			//Random r = new Random();
			return 1111 + (int)(Math.random() * ((1120 - 1111) + 1));

			//return r.nextInt(1120)+1111;
		}
	};
	
	DeviceController dc = new DeviceController();
	dc.addOutputDevice(LCD, "LCD");
	dc.addOutputDevice(printer, "Printer");
	dc.setInputDevice(barScanner, "BarCodeScanner");
	try {
		dc.run();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	};

	private static List<Product> getDataBase(){
		ArrayList<Product> prods = new ArrayList<Product>();
		prods.addAll(
				
					Arrays.asList( new Product[]{
							new Product(2.3, "Mars", 1111),
							new Product(2.3, "Snieckers", 1112),
							new Product(4.99, "Tymbark 2l", 1113),
							new Product(1.99, "Twix", 1114),
							new Product(9.99, "Nescafe Gold", 1115),
							new Product(2.3, "Per³a", 1116),
					})
					
				
				);
		
		return prods;
	}
}
