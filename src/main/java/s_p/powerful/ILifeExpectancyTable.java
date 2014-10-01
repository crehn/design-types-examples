package s_p.powerful;

import java.util.Calendar;

public interface ILifeExpectancyTable {
	
	float getStatisticalLifeExpectancy(Calendar birthday, boolean male);
}
