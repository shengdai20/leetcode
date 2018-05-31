package problem_57;

import java.util.ArrayList;
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
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		List<Interval> res = new Main().insert(intervals, new Interval(4, 9));
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + "," + res.get(i).end);
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		LinkedList<Interval> res = new LinkedList<Interval>();
		int i = 0;
		//将所有start前未重叠部分add进res中
		while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i++));
		}
		//如果有重叠部分，即intervals.get(i).start < newInterval.end时，则更新newInterval
		//注意这里是比较start和end，而不是end和end，因为如果比较end和end，会漏掉最后一个newInterval.end<intervals.get(i).end的区间
		//而可以想象，只要有intervals.get(i).start < newInterval.end，则说明有区间重叠
		while(i < intervals.size() && intervals.get(i).start < newInterval.end) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i++).end, newInterval.end));
		}
		//将更新后的newInterval加入res
		res.add(newInterval);
		//将end后未重叠部分add进res中，其实这里初始给出的list已经保证了每个区间都未重叠
		while(i < intervals.size()) {
			res.add(intervals.get(i++));
		}
		return res;
	}

}
