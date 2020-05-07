package ipc.event.consumer1.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import ipc.event.consumer1.portlet.constants.IpcEventConsumer1PortletKeys;

/**
 * @author baran
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IpcEventConsumer1PortletKeys.IpcEventConsumer1,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=email;http://coe.com" }, service = Portlet.class)
public class IpcEventConsumer1Portlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("Inside consumer1 view");
		super.doView(renderRequest, renderResponse);
	}

	@ProcessEvent(qname = "{http://coe.com}email")
	public void consumeMessage(EventRequest request, EventResponse response) {
		System.out.println("Inside consumer1");
		Event event = request.getEvent();
		String email = (String) event.getValue();
		request.setAttribute("email", email);
	}
}