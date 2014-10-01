package a_c.concrete;

import java.util.Calendar;

public interface ILifeExpectancyStatisticsDao {

	float loadLifeExpectancy(Calendar birthday, boolean male);
}
