package com.Yatra.bean;

public class FlightOneWayData {
	private String LeavingFrom,GoingTo,DepatcherDate,classSelection;
	private int Adualtselection,childrenSelection,infantsSelection;
	private String arivaldate;
	
	public void setArivaldate(String arivaldate) {
		this.arivaldate = arivaldate;
	}
	public String getArivaldate() {
		return arivaldate;
	}
	public String getLeavingFrom() {
		return LeavingFrom;
	}
	public void setLeavingFrom(String leavingFrom) {
		LeavingFrom = leavingFrom;
	}
	public String getGoingTo() {
		return GoingTo;
	}
	public void setGoingTo(String goingTo) {
		GoingTo = goingTo;
	}
	public String getDepatcherDate() {
		return DepatcherDate;
	}
	public void setDepatcherDate(String depatcherDate) {
		DepatcherDate = depatcherDate;
	}
	public String getClassSelection() {
		return classSelection;
	}
	public void setClassSelection(String classSelection) {
		this.classSelection = classSelection;
	}
	public int getAdualtselection() {
		return Adualtselection;
	}
	public void setAdualtselection(double adualtselection) {
		Adualtselection = (int) adualtselection;
	}
	public int getChildrenSelection() {
		return childrenSelection;
	}
	public void setChildrenSelection(double childrenSelection) {
		this.childrenSelection = (int) childrenSelection;
	}
	public int getInfantsSelection() {
		return infantsSelection;
	}
	public void setInfantsSelection(double infantsSelection) {
		this.infantsSelection = (int) infantsSelection;
	}
	

}
