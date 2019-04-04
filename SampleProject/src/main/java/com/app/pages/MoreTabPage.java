/**
 * 
 */
package com.app.pages;

/**
 * @author narasimhulu.sagi
 *
 */
public enum MoreTabPage {
	
	MORE_BUTTON("com.climate.farmrise:id/action_more"),
	GOVERNMENT_SCHEMES_LINK("com.climate.farmrise:id/more_govtSchemes"),
	VERTICAL_SCROLL("android.widget.FrameLayout"),
	SEARCH("android:id/search_button"),
	VERIFY_TEXT("//android.widget.TextView[@text='Weather Based Crop Insurance Scheme (WBCIS) ']");
	private final String moreTabPage;
	
	 private MoreTabPage(String moreTabPage) {
		this.moreTabPage = moreTabPage;
	}
	 
	@Override
	public String toString() {
		return moreTabPage;
	}
}
