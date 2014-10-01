package net.designtypes.examples;

import java.util.ArrayList;
import java.util.List;

import net.designtypes.examples.my.MySolution;

import org.junit.Before;

public abstract class AbstractResidualLifeExpectancyTest {

	protected static final double EPSILON = 0.1;
	
	protected List<Solution> solutions = new ArrayList<>();
	
	@Before
	public void setup() {
		solutions.add(new MySolution());
		// addSimpleSolution();
	}
}