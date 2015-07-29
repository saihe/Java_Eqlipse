import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CashBook {
	private ArrayList<Goal> goal;
	private ArrayList<Journal> journal;

	public CashBook(){
		goal = new ArrayList<Goal>();
		journal = new ArrayList<Journal>();
	}

	public void deleteGoal(int y , int m){
		for(int i = 0 ; i < goal.size() ; i++){
			if(goal.get(i).year == y && goal.get(i).month == m){
				goal.get(i).isDeleted = true;
			}
		}
	}

	public void addGoal(int y , int m , String g){
		goal.add(new Goal(y , m , g));
		this.sortGoal();
	}

	public String getAllGoal(){
		String r = "";
		for(int i = 0 ; i < goal.size() ; i++){
			if(goal.get(i).isDeleted == false){
				r += goal.get(i).getGoal();
			}
		}
		return r;
	}

	public void sortGoal(){
		Collections.sort(goal , new GoalComparator());
	}

	public void addJournal(Calendar date , String usage , int amount){
		journal.add(new Journal(date , usage , amount));
		//this.sortJournal();
	}

}
