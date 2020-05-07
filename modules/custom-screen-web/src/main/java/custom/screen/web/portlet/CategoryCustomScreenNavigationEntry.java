package custom.screen.web.portlet;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    property = {
	      "screen.navigation.category.order:Integer=1",
	      "screen.navigation.entry.order:Integer=1"
	    },
	    service = {ScreenNavigationCategory.class, ScreenNavigationEntry.class}
	)
public class CategoryCustomScreenNavigationEntry implements ScreenNavigationCategory,ScreenNavigationEntry{
	@Override
	public String getCategoryKey() {
	    return "custom-screen";
	}

	@Override
	public String getEntryKey() {
	    return "custom-screen";
	}

	@Override
	public String getLabel(Locale locale) {
	    return LanguageUtil.get(locale, "custom-screen");
	}

	@Override
	public String getScreenNavigationKey() {
	    return AssetCategoriesConstants.CATEGORY_KEY_GENERAL;
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response)
	    throws IOException {

	   _jspRenderer.renderJSP(request, response, "/category/custom-screen.jsp");
	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	@Override
	public String isVisible(User user, Object screenModelBean) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
