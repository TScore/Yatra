package com.Yatra.automationscript;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yatra.dblayer.Exceldatamanager;
import com.Yatra.objectrepositroy.SighinInLocater;
import com.Yatra.objectrepositroy.SighinUpData;
import com.Yatra.utilites.BussenesCompernat;
import com.Yatra.utilites.PropertyHandler;
import com.Yatra.utilites.YatraAbstract;
import com.Yatra.utilites.Yatradriver;

public class SighinIn extends YatraAbstract {
	//load log4j class
	private static Logger Log = Logger.getLogger(SighinIn.class.getName());
	//create object of Baseness comperanet  class and give it name util
	BussenesCompernat util=new BussenesCompernat();
	//load excel operation
	Exceldatamanager excelmangaer=new Exceldatamanager();
	private SighinUpData sighinUpData=null;
	private SighinInLocater sighinInLocater=null;
	@BeforeClass
	public void openBrowser(){
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		Log.info("openFireFox");
		util.getfirefox();
		Log.info("url load");
		Yatradriver.Driver.get(PropertyHandler.getProperty("URL"));
		Yatradriver.Driver.manage().window().maximize();
		Yatradriver.Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		excelmangaer.copyData();
	}
	@BeforeMethod
	public void loadObjectTest() throws InvalidFormatException, IOException{
		//load SighinUpData locater
		sighinUpData=loadObject(new SighinUpData());
		//load SighinInLocater
		sighinInLocater=loadObject(new SighinInLocater());
		
	}
	@Test
	public void SighinInTest() {
		util.getLogin();
		String name=Yatradriver.Driver.findElement(By.id("userShowName")).getText();
		Log.info("sigh in usear name:"+name);
		try {
			excelmangaer.setExcelStringData(1, 1, 3, name);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		util.checkAlert();
	}
	@AfterMethod
	public void sighOutTest(){
		util.takeScreenShot("SighIN");
	}
	@AfterClass
	public void qiutApplicationTest(){
		Yatradriver.Driver.quit();
	}
	}
