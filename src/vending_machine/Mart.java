package vending_machine;


public class Mart {
	
	
	
	/*
	 * public static void printProduct(Product p) {
		System.out.println(p.getName()); //null
		
		if ( p instanceof TemperatureProduct) {
		TemperatureProduct tp = (TemperatureProduct) p; 
		tp.setIsHot(true);
		System.out.println(tp.getIsHot());
		}
			
	}
	 */
	
	public static void main(String[] args) {

		Product p = new Product();
		p.setName("보드마카");
		p.setPrice(500);
		p.setQuantity(40);
	
		System.out.println(p);
		
		
		/*
		 * Seller
		 * --> VendingMachine
		 * --> RefundableVendingMachine
		 * IS A
		 * VendingMachine is a Seller
		 * RefundableVendingMachine is Seller
		 * Seller drinkVendingMachine = new Seller()
		 */
		
		// vending_machine.Product@87aac27
		// 제품명 : 보드마카, 가격 : 500, 재고 : 40
		
		
	//모든 클래스의 슈퍼클래스는 Object
		/*
		 * Object 
		 * --> Product
		 * 	---> TemperatureProduct
		 * Product is a Object
		 * TemperatureProduct is a Product
		 * TemperatureProduct is a Object
		 */
	/*
	 * Product p = new Product();
	TemperatureProduct tp = new TemperatureProduct();
	tp.setName("티피");
	printProduct(tp);
	printProduct(p);
	
	 */
	
	Seller drinkMachine = new VendingMachine(); //VendingMachine 생성자를 불러옴.
	
	
	Customer musk = new Customer(200_000);//Customer 생상자를 불러오고, Customer의 int wallet값에 2000000부여.
	
	
	
	drinkMachine.insertMoney(musk, "제로펩시"); //insertMoney(VendingMachine)기능 사용 Customer클래스를 변수로 둠.
	drinkMachine.pressButton(musk, "제로펩시", 50); //pressButton(VendingMachine)기능 사용 Customer클래스를 변수로 둠.

	drinkMachine.insertMoney(musk, "제로펩시"); //insertMoney(VendingMachine)기능 사용 Customer클래스를 변수로 둠.
	drinkMachine.pressButton(musk, "제로펩시"); //pressButton(VendingMachine)기능 사용 Customer클래스를 변수로 둠.
	
	drinkMachine.printProducts();
	musk.printProducts();
	
	
	
	Seller snackMachine = new RefundableVendingMachine(400);
	snackMachine.insertMoney(musk, "제로펩시");
	snackMachine.pressButton(musk, "제로펩시", 50);
	
	snackMachine.insertMoney(musk, "제로펩시");
	snackMachine.pressButton(musk, "제로펩시", 2);
	
	snackMachine.printProducts();
	musk.printProducts();
	
	

		
	}
	}

