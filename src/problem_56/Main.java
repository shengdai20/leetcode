package problem_56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	static class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
//		list.add(new Interval(1, 3));
//		list.add(new Interval(2, 6));
//		list.add(new Interval(8, 10));
//		list.add(new Interval(15, 18));
	//	list.add(new Interval(1, 4));
	//	list.add(new Interval(0, 1));
	//	list.add(new Interval(0, 1));
		list.add(new Interval(2, 3));
		list.add(new Interval(4, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(1, 9));
		List<Interval> res = new Main().merge(list);
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + "," + res.get(i).end);
		}
	}
	
	//自定义排序，按照start升序
	class sortStart implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new sortStart());
		LinkedList<Interval> res = new LinkedList<Interval>();
		for(Interval interval : intervals) {
			//如果未重叠，则直接add
			if(res.isEmpty() || res.getLast().end < interval.start) {
				res.add(interval);
			}
			//如果重叠，则更新end，因为已经按start排好序，所以只更新end即可，不用更新start
			else {
				res.getLast().end = Math.max(res.getLast().end, interval.end);
			}
		}
		return res;
	}

}
