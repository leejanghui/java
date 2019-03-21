
public class Circle {
	int radius;
	String name;

	public Circle(){
		radius = 1;
		name = "";
	}
	
	public Circle(int r, String n){
		radius = r;
		name = n;
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle pizza = new Circle(10, "책을 피자");
		double area = pizza.getArea();
		System.out.println(area);
		
		Circle donut = new Circle();
		donut.name = "책을 피자";
		area = donut.getArea();
		System.out.println(area);
		
	}

}
