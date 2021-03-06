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

package com.advent.external.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.advent.external.core.exception.NoSuchProductException;
import com.advent.external.core.model.Product;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.advent.external.core.service.persistence.impl.ProductPersistenceImpl
 * @see ProductUtil
 * @generated
 */
@ProviderType
public interface ProductPersistence extends BasePersistence<Product> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the product in the entity cache if it is enabled.
	*
	* @param product the product
	*/
	public void cacheResult(Product product);

	/**
	* Caches the products in the entity cache if it is enabled.
	*
	* @param products the products
	*/
	public void cacheResult(java.util.List<Product> products);

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param productid the primary key for the new product
	* @return the new product
	*/
	public Product create(long productid);

	/**
	* Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productid the primary key of the product
	* @return the product that was removed
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product remove(long productid) throws NoSuchProductException;

	public Product updateImpl(Product product);

	/**
	* Returns the product with the primary key or throws a {@link NoSuchProductException} if it could not be found.
	*
	* @param productid the primary key of the product
	* @return the product
	* @throws NoSuchProductException if a product with the primary key could not be found
	*/
	public Product findByPrimaryKey(long productid)
		throws NoSuchProductException;

	/**
	* Returns the product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productid the primary key of the product
	* @return the product, or <code>null</code> if a product with the primary key could not be found
	*/
	public Product fetchByPrimaryKey(long productid);

	@Override
	public java.util.Map<java.io.Serializable, Product> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the products.
	*
	* @return the products
	*/
	public java.util.List<Product> findAll();

	/**
	* Returns a range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of products
	*/
	public java.util.List<Product> findAll(int start, int end);

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of products
	*/
	public java.util.List<Product> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator);

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of products
	*/
	public java.util.List<Product> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the products from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of products.
	*
	* @return the number of products
	*/
	public int countAll();
}