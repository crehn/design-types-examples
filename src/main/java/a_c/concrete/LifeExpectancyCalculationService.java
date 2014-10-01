package a_c.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LifeExpectancyCalculationService {
	
	private ILifeExpectancyStatisticsDao lifeExpectancyStatisticsDao;
	
	@Autowired
	public void setLifeExpectancyStatisticsDao(ILifeExpectancyStatisticsDao lifeExpectancyStatisticsDao) {
		this.lifeExpectancyStatisticsDao = lifeExpectancyStatisticsDao;
	}

	public float calculateLifeExpectancy(Human human) {
		float lifeExpectancy;
		lifeExpectancy = this.lifeExpectancyStatisticsDao.loadLifeExpectancy(human.getBirthday(), human.isMale());
		for (PersonalAttribute curPersAttr : human.getPersonalAttributes()) {
			lifeExpectancy += curPersAttr.getLifeExpectancyDifferential();
		}
		return lifeExpectancy;
	}
}
