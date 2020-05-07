package unsecure.rest.application;

import com.liferay.portal.kernel.security.auth.http.HttpAuthManagerUtil;
import com.liferay.portal.kernel.security.auth.http.HttpAuthorizationHeader;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Srikanth Reddy Sanivarapu
 * @date 25 Nov 2018
 *
 */

@Component(
	immediate = true, service = AutoLogin.class
)
public class CustomAuthAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HttpAuthorizationHeader httpAuthorizationHeader =
				HttpAuthManagerUtil.parse(request);

		if (httpAuthorizationHeader == null) {
			return null;
		}

		String scheme = httpAuthorizationHeader.getScheme();

		if (!StringUtil.equalsIgnoreCase(
				scheme, HttpAuthorizationHeader.SCHEME_BASIC)) {

			return null;
		}

		long userId = HttpAuthManagerUtil.getUserId(
			request, httpAuthorizationHeader);

		if (userId <= 0) {
			System.out.println("User id is "+userId);
			return null;
		}
		
		String[] credentials = new String[3];

		credentials[0] = String.valueOf(userId);
		credentials[1] = httpAuthorizationHeader.getAuthParameter(
			HttpAuthorizationHeader.AUTH_PARAMETER_NAME_PASSWORD);

		credentials[2] = Boolean.TRUE.toString();

		return credentials;
	}
}