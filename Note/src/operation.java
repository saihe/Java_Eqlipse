import java.util.HashMap;

public class operation {

	//配列
		HashMap<Integer , HashMap<String , String>> list = new HashMap<Integer , HashMap<String , String>>();
		HashMap<Integer , HashMap<String , String>> listCopy = new HashMap<Integer , HashMap<String , String>>();
		HashMap<String , String> data = new HashMap<String , String>();
		HashMap<String , String> copy = new HashMap<String , String>();
	//日付：0 時間：1 科目：2 入金：3 出金：4 残金：5
		int[] total = new int[3];
		int k = 0;


	//日付入力
	public HashMap<String , String> getDate(int d){
		String sd = String.valueOf(d);
		data.put("日付" , sd);
		return data;
	}

	//時間入力
	public HashMap<String , String> getTime(int t){
		String st = String.valueOf(t);
		data.put("時間" , st);
		return data;
	}

	//科目入力
	public HashMap<String , String> getWhat(String w){
		String sw = String.valueOf(w);
		data.put("科目" , sw);
		return data;
	}

	//入金・出金入力、残高計算・入力
	public HashMap<String , String> getResult(int p , int m){
		int result = p - m ;
		String sp = String.valueOf(p);
		String sm = String.valueOf(m);
		data.put("入金" , sp);
		data.put("出金" , sm);
		String sr = String.valueOf(result);
		data.put("残金" , sr);
		return data;
	}

	//データを配列
	@SuppressWarnings("unchecked")
	public HashMap<Integer , HashMap<String , String>> listUp(){
		copy = (HashMap<String, String>) data.clone();
		list.put(k , copy);
		k++;
		return list;
	}

	//所持金合計
	public int[] getTotal(){
		int plusTotal  = 0;
		int minusTotal = 0;
		for(int t = 0 ; t < list.size() ; t++){
			plusTotal  += Integer.parseInt(list.get(t).get("入金"));
			minusTotal += Integer.parseInt(list.get(t).get("出金"));
		}
		int resultTotal = (plusTotal - minusTotal);
		total[0] = plusTotal;
		total[1] = minusTotal;
		total[2] = resultTotal;
		return total;
	}

	//更新
	public HashMap<Integer , HashMap<String , String>> update(int f , int s , String u){
		//入力された数値で更新する配列を選ぶ
		HashMap<String , String> up = new HashMap<String , String>();
		switch(f){
		case 0:
			up = list.get(s);
			up.put("日付" ,  u);
			break;
		case 1:
			up = list.get(s);
			up.put("時間" ,  u);
			break;
		case 2:
			up = list.get(s);
			up.put("科目" ,  u);
			break;
		case 3:
			up = list.get(s);
			up.put("入金" ,  u);
			break;
		case 4:
			up = list.get(s);
			up.put("出金" ,  u);
			break;
		default:
			System.out.println("コマンドエラーです");
		}

		//配列上の残金を計算し直す
		int pm = Integer.parseInt(up.get("入金"));
		int mm = Integer.parseInt(up.get("出金"));
		String tm =String.valueOf(pm - mm);
		list.get(s);
		up.put("残金" ,  tm);
		list.put(s , up);
		return list;
	}

	//削除
	public HashMap<Integer , HashMap<String , String>> delete(){
		//全件削除
		HashMap<String , String> del = new HashMap<String , String>();
		for(int d = 0 ; d < list.size() ; d++){
			list.remove(d);
		}
		k = 0;
		list.put(0 , del);
		return list;
	}

	//1行削除
	public HashMap<Integer , HashMap<String , String>> delete1(int line){
		list.remove(line);
		while(line < list.size()){
			list.put(line , list.get(line + 1));
			line++;
		}
		list.remove(list.size() - 1);
		k -= 1;
		return list;
	}

	//ソート
	public HashMap<Integer , HashMap<String , String>> listSort(){
		int sort = 0;
		listCopy.put(sort ,  list.get(sort));
		while(sort < list.size()){
			listCopy.put((sort + 1) , list.get(sort));
			sort++;
		}
		/*
		sort = 0;
		if(listCopy.get(sort).get("日付") < listCopy.get(sort + 1).get("日付")){

		}
		*/
		return listCopy;
	}

}
