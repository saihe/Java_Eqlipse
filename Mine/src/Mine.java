import java.io.Console;
import java.util.Random;

import lib.Input;

public class Mine{
    public  static void main(String[] args){
        Console console = System.console();
        Random ran = new Random();
        while(true){
	        System.out.println("[Enter]で実行");
	        console.readLine(a);
	        int[][] mine = new int[5][5];
	        int a = Input.getInt();
	        int[] bom = new int[25];

	        for(int bb = 0 ; bb < 25 ; bb++){
		        for(int i = 0 ; i < 5 ; i++){
		        	for(int j = 0 ; j < 5 ; j++){
		        		int b = ran.nextInt(100);
				        if(b >= 0 && b < 20){
				        	bom[i] = 1;
				        }
		        		mine[i][j] = bom[i];
		        	}
		        }
	        }
	        for(int i = 0 ; i < 5 ; i++){
	        	for(int j = 0 ; j < 5 ; i++){
	        		System.out.print(mine[i][j]);
	        	}
	        }
        }
    }

}