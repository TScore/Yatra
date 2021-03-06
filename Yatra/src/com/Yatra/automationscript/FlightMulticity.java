package com.Yatra.automationscript;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yatra.dblayer.Exceldatamanager;
import com.Yatra.objectrepositroy.FlightOneWayLocater;
import com.Yatra.utilites.BussenesCompernat;
import com.Yatra.utilites.PropertyHandler;
import com.Yatra.utilites.YatraAbstract;
import com.Yatra.utilites.Yatradriver;

public class FlightMulticity extends YatraAbstract  {
	//load log4j class
	private static Logger Log = Logger.getLogger(FlightTowWay.class.getName());
	//creat object of util class
	BussenesCompernat util=new BussenesCompernat();
	//load excel operation
	Exceldatamanager excelmangaer=new Exceldatamanager();
	private FlightOneWayLocater flightOneWayLocater=null;
	private String moth ,date=null;
	
	@BeforeClass
	public void openUrl(){
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		Log.info("openFireFox");
		util.getChrome();
		//util.getfirefox();
		Log.info("url load");
		Yatradriver.Driver.get(PropertyHandler.getProperty("URL"));
		Yatradriver.Driver.manage().window().maximize();
		Yatradriver.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		excelmangaer.copyData();
	}
	@BeforeMethod
	public void lodLocaterTest(){
		flightOneWayLocater=loadObject(new FlightOneWayLocater());
	}
	@Test
	public void FlightTowWayTest(){
	
			flightOneWayLocater.getFlight().click();
			Log.info("chake 2 botten click ya not ");
			if(flightOneWayLocater.getSubflight().isEnabled()){
				Log.info("all rady clicked");
				System.out.println("all rady selected");
			}
			else
			{	
				Log.info("if not selcted just click that one");
				flightOneWayLocater.getSubflight().click();
			}
	}
	@AfterMethod
	public void sighOut(){
		util.getScreenShot("FlightOneWay.png");
	}
	@AfterClass
	public void quitBrowserTest(){
		Log.info("quit the Browser");
		Yatradriver.Driver.quit();
	}
}