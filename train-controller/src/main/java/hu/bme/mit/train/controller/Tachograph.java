package hu.bme.mit.train.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

public class Tachograph {
	private Table<Integer, String, Double> values;
	private ArrayList<String> strings;
	
	public Tachograph(List<Double> times, List<Double> positions, List<Double> speeds){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		for(int i = 0; i < times.size(); i++)
			nums.add(i);
		strings.add("current time");
		strings.add("joystick position");
		strings.add("reference speed");
		values = ArrayTable.create(nums, strings);
		for(int i = 0; i < times.size(); i++){
			values.put(i, strings.get(0), times.get(i));
			values.put(i, strings.get(1), positions.get(i));
			values.put(i, strings.get(2), speeds.get(i));
		}
	}
	
	public void addMeasurement(double time, double pos, double speed){
		values.put(((values.size()/3)-1) , strings.get(0), time);
		values.put(((values.size()/3)-1), strings.get(1), pos);
		values.put(((values.size()/3)-1), strings.get(2), speed);
		
	}
	
	public double getVal(int rowid, String colname){
		return values.get(rowid, colname);
	}
}
