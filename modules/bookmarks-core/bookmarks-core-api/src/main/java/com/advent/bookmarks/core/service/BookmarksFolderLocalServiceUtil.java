/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.advent.bookmarks.core.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for BookmarksFolder. This utility wraps
 * {@link com.advent.bookmarks.core.service.impl.BookmarksFolderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author baran
 * @see BookmarksFolderLocalService
 * @see com.advent.bookmarks.core.service.base.BookmarksFolderLocalServiceBaseImpl
 * @see com.advent.bookmarks.core.service.impl.BookmarksFolderLocalServiceImpl
 * @generated
 */
@ProviderType
public class BookmarksFolderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.advent.bookmarks.core.service.impl.BookmarksFolderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bookmarks folder to the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarksFolder the bookmarks folder
	* @return the bookmarks folder that was added
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder addBookmarksFolder(
		com.advent.bookmarks.core.model.BookmarksFolder bookmarksFolder) {
		return getService().addBookmarksFolder(bookmarksFolder);
	}

	/**
	* Creates a new bookmarks folder with the primary key. Does not add the bookmarks folder to the database.
	*
	* @param folderId the primary key for the new bookmarks folder
	* @return the new bookmarks folder
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder createBookmarksFolder(
		long folderId) {
		return getService().createBookmarksFolder(folderId);
	}

	/**
	* Deletes the bookmarks folder from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarksFolder the bookmarks folder
	* @return the bookmarks folder that was removed
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder deleteBookmarksFolder(
		com.advent.bookmarks.core.model.BookmarksFolder bookmarksFolder) {
		return getService().deleteBookmarksFolder(bookmarksFolder);
	}

	/**
	* Deletes the bookmarks folder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param folderId the primary key of the bookmarks folder
	* @return the bookmarks folder that was removed
	* @throws PortalException if a bookmarks folder with the primary key could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder deleteBookmarksFolder(
		long folderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBookmarksFolder(folderId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.advent.bookmarks.core.model.BookmarksFolder fetchBookmarksFolder(
		long folderId) {
		return getService().fetchBookmarksFolder(folderId);
	}

	/**
	* Returns the bookmarks folder matching the UUID and group.
	*
	* @param uuid the bookmarks folder's UUID
	* @param groupId the primary key of the group
	* @return the matching bookmarks folder, or <code>null</code> if a matching bookmarks folder could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder fetchBookmarksFolderByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchBookmarksFolderByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the bookmarks folder with the primary key.
	*
	* @param folderId the primary key of the bookmarks folder
	* @return the bookmarks folder
	* @throws PortalException if a bookmarks folder with the primary key could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder getBookmarksFolder(
		long folderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBookmarksFolder(folderId);
	}

	/**
	* Returns the bookmarks folder matching the UUID and group.
	*
	* @param uuid the bookmarks folder's UUID
	* @param groupId the primary key of the group
	* @return the matching bookmarks folder
	* @throws PortalException if a matching bookmarks folder could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder getBookmarksFolderByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBookmarksFolderByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the bookmarks folders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks folders
	* @param end the upper bound of the range of bookmarks folders (not inclusive)
	* @return the range of bookmarks folders
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksFolder> getBookmarksFolders(
		int start, int end) {
		return getService().getBookmarksFolders(start, end);
	}

	/**
	* Returns all the bookmarks folders matching the UUID and company.
	*
	* @param uuid the UUID of the bookmarks folders
	* @param companyId the primary key of the company
	* @return the matching bookmarks folders, or an empty list if no matches were found
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksFolder> getBookmarksFoldersByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService()
				   .getBookmarksFoldersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of bookmarks folders matching the UUID and company.
	*
	* @param uuid the UUID of the bookmarks folders
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of bookmarks folders
	* @param end the upper bound of the range of bookmarks folders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching bookmarks folders, or an empty list if no matches were found
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksFolder> getBookmarksFoldersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.advent.bookmarks.core.model.BookmarksFolder> orderByComparator) {
		return getService()
				   .getBookmarksFoldersByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of bookmarks folders.
	*
	* @return the number of bookmarks folders
	*/
	public static int getBookmarksFoldersCount() {
		return getService().getBookmarksFoldersCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the bookmarks folder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookmarksFolder the bookmarks folder
	* @return the bookmarks folder that was updated
	*/
	public static com.advent.bookmarks.core.model.BookmarksFolder updateBookmarksFolder(
		com.advent.bookmarks.core.model.BookmarksFolder bookmarksFolder) {
		return getService().updateBookmarksFolder(bookmarksFolder);
	}

	public static BookmarksFolderLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BookmarksFolderLocalService, BookmarksFolderLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BookmarksFolderLocalService.class);

		ServiceTracker<BookmarksFolderLocalService, BookmarksFolderLocalService> serviceTracker =
			new ServiceTracker<BookmarksFolderLocalService, BookmarksFolderLocalService>(bundle.getBundleContext(),
				BookmarksFolderLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}