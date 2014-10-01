package net.designtypes.examples.my.data;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import net.designtypes.examples.my.model.Gender;

import org.joda.time.Years;

@Slf4j
public class StatisticsDataStore {
	
	private static Map<Integer, Double> MALE = new HashMap<>();
	private static Map<Integer, Double> FEMALE = new HashMap<>();
	
	static {
		MALE.put(0, 77.72);
		MALE.put(1, 77.02);
		MALE.put(2, 76.04);
		MALE.put(3, 75.06);
		MALE.put(4, 74.07);
		MALE.put(5, 73.08);
		MALE.put(6, 72.09);
		MALE.put(7, 71.09);
		MALE.put(8, 70.10);
		MALE.put(9, 69.11);
		MALE.put(10, 68.11);
		MALE.put(11, 67.12);
		MALE.put(12, 66.12);
		MALE.put(13, 65.13);
		MALE.put(14, 64.14);
		MALE.put(15, 63.15);
		MALE.put(16, 62.16);
		MALE.put(17, 61.17);
		MALE.put(18, 60.20);
		MALE.put(19, 59.22);
		MALE.put(20, 58.25);
		MALE.put(21, 57.28);
		MALE.put(22, 56.31);
		MALE.put(23, 55.34);
		MALE.put(24, 54.37);
		MALE.put(25, 53.40);
		MALE.put(26, 52.43);
		MALE.put(27, 51.46);
		MALE.put(28, 50.49);
		MALE.put(29, 49.52);
		MALE.put(30, 48.56);
		MALE.put(31, 47.59);
		MALE.put(32, 46.62);
		MALE.put(33, 45.66);
		MALE.put(34, 44.69);
		MALE.put(35, 43.72);
		MALE.put(36, 42.76);
		MALE.put(37, 41.80);
		MALE.put(38, 40.84);
		MALE.put(39, 39.88);
		MALE.put(40, 38.93);
		MALE.put(41, 37.98);
		MALE.put(42, 37.03);
		MALE.put(43, 36.08);
		MALE.put(44, 35.15);
		MALE.put(45, 34.22);
		MALE.put(46, 33.29);
		MALE.put(47, 32.37);
		MALE.put(48, 31.47);
		MALE.put(49, 30.56);
		MALE.put(50, 29.67);
		MALE.put(51, 28.79);
		MALE.put(52, 27.92);
		MALE.put(53, 27.06);
		MALE.put(54, 26.21);
		MALE.put(55, 25.37);
		MALE.put(56, 24.54);
		MALE.put(57, 23.72);
		MALE.put(58, 22.90);
		MALE.put(59, 22.10);
		MALE.put(60, 21.31);
		MALE.put(61, 20.53);
		MALE.put(62, 19.76);
		MALE.put(63, 18.99);
		MALE.put(64, 18.23);
		MALE.put(65, 17.48);
		MALE.put(66, 16.74);
		MALE.put(67, 16.01);
		MALE.put(68, 15.30);
		MALE.put(69, 14.58);
		MALE.put(70, 13.89);
		MALE.put(71, 13.20);
		MALE.put(72, 12.52);
		MALE.put(73, 11.86);
		MALE.put(74, 11.21);
		MALE.put(75, 10.58);
		MALE.put(76, 9.97);
		MALE.put(77, 9.38);
		MALE.put(78, 8.82);
		MALE.put(79, 8.28);
		MALE.put(80, 7.77);
		MALE.put(81, 7.28);
		MALE.put(82, 6.81);
		MALE.put(83, 6.36);
		MALE.put(84, 5.93);
		MALE.put(85, 5.52);
		MALE.put(86, 5.13);
		MALE.put(87, 4.76);
		MALE.put(88, 4.43);
		MALE.put(89, 4.12);
		MALE.put(90, 3.84);
		MALE.put(91, 3.56);
		MALE.put(92, 3.32);
		MALE.put(93, 3.10);
		MALE.put(94, 2.89);
		MALE.put(95, 2.71);
		MALE.put(96, 2.54);
		MALE.put(97, 2.38);
		MALE.put(98, 2.23);
		MALE.put(99, 2.10);
		MALE.put(100, 1.98);
	}

