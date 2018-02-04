package edu.programming.yourmechanics.disjoint;

import java.util.ArrayList;

/**
 * Disjoint class holds the disjoint list and provides functionality to add or
 * remove an Interval
 * 
 * @author Arushee Garg
 * @version 1.0
 */
public class DisjointSet {

	private ArrayList<Interval> list;

	public DisjointSet(ArrayList<Interval> list) {
		this.list = list;
	}

	/**
	 * finds the index of the interval in the list using Binary Search Time
	 * Complexity : O(logn)
	 * 
	 * @param interval
	 * @return the index of the interval which has start smaller than the the given
	 *         interval.
	 */
	private int findIndex(Interval interval) {
		// using binary search to find the given Interval : log(N) complexity
		int initial = 0;
		int last = list.size() - 1;
		int mid, index = initial;
		while (initial <= last) {

			mid = initial + (last - initial) / 2;

			if (list.get(mid).compareTo(interval) == -1) {
				// reduce last

				last = mid - 1;
			} else if (list.get(mid).compareTo(interval) == 1) {
				// increase initial and save
				index = initial;
				initial = mid + 1;
			} else {
				return mid;
			}
		}
		return index;
	}

	/**
	 * Adds the given interval and also performs the merged operation. Time
	 * Complexity : O(n)
	 * @param interval
	 */
	private void add(Interval interval) {

		/*
		 * find the index where new interval to be added i.e one greater than the found
		 * index so that list remains sorted
		 */
		int index = findIndex(interval);
		if (list.size() > 1)
			index++;

		
		/*
		 * if list is empty or all intervals in the list are smaller than start of the
		 * interval
		 */
		if (list.size() == 0 || list.get(list.size() - 1).end < interval.start) {
			list.add(interval);
		}
		//adding before the start
		else if(interval.end <= list.get(0).start) {
			list.add(0,interval);
		}
		/* else adding at the given index so the list is always remains sorted */
		else
			list.add(index, interval);

		/* Create a new list merged for comparing and merging */
		ArrayList<Interval> merged = new ArrayList<Interval>();

		for (Interval item : list) {

			int last = merged.size() - 1;
			/*
			 * if the list of merged intervals is empty or if the current interval does not
			 * overlap with the previous, simply append it.
			 */
			if (merged.isEmpty() || merged.get(last).end < item.start) {
				merged.add(item);
			}
			/*
			 * otherwise, there is overlap, so merge the current and previous intervals.
			 */
			else {
				merged.get(last).end = Math.max(merged.get(last).end, item.end);
			}
		}

		/* make this merged list as the list */
		this.list = merged;
	}

	/**
	 * Removes the given interval and
	 * Time Complexity : O(n)
	 * @param interval
	 */
	private void remove(Interval interval) {

		// if this interval doesn't have any overlap with the list do nothing.
		if (list.size() == 0 || list.get(list.size() - 1).end < interval.start || interval.end <= list.get(0).start)
			return;

		// findIndex after which this interval lies
		int index = findIndex(interval);

		/* iterating only after this found index */
		while (index < list.size() && interval.end > list.get(index).start) {

			Integer end = list.get(index).end;
			Integer start = list.get(index).start;

			// if the remove interval is overlapping with this iterating interval */

			if (start <= interval.start) {
				list.get(index).end = Math.min(end, interval.start);
			}

			else if (end >= interval.end) {
				list.get(index).start = Math.max(start, interval.end);
			}

			if (list.get(index).end.equals(list.get(index).start) ){

				list.remove(index);

			} else
				index++;

			/*
			 * creating a new interval if the removed interval is contained within the
			 * iterating interval so it splits the interval in two parts e.g [1,5] having
			 * removal interval [2,3] splits into [1,2] and [3,5]
			 */
			if (end > interval.end) {
				Interval newInterval = new Interval(interval.end, end);
				if (!list.contains(newInterval))
					list.add(index, newInterval);
			}
		}

	}

	/**
	 * Main call to the Disjoint class which performs operations on the list.
	 * 
	 * @param op
	 *            : operation (add/remove)
	 * @param low
	 *            : lower start value of interval
	 * @param high
	 *            : higher end value of interval
	 */
	public void union(String op, Integer low, Integer high) {

		Interval interval = new Interval(low, high);
		if (op.equals("add")) {
			add(interval);
		} else if (op.equals("remove")) {
			remove(interval);
		} else {
			throw new IllegalArgumentException("Please provide a valid operation add/remove");
		}

	}

	/**
	 * Getter method to get the list.
	 * 
	 * @return
	 */
	public ArrayList<Interval> getList() {
		return list;
	}

	/**
	 * Method to print the list in the [[start, end]].. format
	 * 
	 * @return
	 */
	public String printList() {
		String s = "[";
		int count = 0;
		for (Interval i : list) {
			s += "[" + i.start + "," + i.end + "]";
			count++;
			//if not last
			if(count != list.size())
				s += ", ";
		}
		s += "]";
		return s;
	}
	
	public String printList(ArrayList<Interval> res) {
		String s = "[";
		int count = 0;
		for (Interval i : res) {
			s += "[" + i.start + "," + i.end + "]";
			count++;
			//if not last
			if(count != res.size())
				s += ", ";
		}
		s += "]";
		return s;
	}
	
}
