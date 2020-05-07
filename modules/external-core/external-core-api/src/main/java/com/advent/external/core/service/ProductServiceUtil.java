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

package com.advent.external.core.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Product. This utility wraps
 * {@link com.advent.external.core.service.impl.ProductServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @see com.advent.external.core.service.base.ProductServiceBaseImpl
 * @see com.advent.external.core.service.impl.ProductServiceImpl
 * @generated
 */
@ProviderType
public class ProductServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.advent.external.core.service.impl.ProductServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.advent.external.core.model.Product> getAllProducts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllProducts();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.advent.external.core.model.Product getProductById(
		long productId) {
		return getService().getProductById(productId);
	}

	public static com.advent.external.core.model.Product getProductByName(
		String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductByName(productName);
	}

	public static java.util.List<com.advent.external.core.model.Product> getProductsLike(
		String productName) {
		return getService().getProductsLike(productName);
	}

	public static String sayHelloWorld(String worldName) {
		return getService().sayHelloWorld(worldName);
	}

	public static ProductService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProductService, ProductService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProductService.class);

		ServiceTracker<ProductService, ProductService> serviceTracker = new ServiceTracker<ProductService, ProductService>(bundle.getBundleContext(),
				ProductService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}