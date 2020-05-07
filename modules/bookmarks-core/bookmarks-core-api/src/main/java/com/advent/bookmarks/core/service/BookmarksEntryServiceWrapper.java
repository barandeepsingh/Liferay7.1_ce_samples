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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookmarksEntryService}.
 *
 * @author baran
 * @see BookmarksEntryService
 * @generated
 */
@ProviderType
public class BookmarksEntryServiceWrapper implements BookmarksEntryService,
	ServiceWrapper<BookmarksEntryService> {
	public BookmarksEntryServiceWrapper(
		BookmarksEntryService bookmarksEntryService) {
		_bookmarksEntryService = bookmarksEntryService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookmarksEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public String helloWorld(String worldName) {
		return _bookmarksEntryService.helloWorld(worldName);
	}

	@Override
	public BookmarksEntryService getWrappedService() {
		return _bookmarksEntryService;
	}

	@Override
	public void setWrappedService(BookmarksEntryService bookmarksEntryService) {
		_bookmarksEntryService = bookmarksEntryService;
	}

	private BookmarksEntryService _bookmarksEntryService;
}