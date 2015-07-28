
public class Break3 {
	public static void main(String[] args){
		flag:
			for(int i = 0 ; i < 5 ; i++){
				int j = 0;
				while(j < 5){
					System.out.println(i + "：" + j);
					if(j == 2){
						break flag;
					}
					j++;
				}
			}
	}
}
