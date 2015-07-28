import lib.Input;
public class Dentaku1 {

	public static void main(String[] args){
		int n;
		int total =0;
		while((n = Input.getInt()) != 0){
			total += n;
		}
		System.out.println("合計：" + total);
	}
}
