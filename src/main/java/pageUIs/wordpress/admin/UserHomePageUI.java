package pageUIs.wordpress.admin;

public class UserHomePageUI {
	
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/ancestor::article//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//a[text()='%s']";
	public static final String SEARCH_TEXTBOX_BY_NAME = "xpath=//button[@aria-label='Search']/preceding-sibling::input";
	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";

}
