/**
 * 
 */
package com.app.pages;

/**
 * @author narasimhulu.sagi
 *
 */
public enum HomePage {
	HOME_BUTTON("com.climate.farmrise:id/action_home"),
	MANDI("com.climate.farmrise:id/action_prices"),
	ACCESS_WEATHER_DETAILS("com.climate.farmrise:id/checkWeatherDetails"),
	HORIZONTAL_SCROLL("android.widget.HorizontalScrollView"),
	VERIFY_HOURS("//android.widget.TextView[contains(@resource-id, 'com.climate.farmrise:id/hourlyValue') and @text='11 PM']");
	
	
	private final String homePage;
	
	 private HomePage(String homePage) {
		this.homePage = homePage;
	}
	 
	@Override
	public String toString() {
		return homePage;
	}
}
