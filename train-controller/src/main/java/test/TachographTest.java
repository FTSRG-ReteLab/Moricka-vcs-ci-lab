/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.controller.Tachograph;
import junit.framework.Assert;

/**
 * JUnit osztály a tachograph teszteléséhez
 * @author meres
 *
 */
public class TachographTest {


	Tachograph tg;
	
	List<Double> times = new ArrayList<Double>();
	List<Double> positions = new ArrayList<Double>();
	List<Double> speeds = new ArrayList<Double>();
	
	
	
	@Before
	public void setUp() throws Exception {
		//init times
		times.add(4.2);
		times.add(1.11);
		
		//init positions
		positions.add(22.0);
		positions.add(22.22);
		
		//init sppeeds
		speeds.add(2.2);
		speeds.add(40.4);		
	}

	@Test
	public void test1() {
		tg = new Tachograph(times, positions, speeds);
		
		assertEquals(2.2, tg.getVal(0, "reference speed"),0.1);
	}
	
	@Test
	public void test2() {
		
		tg = new Tachograph(times, positions, speeds);
		
		tg.addMeasurement(55.55, 55.56, 55.57);
		
		assertEquals(55.55, tg.getVal(1, "current time"),0.1);
	}
}
