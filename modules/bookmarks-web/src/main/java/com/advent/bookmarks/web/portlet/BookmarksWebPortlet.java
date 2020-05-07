package com.advent.bookmarks.web.portlet;

import com.advent.bookmarks.core.model.BookmarksEntry;
import com.advent.bookmarks.core.model.BookmarksFolder;
import com.advent.bookmarks.core.service.BookmarksEntryLocalServiceUtil;
import com.advent.bookmarks.core.service.BookmarksFolderLocalServiceUtil;
import com.advent.bookmarks.web.constants.BookmarksWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author baran
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BookmarksWebPortletKeys.BookmarksWeb, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class BookmarksWebPortlet extends MVCPortlet {

//	System.out.println("Reading property from local properties " + com.advent.bookmarks.web.constants.PropsUtil.get("test.msg"));
//	System.out.println("Reading property from portal-ext.properties" + PropsUtil.get("jdbc.ext.password"));
//	
	private static final Log _log = LogFactoryUtil.getLog(BookmarksWebPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		if ("createBookmark".equalsIgnoreCase(resourceRequest.getResourceID())) {

			_log.info("Resource requesting ajax call is " + resourceRequest.getResourceID());

			String folderId = ParamUtil.getString(resourceRequest, "folderId", "");
			String name = ParamUtil.getString(resourceRequest, "entryName", "");
			String url = ParamUtil.getString(resourceRequest, "url", "");
			String status = ParamUtil.getString(resourceRequest, "status", "");
			String priority = ParamUtil.getString(resourceRequest, "priority", "");
			String parentFolderId = ParamUtil.getString(resourceRequest, "parentFolderId", "");
			String treePath = ParamUtil.getString(resourceRequest, "treePath", "");
			String lastPublishedDate = ParamUtil.getString(resourceRequest, "lastPublishedDate", "");
			String description = ParamUtil.getString(resourceRequest, "description", "");

			_log.info("treePath : " + treePath + " folderId " + folderId + " parentFolderId IS " + parentFolderId);

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			BookmarksEntry bookmarksEntry = BookmarksEntryLocalServiceUtil
					.createBookmarksEntry(CounterLocalServiceUtil.increment(BookmarksEntry.class.getName()));
			BookmarksFolder bookmarksFolder = BookmarksFolderLocalServiceUtil
					.createBookmarksFolder(CounterLocalServiceUtil.increment(BookmarksFolder.class.getName()));

			bookmarksEntry.setCompanyId(themeDisplay.getCompanyId());
			bookmarksEntry.setGroupId(themeDisplay.getCompanyGroupId());
			bookmarksEntry.setFolderId(Long.parseLong(folderId));
			bookmarksEntry.setName(name);
			bookmarksEntry.setDescription(description);
			bookmarksEntry.setUrl(url);
			bookmarksEntry.setStatus(Integer.parseInt(status));
			bookmarksEntry.setPriority(Integer.parseInt(priority));
			try {
				bookmarksEntry.setUserName(UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getFullName());
				bookmarksEntry.setUserId(themeDisplay.getUserId());
				bookmarksEntry
						.setStatusByUserName(UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getFullName());
				bookmarksEntry.setStatusByUserId(themeDisplay.getUserId());

			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Date dDate = null;
			try {

				dDate = new SimpleDateFormat("MM/dd/yyyy").parse(lastPublishedDate);

			} catch (Exception e) {
				e.printStackTrace();
			}

			bookmarksEntry.setLastPublishDate(dDate);

			BookmarksEntryLocalServiceUtil.addBookmarksEntry(bookmarksEntry);

			BookmarksFolderLocalServiceUtil.addBookmarksFolder(bookmarksFolder);

			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			_log.info("Bookmark added successfully");
			out.flush();

		} else if ("listBookmarks".equalsIgnoreCase(resourceRequest.getResourceID())) {

			_log.info("Inside list bookmarks");
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();

			out.print("<table class=\"table table-hover\">\n" + "    <thead>\n" + "      <tr>\n"
					+ "        <th>Entry Id</th>\n" + "        <th>Name</th>\n" + "        <th>Description</th>\n"
					+ "        <th>Last Published Date</th><th>Delete</th>\n" + "      </tr>\n" + "    </thead>\n"
					+ "    <tbody>\n");
			for (BookmarksEntry entry : getAllBookmarksEntry()) {
				out.print("<tr>\n" + "        <td>" + entry.getEntryId() + "</td>\n" + "        <td>" + entry.getName()
						+ "</td>\n" + "        <td>" + entry.getDescription() + "</td>\n" + "        <td>"
						+ entry.getLastPublishDate() + "</td>\n"
						+ "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"deleteBookmarkEntry("
						+ entry.getEntryId() + ")\">Delete</button></td>      </tr>\n" + "      ");
			}

			out.print("</tbody></table>");
			out.flush();
		} else if ("deleteBookmark".equalsIgnoreCase(resourceRequest.getResourceID())) {

			_log.info("Inside delete entry");
			String entryId = ParamUtil.getString(resourceRequest, "entryId", "");
			_log.info("Entry to delete is " + entryId);

		}
	}

	private List<BookmarksEntry> getAllBookmarksEntry() {
		return BookmarksEntryLocalServiceUtil.getBookmarksEntries(0,
				BookmarksEntryLocalServiceUtil.getBookmarksEntriesCount());
	}

	private List<BookmarksFolder> getAllBookmarksFolder() {
		return BookmarksFolderLocalServiceUtil.getBookmarksFolders(0,
				BookmarksFolderLocalServiceUtil.getBookmarksFoldersCount());
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {

			URL url = new URL("https://restcountries.eu/rest/v2/region/Asia?fields=name");// your url i.e fetch data
																							// from .
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				_log.info(output);
			}
			conn.disconnect();

			/*
			 * final JSONObject obj = JSONFactoryUtil.createJSONObject(output); final
			 * JSONArray geodata = obj.getJSONArray(""); final int n = geodata.length(); for
			 * (int i = 0; i < n; ++i) { final JSONObject person = geodata.getJSONObject(i);
			 * _log.info(person.getInt("name"));
			 * 
			 * }
			 */

		} catch (Exception e) {
			_log.error("Exception in NetClientGet:- " + e.getMessage());
		}

		_log.info("Inside view ");

		super.doView(renderRequest, renderResponse);
	}
}
