
public class Circle {
	int radius;
	String name;
	
	public Circle() {
		
	}
	public double getArea() {
		return 3.14 * radius * radius;
	}
	public static void main(String[] args) {
		Circle pizza;
		pizza = new Circle();
		pizza.radius = 5;
		pizza.name="책을 피자";
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적" + area);
		
		Circle donut = new Circle();
		donut.radius = 3;
		donut.name = "머리";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적" + area);

	}

}
