

package edu.programming.yourmechanics.disjoint;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Arushee Garg
 * @version 1.0
 */
class TestSample {

	@Test
	void test() {
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
		
		//assertTrue(list.equals(result));
		
		assertEquals("test is not passed ",result, list);
		
	}
	
	
	@Test
	void test2() {
		ArrayList<Interval> list = new ArrayList<>();
		DisjointSet disjoint = new DisjointSet(list);
		
		disjoint.union("add",901,5000);
		disjoint.union("remove",2000,3000);
		disjoint.union("add",60,80);
		disjoint.union("remove",40,70);
		disjoint.union("add",20,7000);
		
		list = disjoint.getList();
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		//result.add( new Interval(70,80));
		result.add( new Interval(70,7000));
		
		System.out.println(disjoint.printList(result));
		
		System.out.println(disjoint.printList());
		
		//assertTrue(list.equals(result));
		
		assertEquals("test is not passed ",result, list);
		
	}

}
