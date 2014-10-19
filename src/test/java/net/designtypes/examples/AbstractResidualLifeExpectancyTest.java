package net.designtypes.examples;

import java.util.ArrayList;
import java.util.List;

import net.designtypes.examples.my.MySolution;
import net.designtypes.examples.powerful.PowerfulSolution;
import net.designtypes.examples.robust.RobustSolution;
import net.designtypes.examples.simple.SimpleSolution;
import net.designtypes.examples.technologic.TechnologicSolution;

import org.junit.Before;

public abstract class AbstractResidualLifeExpectancyTest {

	protected static final double EPSILON = 0.1;
	
	protected List<Solution> solutions = new ArrayList<>();
	
	@Before
	public void setup() {
		solutions.add(new MySolution());
		solutions.add(new SimpleSolution());
		solutions.add(new RobustSolution());
		solutions.add(new TechnologicSolution());
		solutions.add(new PowerfulSolution());
	}
}