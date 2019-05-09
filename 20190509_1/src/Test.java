import java.util.Scanner;
class Add{
		private int Fnum, Snum;
		public void setValue(int Fnum, int Snum) {
			this.Fnum = Fnum;
			this.Snum = Snum;
		}
		public int calculate() {
			return Fnum+Snum;
		}
	}

	class Sub{
		private int Fnum, Snum;

		public void setValue(int Fnum, int Snum) {
			this.Fnum = Fnum;
			this.Snum = Snum;
		}

		public int calculate() {
			return Fnum - Snum;
		}
	}

	class Mul{
		private int Fnum, Snum;

		public void setValue(int Fnum, int Snum) {
			this.Fnum = Fnum;
			this.Snum = Snum;
		}

		public int calculate() {
			return Fnum * Snum;
		}
	}
	
	class Div{
		private int Fnum, Snum;

		public void setValue(int Fnum, int Snum) {
			this.Fnum = Fnum;
			this.Snum = Snum;
		}
		public int calculate(){
			return Fnum / Snum;
		}
	}
	
public class Test {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("첫번째 변수를 입력하세요 >>");
		int Fnum = scanner.nextInt();
		System.out.print("연산자를 입력하세요 >>");
		char op = scanner.next().charAt(0);
		System.out.print("두번째 변수를 입력하세요 >>");
		int Snum = scanner.nextInt();
		switch (op) {
			case '+':
				Add add = new Add();
				add.setValue(Fnum, Snum);
				System.out.println("결과 : " + add.calculate());
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(Fnum, Snum);
				System.out.println("결과 : " + sub.calculate());
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(Fnum, Snum);
				System.out.println("결과 : " + mul.calculate());
				break;
			case '/':
				Div div = new Div();
				div.setValue(Fnum, Snum);
				System.out.println("결과 : " + div.calculate());
				break;
			default:
				System.out.println("결과가 없거나 연산자가 잘못 입력되었습니다.");
			}
		scanner.close();
	}
}
