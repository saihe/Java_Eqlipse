import lib.Input;

public class Main {
	static CashBook cb = new CashBook();

	public static void main(String[] args) {
		//サンプルデータ
		cb.addGoal(2015 , 1 , "3万円貯金");
		cb.addGoal(2015 , 2 , "家を買う");
		cb.addGoal(2015 , 3 , "100円貯金");
		while(true){
			System.out.println(cb.getAllGoal());
			System.out.println("1：目標の追加 2：目標削除 3：目標の変更 4：仕訳の追加");
			int n = Input.getInt();
			if(n == 1){
				System.out.println("例）2015,1,家を買う");
				String str = Input.getString();
				try{
					String[] input = str.split(",",0);
					int year = Integer.parseInt(input[0]);
					int month = Integer.parseInt(input[1]);
					String goal = input[2];
					cb.addGoal(year ,  month ,  goal);
				}catch(Exception e){

				}
			}else if(n == 2){
				System.out.println("年,月を指定");
				String str = Input.getString();
				try{
					String[] input = str.split(",",0);
					int year = Integer.parseInt(input[0]);
					int month = Integer.parseInt(input[1]);
					cb.deleteGoal(year ,  month);
				}catch(Exception e){
					System.out.println(e);
				}
			}else if(n == 3){
				System.out.println("年,月を指定");
				System.out.println("例）2015,1,家を買う");
				String str = Input.getString();
				try{
					String[] input = str.split(",",0);
					int year = Integer.parseInt(input[0]);
					int month = Integer.parseInt(input[1]);
					String goal = input[2];
					cb.deleteGoal(year ,  month);
					cb.addGoal(year , month ,goal);
				}catch(Exception e){
					System.out.println(e);
				}
			}else if(n == 4){
				System.out.println("年,月,日,時間,分,用途,金額を指定");
				System.out.println("例）2015,1,1,12,34,家を買う,-500");
				String str = Input.getString();
				try{
					String[] input = str.split(",",0);
					int year    = Integer.parseInt(input[0]);
					int month   = Integer.parseInt(input[1]);
					int day     = Integer.parseInt(input[2]);
					int hour    = Integer.parseInt(input[3]);
					int minutes = Integer.parseInt(input[4]);
					String usage = input[5];
					int amount  = Integer.parseInt(input[6]);
					cb.addJournal(year , month , day , hour , minutes , usage , amount);
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
	}
}