	static {
		FEMALE.put(0, 82.73);
		FEMALE.put(1, 81.99);
		FEMALE.put(2, 81.01);
		FEMALE.put(3, 80.02);
		FEMALE.put(4, 79.03);
		FEMALE.put(5, 78.04);
		FEMALE.put(6, 77.05);
		FEMALE.put(7, 76.05);
		FEMALE.put(8, 75.06);
		FEMALE.put(9, 74.06);
		FEMALE.put(10, 73.07);
		FEMALE.put(11, 72.08);
		FEMALE.put(12, 71.08);
		FEMALE.put(13, 70.09);
		FEMALE.put(14, 69.09);
		FEMALE.put(15, 68.10);
		FEMALE.put(16, 67.11);
		FEMALE.put(17, 66.12);
		FEMALE.put(18, 65.13);
		FEMALE.put(19, 64.14);
		FEMALE.put(20, 63.16);
		FEMALE.put(21, 62.17);
		FEMALE.put(22, 61.18);
		FEMALE.put(23, 60.20);
		FEMALE.put(24, 59.21);
		FEMALE.put(25, 58.22);
		FEMALE.put(26, 57.24);
		FEMALE.put(27, 56.25);
		FEMALE.put(28, 55.26);
		FEMALE.put(29, 54.28);
		FEMALE.put(30, 53.29);
		FEMALE.put(31, 52.31);
		FEMALE.put(32, 51.32);
		FEMALE.put(33, 50.34);
		FEMALE.put(34, 49.36);
		FEMALE.put(35, 48.38);
		FEMALE.put(36, 47.40);
		FEMALE.put(37, 46.42);
		FEMALE.put(38, 45.45);
		FEMALE.put(39, 44.47);
		FEMALE.put(40, 43.50);
		FEMALE.put(41, 42.53);
		FEMALE.put(42, 41.57);
		FEMALE.put(43, 40.60);
		FEMALE.put(44, 39.64);
		FEMALE.put(45, 38.69);
		FEMALE.put(46, 37.74);
		FEMALE.put(47, 36.79);
		FEMALE.put(48, 35.85);
		FEMALE.put(49, 34.91);
		FEMALE.put(50, 33.98);
		FEMALE.put(51, 33.06);
		FEMALE.put(52, 32.13);
		FEMALE.put(53, 31.22);
		FEMALE.put(54, 30.31);
		FEMALE.put(55, 29.41);
		FEMALE.put(56, 28.51);
		FEMALE.put(57, 27.62);
		FEMALE.put(58, 26.73);
		FEMALE.put(59, 25.84);
		FEMALE.put(60, 24.96);
		FEMALE.put(61, 24.10);
		FEMALE.put(62, 23.23);
		FEMALE.put(63, 22.38);
		FEMALE.put(64, 21.53);
		FEMALE.put(65, 20.68);
		FEMALE.put(66, 19.84);
		FEMALE.put(67, 19.01);
		FEMALE.put(68, 18.18);
		FEMALE.put(69, 17.35);
		FEMALE.put(70, 16.53);
		FEMALE.put(71, 15.72);
		FEMALE.put(72, 14.92);
		FEMALE.put(73, 14.13);
		FEMALE.put(74, 13.36);
		FEMALE.put(75, 12.60);
		FEMALE.put(76, 11.87);
		FEMALE.put(77, 11.15);
		FEMALE.put(78, 10.45);
		FEMALE.put(79, 9.78);
		FEMALE.put(80, 9.13);
		FEMALE.put(81, 8.51);
		FEMALE.put(82, 7.91);
		FEMALE.put(83, 7.34);
		FEMALE.put(84, 6.80);
		FEMALE.put(85, 6.29);
		FEMALE.put(86, 5.81);
		FEMALE.put(87, 5.37);
		FEMALE.put(88, 4.96);
		FEMALE.put(89, 4.58);
		FEMALE.put(90, 4.25);
		FEMALE.put(91, 3.94);
		FEMALE.put(92, 3.68);
		FEMALE.put(93, 3.43);
		FEMALE.put(94, 3.19);
		FEMALE.put(95, 2.97);
		FEMALE.put(96, 2.78);
		FEMALE.put(97, 2.60);
		FEMALE.put(98, 2.43);
		FEMALE.put(99, 2.28);
		FEMALE.put(100, 2.14);
	}
	
	public double getResidualLifeExpectancy(Years age, Gender gender) {
		log.info("get residual life expectancy from database for [{}] person with age [{}]", gender, age.getYears());
		// load data from a database
		
		// dummy implementation:
		double result;
		if (gender == Gender.FEMALE) {
			result = FEMALE.get(age.getYears());
		} else {
			result = MALE.get(age.getYears());
		}

		log.info("got residual life expectancy from database: {}", result);
		return result;
	}
}
