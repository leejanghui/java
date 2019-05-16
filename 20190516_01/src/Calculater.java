import java.util.Scanner;

class Add{
	private int Fnum, Snum;
	public void setValue(int fnum, int snum){
		this.Fnum=fnum;	
		this.Snum=snum;
	}
	public static int calculate (int fnum, int snum){
		return fnum + snum;
	}
}

class Sub{
	private int Fnum, Snum;
	public void setValue(int fnum, int snum){
		this.Fnum=fnum;
		this.Snum=snum;
	}
	public static int calculate (int fnum, int snum){
		return fnum - snum;
	}
}

class Mul{
	private int Fnum, Snum;
	public void setValue(int fnum, int snum){
		this.Fnum=fnum;	
		this.Snum=snum;
	}
	public static int calculate (int fnum, int snum){
		return fnum * snum;
	}
}

class Div{
	private int Fnum, Snum;
	public void setValue(int fnum, int snum){
		this.Fnum=fnum;	
		this.Snum=snum;
	}	
	public static int calculate (int fnum, int snum){
		return fnum / snum;
	}
}


public class Calculater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int p=1;
		int cnt=0;
		int fnum;
		char per;
		int snum;
		while(p==1){
			System.out.print("ù ���ڿ� ������ �� ��°�� �Է����ּ���>>");
			fnum = scanner.nextInt();
			per = scanner.next().charAt(0);
			snum = scanner.nextInt();
			switch (per) {
			case '+':
				Add ad = new Add();
				ad.setValue(fnum, snum);
				System.out.println(ad.calculate(fnum, snum));
				System.out.print("���� ����� 0 ��� ����� 1>>");
				p = scanner.nextInt();
				cnt++;
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(fnum, snum);
				System.out.println(sub.calculate(fnum, snum));
				System.out.print("���� ����� 0 ��� ����� 1>>");
				p = scanner.nextInt();
				cnt++;
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(fnum, snum);
				System.out.println(mul.calculate(fnum, snum));
				System.out.print("���� ����� 0 ��� ����� 1>>");
				p = scanner.nextInt();
				cnt++;
				break;
			case '/':
				Div div = new Div();
				div.setValue(fnum, snum);
				System.out.println(div.calculate(fnum, snum));
				System.out.print("���� ����� 0 ��� ����� 1>>");
				cnt++;
				p = scanner.nextInt();
				break;
			default:
				System.out.println("������ �߸��Ǿ����ϴ�.");
				System.out.print("���� ����� 0 ��� ����� 1>>");
				cnt++;
				p = scanner.nextInt();
				break;
			}
		}
		for(int i = 0; i<=cnt; i++){	
			scanner.close();
		}
	}
}
