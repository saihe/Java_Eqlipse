import lib.Input;
public class Break1 {
	public static void main(String[] args){
		int vote, ok = 0 , ng = 0;
		while((vote = Input.getInt()) != 0){
			if((vote != 1 && vote != 2)){
				System.out.println("中止！");
				break;
			}
			if(vote == 1){
				ok++;
			}else{
				ng++;
			}
		}
		System.out.println("賛成：" + ok);
		System.out.println("反対：" + ng);
	}
}
