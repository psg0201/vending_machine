package vending_machine;

/**
 * 상속 받은 클래스가 추상메소드가 존재하는 추상 클래스라면<br/>
 * 추상 메소드를 이 클래스에서 구현을 시키거나<br/>
 * 이 클래스도 추상 클래스로 만들어 주어야 한다.<br/>
 * <b>환불 불가능한 자판기</b>
 */
public class VendingMachine implements Sellable{

	
	
	/*
	 * 상품수량
	 */
	
	private Product[] productArray; //Product 클래스에서 가져옴.
	/*
	 * 	돈
	 */
	private int money; //
	
	
	
	public VendingMachine() {
		this(100_000);
	}
	public VendingMachine(int money) {
		this.money = money;
		this.productArray = new Product[3];
		
		
		this.productArray[0]= new Product(); //생성자 만들기 인스턴스로 만드려는 클래스 이름과 동일 Product
		this.productArray[0].setName("제로펩시"); //Product의 name을 할당.
		this.productArray[0].setPrice(1600); //Product의 price 할당.
		this.productArray[0].setQuantity(50); //Product의 quantity를 할당.
		if ( this.productArray.length > 1) {
			
			this.productArray[1]= new Product(); //생성자 만들기 인스턴스로 만드려는 클래스 이름과 동일 Product
			this.productArray[1].setName("제로콜라"); //Product의 name을 할당.
			this.productArray[1].setPrice(1500); //Product의 price 할당.
			this.productArray[1].setQuantity(30); //Product의 quantity를 할당.
			
		}
		if ( this.productArray.length > 2) {
			
			this.productArray[2]= new Product(); //생성자 만들기 인스턴스로 만드려는 클래스 이름과 동일 Product
			this.productArray[2].setName("제로스프라이트"); //Product의 name을 할당.
			this.productArray[2].setPrice(1400); //Product의 price 할당.
			this.productArray[2].setQuantity(20); //Product의 quantity를 할당.
			
		}
	}
	
	@Override
	public Product getProductArray() {
		return this.productArray[3];
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public void setMoney(int money) {
		this.money = money;

	}

	@Override
	public void insertMoney(Customer customer, String productName) {
		this.insertMoney(customer, productName, VendingMachine.PRODUCT_COUNT);

	}

	@Override
	public void insertMoney(Customer customer, String productName, int orderCount) {
		for ( Product product : this.productArray) {
			if (product.equals(productName)) {
				this.money += (product.getPrice() * orderCount);
				customer.pay(product.getPrice() * orderCount);
				break; // 반복을 중
			}
		}
	
	}

	@Override
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);

	}

	@Override
	
	public void pressButton(Customer customer, String productName, int orderCount) {
		for ( Product product : this.productArray ) {
			if (product.equals(productName)) {
				if (product.getQuantity() <= 0) {
					this.refund(customer, product.getPrice());
					return;
				}
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);
				
				customer.addStock(productName, product.getPrice(), orderCount);
				
				break;
			}
			
		}
		
		
	}

	
	protected void refund(Customer customer, int refundMoney) {
		
	}

	

	@Override
	public void printProducts() {
		System.out.println("자판기의 잔액: " + this.money);
		for ( Product product : this.productArray) {
			if (product != null) {
				
				System.out.println("자판기의 상품 수량 : " + product.getQuantity());
				System.out.println("자판기의 상품 이름 : " + product.getName());
			}
		}
		System.out.println("-----------------------------------");
	}
}
//	public class VendingMachine extends Seller{
	
//	public VendingMachine() {
//		super();  // 슈퍼 클래스의 파라미터가 없는 생성자를 호출 한다.
//	}
//	
//	
//	public VendingMachine(int money) {
//		super(money); // 슈퍼 클래스의 int 파라미터가 있는 생성자를 호출한다.
//		
//	}
//	
//	@Override
//	public final void insertMoney(Customer customer, String productName) {
//		super.insertMoney(customer, productName);
//	}
//	@Override
//	public final void insertMoney(Customer customer, String productName, int orderCount) {
//		super.insertMoney(customer, productName, orderCount);
//	}
//	@Override
//	public final void pressButton(Customer customer, String productName) {
//		super.pressButton(customer, productName);
//	}
//	@Override
//	public final void pressButton(Customer customer, String productName, int orderCount) { 
//		super.pressButton(customer, productName, orderCount);
//	}
//	
//	
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없습니다.");
//		System.out.println("환불은 못해드려요.");
//	}

