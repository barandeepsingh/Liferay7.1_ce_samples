package external.web.portlet;

import external.web.constants.ExternalWebPortletKeys;

import com.advent.external.core.model.Product;
import com.advent.external.core.service.ProductLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.name=" + ExternalWebPortletKeys.ExternalWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ExternalWebPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		List<Product> productList = ProductLocalServiceUtil.getProducts(0,ProductLocalServiceUtil.getProductsCount());
		
		for(Product product: productList) {
		System.out.println(product.getProductid()+" "+ product.getProductname()+" "+product.getUsername());	
		}
		
		super.doView(renderRequest, renderResponse);
	}
}