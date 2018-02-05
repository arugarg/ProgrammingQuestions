

package edu.programming.yourmechanics.disjoint;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Arushee Garg
 * @version 1.0
 */
class TestSample {

	@Rule
	 public final ExpectedException exception = ExpectedException.none();
	
	
	
	@Test
	/* test for the given sample valid input in problem Statement*/
	void testSample() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",  1,5  );
		disjoint.union("remove",  2,3  );
		disjoint.union("add",  6,8  );
		disjoint.union("remove",  4,7  );
		disjoint.union("add",  2,7  );
		
		list = disjoint.getList();
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add(new Interval(1,8));
		
		assertEquals("test is not passed testSample()",result, list);
		
	}
	
	
	@Test
	/* test for a valid input */
	void test2() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",901,5000);
		disjoint.union("remove",2000,3000);
		disjoint.union("add",60,80);
		disjoint.union("remove",40,70);
		disjoint.union("add",70,7000);
		
		list = disjoint.getList();
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add( new Interval(70,7000));
		
		assertEquals("test is not passed test2() ",result, list);
		
	}
	
	
	@Test
	/* test for a invalid input of Interval throws an error*/
	void testForInvalidInterval() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",-20,50);
		disjoint.union("add",-20,-20);
		disjoint.union("add",-20,-1);
		
		exception.expect(IllegalArgumentException.class);
		list = disjoint.getList();	
		
	}
	
	
	@Test
	/* test for a valid input of negative and positive numbers in the interval */
	void testWithNegativeNumbers() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",-20,50);
		disjoint.union("add",-20,-20);
		disjoint.union("add",-40,-20);
		disjoint.union("remove",2000,3000);
		disjoint.union("add",2000,3000);
		disjoint.union("add",60,80);
		disjoint.union("remove",40,2500);
		disjoint.union("add",200,250);
		
		list = disjoint.getList();
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add( new Interval(-40,40));
		result.add( new Interval(200,250));
		result.add( new Interval(2500,3000));
		
		//System.out.println(disjoint.printList());
		
		assertEquals("test is not passed testWithNegativeNumbers() ",result, list);
		
	}
	
	@Test
	/* test for a valid input of random numbers in the interval from
	 *  one of the files generated from GenerateInput code*/
	void testWithRandomNumbers() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",8640,8731);
		disjoint.union("add",8248,9134);
		disjoint.union("remove",8091,8359);
		disjoint.union("add",1066,1347);
		disjoint.union("remove",8646,8664);
		disjoint.union("add",-793,118);
		disjoint.union("add",3105,3740);
		disjoint.union("add",890,997);
		disjoint.union("add",4481,5466);
		disjoint.union("add",6368,6973);
		
		list = disjoint.getList();
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add( new Interval(-793,118));
		result.add( new Interval(890,997));
		result.add( new Interval(1066,1347));
		result.add( new Interval(3105,3740));
		result.add( new Interval(4481,5466));
		result.add( new Interval(6368,6973));
		result.add( new Interval(8359,8646));
		result.add( new Interval(8664,9134));
		
		//System.out.println(disjoint.printList());
		
		assertEquals("test is not passed with testWithRandomNumbers() ",result, list);
		
	}


}
