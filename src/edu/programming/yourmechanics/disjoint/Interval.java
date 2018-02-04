package edu.programming.yourmechanics.disjoint;

import java.util.Comparator;

/**
 * Interval class to store the start and end of the interval
 * @author Arushee Garg
 * @version 1.0
 *
 */
public class Interval implements Comparable<Interval>, Comparator<Interval> {
	Integer start;
	Integer end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval o2) {

		return o2.start > this.start ? 1 : o2.start.equals(this.start) ? 0 : -1;
	}

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub

		if (o1.start.equals(o2.start) && o1.end.equals(o2.end))
			return 1;

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		boolean sameSame = false;

		if (object != null && object instanceof Interval) {
			sameSame = (this.start.equals(((Interval) object).start) && this.end.equals(((Interval) object).end));
		}

		return sameSame;
	}
}
