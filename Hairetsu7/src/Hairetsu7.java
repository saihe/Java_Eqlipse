
public class Hairetsu7 {
	public static void main(String[] args){
		int[] n = new int[3] ;
		System.out.println("初期値");
		for(int num : n){
			System.out.println(num);
		}
		n[0] = 5;
		n[1] = 9;
		n[2] = 3;
		System.out.println("設定後");
		for(int num : n){
			System.out.println(num);
		}
	}
}
