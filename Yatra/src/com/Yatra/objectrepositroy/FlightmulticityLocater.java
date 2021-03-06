package com.Yatra.objectrepositroy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*@Author:tapana
 *@Version:1.0
 * In this class collaction of all multi city locater
 * 
 * */
public class FlightmulticityLocater {
	//multicity locater button
	@FindBy(xpath="//a[text()='Multicity']")
	private WebElement Multicity;
	//leaving from button
	@FindBy(xpath="//input[@id='BE_flight_origin_city_1']")
	private WebElement Leavingfrom1;
	//going to button
	@FindBy(xpath="//input[@id='BE_flight_arrival_city_1']")
	private WebElement GoingTo1;
	//leaving from locater button2 
	@FindBy(xpath="//input[@id='BE_flight_origin_city_2']")
	private WebElement Leavingfrom2;
	//going to button2
	@FindBy(xpath="//input[@id='BE_flight_arrival_city_2']")
	private WebElement GoingTo2;
	//date selection button
	@FindBy(xpath="//button[@id='BE_flight_depart_date_1']")
	private WebElement depaturButton1;
	//date selection button2
	@FindBy(xpath="//button[@id='BE_flight_depart_date_2']")
	private WebElement depaturButton2;
	//if you in crease state just add one state
	@FindBy(xpath="//a[@class='flightsAddCity']")
	private WebElement addCity;
	//travler selection
	@FindBy(xpath="//div[@id='BE_flight_paxInfoBox']")
	private WebElement traveler;
	//class selection
	@FindBy(xpath="//span[@id='flight_class_select_title']")
	private WebElement classSelection;
	//flight button
	@FindBy(xpath="//input[@id='BE_flight_flsearch_btn']")
	private WebElement flightButton;
	public WebElement getMulticity() {
		return Multicity;
	}
	public WebElement getLeavingfrom1() {
		return Leavingfrom1;
	}
	public WebElement getGoingTo1() {
		return GoingTo1;
	}
	public WebElement getLeavingfrom2() {
		return Leavingfrom2;
	}
	public WebElement getGoingTo2() {
		return GoingTo2;
	}
	public WebElement getDepaturButton1() {
		return depaturButton1;
	}
	public WebElement getDepaturButton2() {
		return depaturButton2;
	}
	public WebElement getAddCity() {
		return addCity;
	}
	public WebElement getTraveler() {
		return traveler;
	}
	public WebElement getClassSelection() {
		return classSelection;
	}
	public WebElement getFlightButton() {
		return flightButton;
	}
	
	

}
