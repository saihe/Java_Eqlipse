
public class Goal {
	public String goal;
	public int year;
	public int month;
	public boolean isDeleted;

	public Goal(int y , int m , String g){
		this.year  = y;
		this.month = m;
		this.goal  = g;
		this.isDeleted = false;
	}

	public String getGoal(){
		return this.year + "/" + this.month + "　" + this.goal + "\n";
	}
}
