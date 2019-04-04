/**
 * 
 */
package com.app.pages;

/**
 * @author narasimhulu.sagi
 *
 */
public enum StepsToOnBoardPage {
	LANGUAGE("//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']"),
	PROCEED("com.climate.farmrise:id/btn_Proceed"),
	AGREE_TERMS_CONDITIONS("com.climate.farmrise:id/btn_agree"),
	OK("com.climate.farmrise:id/tv_dismiss");
	
	private final String stepsToOnBoardPage;
	
	 private StepsToOnBoardPage(String stepsToOnBoardPage) {
		this.stepsToOnBoardPage = stepsToOnBoardPage;
	}
	 
	@Override
	public String toString() {
		return stepsToOnBoardPage;
	}
}
