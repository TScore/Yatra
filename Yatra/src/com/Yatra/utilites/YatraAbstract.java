package com.Yatra.utilites;
import org.openqa.selenium.support.PageFactory;
// abstract class to initialize the page factory classes
public abstract class YatraAbstract {
//generic method to initialize the page factory class 
@SuppressWarnings("unchecked")
public <T> T loadObject(T t){
	return (T) PageFactory.initElements(Yatradriver.Driver, t.getClass());
}
}
