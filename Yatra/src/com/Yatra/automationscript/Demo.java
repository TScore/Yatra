package com.Yatra.automationscript;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Yatra.utilites.BussenesCompernat;
import com.Yatra.utilites.Yatradriver;

public class Demo {
	@Test
	public void TakeScreenShoot(){
		BussenesCompernat util=new BussenesCompernat();
		//FirefoxDriver driver = new FirefoxDriver();
		util.getfirefox();
		Yatradriver.Driver.get("https://www.google.co.in/");
		//util.takeScreenShot("google.png");
		File screenShotFile = ((FirefoxDriver) Yatradriver.Driver).getScreenshotAs(OutputType.FILE);
		screenShotFile.renameTo(new File("E:\\workplace\\Yatra\\reportlayer\\ScrenShoot\\testName1.png").getAbsoluteFile());
	}

}