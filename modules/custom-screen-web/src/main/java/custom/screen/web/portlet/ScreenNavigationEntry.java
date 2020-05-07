package custom.screen.web.portlet;

import com.liferay.portal.kernel.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ScreenNavigationEntry<T> {
public String getCategoryKey();
public String getEntryKey();
public String getLabel();
public String getScreenNavigationKey();
public String isVisible(User user, T screenModelBean);
public String render(HttpServletRequest request, HttpServletResponse response);
}
