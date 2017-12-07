package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Data_sets.MyVector;
import Ex0.Point3D;
import Ex0.WiFi_Beacons_md;
import Filter.Position_Filter;
import Filter.filter;

public class MyVectorTest {
	private MyVector _mv;
	@Before
	public void setUp() throws Exception {
		String s0 = "data/";
		WiFi_Beacons_md t = new WiFi_Beacons_md(s0);
		_mv = t.convert();
	}
	@Test
	public void testMyVector() {
		int s = 768;
		if(_mv.size()!=s) {
			System.err.println("Size Wrong vector size: "+_mv.size()+"  should be "+s );
			fail("Wrong vector size: "+_mv.size()+"  should be "+s );
		}
	}

	@Test
	public void testPosFilter() {
		double dist = 0.005;
		Point3D cen = new Point3D(32.1678190337,34.8061381649,0);
		filter pf = new Position_Filter(cen, dist); 
		_mv.filter(pf);
		int s = 447;
		if(_mv.size()!=s) {
			System.err.println("Position Wrong vector size: "+_mv.size()+"  should be "+s );
			fail("Position Wrong vector size: "+_mv.size()+"  should be "+s );
		}
		_mv.save_to_csv("447.csv");
	}
	@Test
	public void testPosFilter2() {
		double dist = 0.01;
		Point3D cen = new Point3D(32.1608190337,34.8061381649,0);
		filter pf = new Position_Filter(cen, dist); 
		_mv.filter(pf);
		int s = 586;
		if(_mv.size()!=s) {
			System.err.println("Position Wrong vector size: "+_mv.size()+"  should be "+s );
			fail("Position Wrong vector size: "+_mv.size()+"  should be "+s );
		}
		_mv.save_to_csv("586.csv");
	}
}
