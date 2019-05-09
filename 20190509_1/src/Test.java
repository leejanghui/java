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

		System.out.print("ù��° ������ �Է��ϼ��� >>");
		int Fnum = scanner.nextInt();
		System.out.print("�����ڸ� �Է��ϼ��� >>");
		char op = scanner.next().charAt(0);
		System.out.print("�ι�° ������ �Է��ϼ��� >>");
		int Snum = scanner.nextInt();
		switch (op) {
			case '+':
				Add add = new Add();
				add.setValue(Fnum, Snum);
				System.out.println("��� : " + add.calculate());
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(Fnum, Snum);
				System.out.println("��� : " + sub.calculate());
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(Fnum, Snum);
				System.out.println("��� : " + mul.calculate());
				break;
			case '/':
				Div div = new Div();
				div.setValue(Fnum, Snum);
				System.out.println("��� : " + div.calculate());
				break;
			default:
				System.out.println("����� ���ų� �����ڰ� �߸� �ԷµǾ����ϴ�.");
			}
		scanner.close();
	}
}
