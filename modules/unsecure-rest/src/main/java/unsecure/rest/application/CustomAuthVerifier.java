package unsecure.rest.application;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.AccessControlContext;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    property = {
	        "auth.verifier.CustomAuthVerifier.urls.includes=*"
	    }
	)
public class CustomAuthVerifier extends CustomAuthAutoLogin implements AuthVerifier{

public static final String AUTH_TYPE = HttpServletRequest.FORM_AUTH;
	
	@Override
	public String getAuthType() {
		return AUTH_TYPE;
	}

	@Override
	public AuthVerifierResult verify(AccessControlContext accessControlContext, Properties properties)
			throws AuthException {
		AuthVerifierResult authVerifierResult = new AuthVerifierResult();
		
		try {
			String[] credentials = doLogin(
					accessControlContext.getRequest(),
					accessControlContext.getResponse());

			if (credentials != null) {
				authVerifierResult.setPassword(credentials[1]);
				authVerifierResult.setPasswordBasedAuthentication(true);
				authVerifierResult.setState(AuthVerifierResult.State.SUCCESS);
				authVerifierResult.setUserId(Long.valueOf(credentials[0]));
			} else {
				try {
					User user = PortalUtil.getUser(accessControlContext.getRequest());
					if ((user == null) || user.isDefaultUser()) {
						authVerifierResult.setState(AuthVerifierResult.State.INVALID_CREDENTIALS);
					} else {
						authVerifierResult.setState(AuthVerifierResult.State.SUCCESS);
						authVerifierResult.setUserId(user.getUserId());
					}
				} catch (Exception ex) {
					authVerifierResult.setState(AuthVerifierResult.State.INVALID_CREDENTIALS);
				}
			}
			
			return authVerifierResult;
			
		} catch (Exception e) {
			authVerifierResult.setState(AuthVerifierResult.State.INVALID_CREDENTIALS);
			return authVerifierResult;
		} 		
	}

}
