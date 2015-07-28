import java.util.ArrayList;

public class operation {

	//配列
	//日付：0 時間：1 科目：2 入金：3 出金：4 残金：5
	//各項目毎配列
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		ArrayList<String> what = new ArrayList<String>();
		ArrayList<String> plus = new ArrayList<String>();
		ArrayList<String> minus = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		//日付：0 時間：1 科目：2 入金：3 出金：4 残金：5
		String[][] list = new String[6][];
		int[] total = new int[3];


	//日付入力
	public ArrayList<String> getDate(int d){
		String sd = String.valueOf(d);
		date.add(sd);
		list = new String[6][date.size()];
		return date;
	}

	//時間入力
	public ArrayList<String> getTime(int t){
		String st = String.valueOf(t);
		time.add(st);
		return time;
	}

	//科目入力
	public ArrayList<String> getWhat(String w){
		String sw = String.valueOf(w);
		what.add(sw);
		return what;
	}

	//入金・出金入力、残高計算・入力
	public ArrayList<String> getResult(int p , int m){
		int total = p - m ;
		String sp = String.valueOf(p);
		String sm = String.valueOf(m);
		plus.add(sp);
		minus.add(sm);
		String sr = String.valueOf(total);
		result.add(sr);
		return result;
	}

	//データを配列
	public String[][] listUp(){
		for(int i = 0; i < date.size() ; i++){
			list[0][i] = date.get(i);
			list[1][i] = time.get(i);
			list[2][i] = what.get(i);
			list[3][i] = plus.get(i);
			list[4][i] = minus.get(i);
			list[5][i] = result.get(i);
		}
		return list;
	}

	//更新
	public String[][] update(int f , int s , String u){
		//入力された数値で更新する配列を選ぶ

		switch(f){
		case 0:
			date.set(s ,  u);
			break;
		case 1:
			time.set(s ,  u);
			break;
		case 2:
			what.set(s ,  u);
			break;
		case 3:
			plus.set(s ,  u);
			break;
		case 4:
			minus.set(s , u);
			break;
		default:
			System.out.println("コマンドエラーです");
		}

		//配列上の残金を計算し直す
		int pm = Integer.parseInt(plus.get(s));
		int mm = Integer.parseInt(minus.get(s));
		String tm =String.valueOf(pm - mm);
		result.set(s ,  tm);
		return list;
	}

	//削除
	public String[][] delete(){
		//配列の初期化
		list = new String[10][6];
		date.clear();
		time.clear();
		what.clear();
		plus.clear();
		minus.clear();
		result.clear();
		return list;
	}

	//1行削除
	public String[][] delete1(int line){
		date.remove(line);
		time.remove(line);
		what.remove(line);
		plus.remove(line);
		minus.remove(line);
		result.remove(line);
		for(int i = 0 ; i < date.size() ; i++){
			list[line][i] = null;
		}
		return list;
	}

	//所持金合計
	public int[] getTotal(){
		int plusTotal = 0;
		int minusTotal = 0;
		for(int i = 0 ; i < date.size() ; i++){
				plusTotal += Integer.parseInt(list[3][i]);
				minusTotal += Integer.parseInt(list[4][i]);
		}

		int resultTotal = (plusTotal - minusTotal);
		total[0] = plusTotal;
		total[1] = minusTotal;
		total[2] = resultTotal;
		return total;
	}
}
