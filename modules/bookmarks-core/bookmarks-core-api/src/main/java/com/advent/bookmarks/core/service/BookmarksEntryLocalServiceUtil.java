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
 * Provides the local service utility for BookmarksEntry. This utility wraps
 * {@link com.advent.bookmarks.core.service.impl.BookmarksEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author baran
 * @see BookmarksEntryLocalService
 * @see com.advent.bookmarks.core.service.base.BookmarksEntryLocalServiceBaseImpl
 * @see com.advent.bookmarks.core.service.impl.BookmarksEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class BookmarksEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.advent.bookmarks.core.service.impl.BookmarksEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bookmarks entry to the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarksEntry the bookmarks entry
	* @return the bookmarks entry that was added
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry addBookmarksEntry(
		com.advent.bookmarks.core.model.BookmarksEntry bookmarksEntry) {
		return getService().addBookmarksEntry(bookmarksEntry);
	}

	/**
	* Creates a new bookmarks entry with the primary key. Does not add the bookmarks entry to the database.
	*
	* @param entryId the primary key for the new bookmarks entry
	* @return the new bookmarks entry
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry createBookmarksEntry(
		long entryId) {
		return getService().createBookmarksEntry(entryId);
	}

	/**
	* Deletes the bookmarks entry from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarksEntry the bookmarks entry
	* @return the bookmarks entry that was removed
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry deleteBookmarksEntry(
		com.advent.bookmarks.core.model.BookmarksEntry bookmarksEntry) {
		return getService().deleteBookmarksEntry(bookmarksEntry);
	}

	/**
	* Deletes the bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the bookmarks entry
	* @return the bookmarks entry that was removed
	* @throws PortalException if a bookmarks entry with the primary key could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry deleteBookmarksEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBookmarksEntry(entryId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.advent.bookmarks.core.model.BookmarksEntry fetchBookmarksEntry(
		long entryId) {
		return getService().fetchBookmarksEntry(entryId);
	}

	/**
	* Returns the bookmarks entry matching the UUID and group.
	*
	* @param uuid the bookmarks entry's UUID
	* @param groupId the primary key of the group
	* @return the matching bookmarks entry, or <code>null</code> if a matching bookmarks entry could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry fetchBookmarksEntryByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchBookmarksEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the bookmarks entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.advent.bookmarks.core.model.impl.BookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks entries
	* @param end the upper bound of the range of bookmarks entries (not inclusive)
	* @return the range of bookmarks entries
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksEntry> getBookmarksEntries(
		int start, int end) {
		return getService().getBookmarksEntries(start, end);
	}

	/**
	* Returns all the bookmarks entries matching the UUID and company.
	*
	* @param uuid the UUID of the bookmarks entries
	* @param companyId the primary key of the company
	* @return the matching bookmarks entries, or an empty list if no matches were found
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksEntry> getBookmarksEntriesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService()
				   .getBookmarksEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of bookmarks entries matching the UUID and company.
	*
	* @param uuid the UUID of the bookmarks entries
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of bookmarks entries
	* @param end the upper bound of the range of bookmarks entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching bookmarks entries, or an empty list if no matches were found
	*/
	public static java.util.List<com.advent.bookmarks.core.model.BookmarksEntry> getBookmarksEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.advent.bookmarks.core.model.BookmarksEntry> orderByComparator) {
		return getService()
				   .getBookmarksEntriesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of bookmarks entries.
	*
	* @return the number of bookmarks entries
	*/
	public static int getBookmarksEntriesCount() {
		return getService().getBookmarksEntriesCount();
	}

	/**
	* Returns the bookmarks entry with the primary key.
	*
	* @param entryId the primary key of the bookmarks entry
	* @return the bookmarks entry
	* @throws PortalException if a bookmarks entry with the primary key could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry getBookmarksEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBookmarksEntry(entryId);
	}

	/**
	* Returns the bookmarks entry matching the UUID and group.
	*
	* @param uuid the bookmarks entry's UUID
	* @param groupId the primary key of the group
	* @return the matching bookmarks entry
	* @throws PortalException if a matching bookmarks entry could not be found
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry getBookmarksEntryByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBookmarksEntryByUuidAndGroupId(uuid, groupId);
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
	* Updates the bookmarks entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookmarksEntry the bookmarks entry
	* @return the bookmarks entry that was updated
	*/
	public static com.advent.bookmarks.core.model.BookmarksEntry updateBookmarksEntry(
		com.advent.bookmarks.core.model.BookmarksEntry bookmarksEntry) {
		return getService().updateBookmarksEntry(bookmarksEntry);
	}

	public static BookmarksEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BookmarksEntryLocalService, BookmarksEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BookmarksEntryLocalService.class);

		ServiceTracker<BookmarksEntryLocalService, BookmarksEntryLocalService> serviceTracker =
			new ServiceTracker<BookmarksEntryLocalService, BookmarksEntryLocalService>(bundle.getBundleContext(),
				BookmarksEntryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}