package ipc.producer.event.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

import ipc.producer.event.web.constants.ProducerEventPortletKeys;

/**
 * @author baran
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProducerEventPortletKeys.ProducerEvent,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=email;http://coe.com",
		"javax.portlet.supported-publishing-event=file;http://coe.com" }, service = Portlet.class)
public class ProducerEventPortlet extends MVCPortlet {
	@ProcessAction(name = "producer")
	public void producer(ActionRequest request, ActionResponse response) {
		String email = ParamUtil.getString(request, "email");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		// String title = ParamUtil.getString(uploadPortletRequest, "title");
		File file = uploadPortletRequest.getFile("uploadFile");
		QName emailQName = new QName("http://coe.com", "email");
		QName fileQName = new QName("http://coe.com", "file");
		response.setEvent(emailQName, email);
		response.setEvent(fileQName, file);
	}
}