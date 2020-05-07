package custom.screen.web.portlet;

import java.util.Locale;

public interface ScreenNavigationCategory {
	public String getCategoryKey();

	public String getLabel(Locale locale);

	public String getScreenNavigationKey();

}
