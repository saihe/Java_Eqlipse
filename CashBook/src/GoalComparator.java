import java.util.Comparator;

public class GoalComparator implements Comparator<Goal>{
	@Override
	public int compare(Goal g1 , Goal g2){
		if(g1.year > g2.year || (g1.year == g2.year && g1.month > g2.month)){
			return 1;
		}
		return  -1;
	}

}
