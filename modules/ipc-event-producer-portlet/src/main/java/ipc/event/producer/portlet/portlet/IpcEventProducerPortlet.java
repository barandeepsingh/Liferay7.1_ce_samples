package ipc.event.producer.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

import ipc.event.producer.portlet.constants.IpcEventProducerPortletKeys;

/**
 * @author baran
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IpcEventProducerPortletKeys.IpcEventProducer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=file;http://coe.com",
		"javax.portlet.supported-publishing-event=email;http://coe.com"
	},
	service = Portlet.class
)
public class IpcEventProducerPortlet extends MVCPortlet {
	@ProcessAction(name = "producer")
	public void producer(ActionRequest request, ActionResponse response) throws IOException {
		String email = ParamUtil.getString(request, "email");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		// String title = ParamUtil.getString(uploadPortletRequest, "title");
		File file = uploadPortletRequest.getFile("uploadFile");
		QName emailQName = new QName("http://coe.com", "email");
		response.setEvent(emailQName, email);
		
		QName fileQName = new QName("http://coe.com", "file");
		response.setEvent(fileQName, file);
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		String pageName="/prp-ipc";
//		String portletName = "ipceventconsumer1_INSTANCE_DNPdmcKI1Fbi";
//		long plid = 0L;
//		try {
//		 plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, pageName).getPlid();
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		
//		
//
//PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),portletName,plid,    PortletRequest.RENDER_PHASE);
//	//	redirectURL.setParameter("data", "This Value Comes From Welcome Page"); // set required parameter that you need in doView of another Portlet
//		response.sendRedirect(redirectURL.toString()); 
//		
//		
		
		
	}
}