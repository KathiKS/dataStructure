package nonlinear;

public class Fibonaci {
	public static int fibo (int data) {
		if(data<=1) return 1;
		else return fibo(data-2)*fibo(data-1);
}
	public static void main(String[] args) {
		System.out.println(fibo(5));
	}

}
