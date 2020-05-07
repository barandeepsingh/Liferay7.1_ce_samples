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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
@ProviderType
public class ProductServiceWrapper implements ProductService,
	ServiceWrapper<ProductService> {
	public ProductServiceWrapper(ProductService productService) {
		_productService = productService;
	}

	@Override
	public java.util.List<com.advent.external.core.model.Product> getAllProducts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productService.getAllProducts();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _productService.getOSGiServiceIdentifier();
	}

	@Override
	public com.advent.external.core.model.Product getProductById(long productId) {
		return _productService.getProductById(productId);
	}

	@Override
	public com.advent.external.core.model.Product getProductByName(
		String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productService.getProductByName(productName);
	}

	@Override
	public java.util.List<com.advent.external.core.model.Product> getProductsLike(
		String productName) {
		return _productService.getProductsLike(productName);
	}

	@Override
	public String sayHelloWorld(String worldName) {
		return _productService.sayHelloWorld(worldName);
	}

	@Override
	public ProductService getWrappedService() {
		return _productService;
	}

	@Override
	public void setWrappedService(ProductService productService) {
		_productService = productService;
	}

	private ProductService _productService;
}