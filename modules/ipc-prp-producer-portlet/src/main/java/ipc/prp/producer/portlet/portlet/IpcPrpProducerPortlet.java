package ipc.prp.producer.portlet.portlet;

import ipc.prp.producer.portlet.constants.IpcPrpProducerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

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
		"javax.portlet.name=" + IpcPrpProducerPortletKeys.IpcPrpProducer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=email" 
	},
	service = Portlet.class
)
public class IpcPrpProducerPortlet extends MVCPortlet {
	@ProcessAction(name = "producer")
	public void producer(ActionRequest request, ActionResponse response) {
		String email = ParamUtil.getString(request, "email");
		response.setRenderParameter("email", email);
	}
}