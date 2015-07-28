import java.util.Random;

import lib.Input;

public class mine {
	public static void main(String[] args) {
		//定義

		Random r = new Random();
		int[][] mine = new int[5][5];
		int x = 0;
		int y = 0;
		int[] xbom = new int[5];
		int[] ybom = new int[5];
		int xEnter = 0;
		int yEnter = 0;
		int bom = 0;
		String[][] field = new String[5][5];

		//ボムの生成
		for(int i = 0 ; i < 5 ; i++){
			xbom[i] = r.nextInt(5);
			ybom[i] = r.nextInt(5);
		}
		for(int j = 0 ; j < 5 ; j++){
			mine[xbom[j]][ybom[j]] = 1;
			for(int k = 0 ; k < 5 ; k++){
				field[j][k] = "x";
			}
		}

		//プレイ
		while(true){
			//フィールド生成
			System.out.println("\t0\t1\t2\t3\t4\t");
			for(x = 0 ; x < 5 ; x++){
				System.out.print(x);
				for(y = 0 ; y < 5 ; y++){
					System.out.print("\t" + field[x][y]);
				}
				System.out.print("\n");
			}

			//入力
			System.out.println("破壊：0\t\tフラグ：1\t\tXに戻す：2");
			bom = Input.getInt();
			System.out.println("x座標");
			xEnter = Input.getInt();
			System.out.println("y座標");
			yEnter = Input.getInt();

			//判定
			switch(bom){
			case 0:
				switch(mine[xEnter][yEnter]){
				case 0:
					field[xEnter][yEnter] = "C";
					break;
				case 1:
					System.out.println("ゲームオーバー");
					return;
				}
				break;
			case 1:
				switch(mine[xEnter][yEnter]){
				case 0:
					field[xEnter][yEnter] = "F";
					break;
				}
				break;
			case 2:
				switch(mine[xEnter][yEnter]){
				case 0:
					field[xEnter][yEnter] = "X";
					break;
				}
			default:
				System.out.println("入力が正しくありません");
				continue;
			}
		}
	}
}
