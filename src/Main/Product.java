package Main;

public class Product {
	//it can be entity
	double price;
	String name;
	int barCode;
	public Product(double price, String name, int barCode) {
		super();
		this.price = price;
		this.name = name;
		this.barCode = barCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Product))
		{
			return false;
		}
		Product p = (Product) obj;
		return p.barCode == this.barCode;
	}
	
}
