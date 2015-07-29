import java.util.Calendar;

public class Journal {
	private Calendar date;
	private String usage;
	private int amount;
	private int balance;

	public Journal(int year , int month , int hour , int minutes , String usage , int amount){
		Calendar cal = Calendar.getInstance();
		cal.set(Year, (mounth - 1));
		this.date = date;
		this.usage = usage;
		this.amount = amount;
	}

	public String getJournal(){
		return this.date.toString() + " " + this.usage + " " + this.amount + this.balance;
	}
}
