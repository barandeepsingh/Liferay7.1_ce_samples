package ipc.event.consumer2.portlet.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessEvent;

import org.osgi.service.component.annotations.Component;

import ipc.event.consumer2.portlet.constants.IpcEventConsumer2PortletKeys;

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
		"javax.portlet.name=" + IpcEventConsumer2PortletKeys.IpcEventConsumer2,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=file;http://coe.com"
	},
	service = Portlet.class
)
public class IpcEventConsumer2Portlet extends MVCPortlet {
	private static String ROOT_FOLDER_NAME = "temp";
	private static String ROOT_FOLDER_DESCRIPTION = "Abc";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	@ProcessEvent(qname = "{http://coe.com}file")
	public void consumeMessage(EventRequest request, EventResponse response) {
		Event event = request.getEvent();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		System.out.println("Context Path "+new File(request.getContextPath().split("/")[2]+"/uploads/").getAbsolutePath());
		try {
			File file = (File) event.getValue();
			if (!file.exists()) {
				System.out.println("Empty File");
			}
			if ((file != null) && file.exists()) {
				fileUpload(themeDisplay, request,file);
				request.setAttribute("filePath", "http://localhost:8080/webdav/guest/document_library/temp/"+file.getName());
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				fr.close();

				request.setAttribute("fileData", sb.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void fileUpload(ThemeDisplay themeDisplay,EventRequest request,File file)
	{
		//UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
      
		String fileName=file.getName();		 			
		
		String description = "This file is added programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		try
	    {  
	    	Folder folder = getFolder(themeDisplay);
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
	    	InputStream is = new FileInputStream( file );
	    	DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, StringPool.BLANK, 
	    			fileName, description, "", is, file.getTotalSpace(), serviceContext); 
	    	
	     } catch (Exception e)
	    {
	       System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }

	}
	public Folder getFolder(ThemeDisplay themeDisplay){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
}