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

package com.advent.external.core.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
@ProviderType
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productid", getProductid());
		attributes.put("groupid", getGroupid());
		attributes.put("companyid", getCompanyid());
		attributes.put("userid", getUserid());
		attributes.put("username", getUsername());
		attributes.put("productname", getProductname());
		attributes.put("productdescription", getProductdescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productid = (Long)attributes.get("productid");

		if (productid != null) {
			setProductid(productid);
		}

		Long groupid = (Long)attributes.get("groupid");

		if (groupid != null) {
			setGroupid(groupid);
		}

		Long companyid = (Long)attributes.get("companyid");

		if (companyid != null) {
			setCompanyid(companyid);
		}

		Long userid = (Long)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String productname = (String)attributes.get("productname");

		if (productname != null) {
			setProductname(productname);
		}

		String productdescription = (String)attributes.get("productdescription");

		if (productdescription != null) {
			setProductdescription(productdescription);
		}
	}

	@Override
	public Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(Product product) {
		return _product.compareTo(product);
	}

	/**
	* Returns the companyid of this product.
	*
	* @return the companyid of this product
	*/
	@Override
	public long getCompanyid() {
		return _product.getCompanyid();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	/**
	* Returns the groupid of this product.
	*
	* @return the groupid of this product
	*/
	@Override
	public long getGroupid() {
		return _product.getGroupid();
	}

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	/**
	* Returns the productdescription of this product.
	*
	* @return the productdescription of this product
	*/
	@Override
	public String getProductdescription() {
		return _product.getProductdescription();
	}

	/**
	* Returns the productid of this product.
	*
	* @return the productid of this product
	*/
	@Override
	public long getProductid() {
		return _product.getProductid();
	}

	/**
	* Returns the productname of this product.
	*
	* @return the productname of this product
	*/
	@Override
	public String getProductname() {
		return _product.getProductname();
	}

	/**
	* Returns the userid of this product.
	*
	* @return the userid of this product
	*/
	@Override
	public long getUserid() {
		return _product.getUserid();
	}

	/**
	* Returns the username of this product.
	*
	* @return the username of this product
	*/
	@Override
	public String getUsername() {
		return _product.getUsername();
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void persist() {
		_product.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	/**
	* Sets the companyid of this product.
	*
	* @param companyid the companyid of this product
	*/
	@Override
	public void setCompanyid(long companyid) {
		_product.setCompanyid(companyid);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the groupid of this product.
	*
	* @param groupid the groupid of this product
	*/
	@Override
	public void setGroupid(long groupid) {
		_product.setGroupid(groupid);
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the productdescription of this product.
	*
	* @param productdescription the productdescription of this product
	*/
	@Override
	public void setProductdescription(String productdescription) {
		_product.setProductdescription(productdescription);
	}

	/**
	* Sets the productid of this product.
	*
	* @param productid the productid of this product
	*/
	@Override
	public void setProductid(long productid) {
		_product.setProductid(productid);
	}

	/**
	* Sets the productname of this product.
	*
	* @param productname the productname of this product
	*/
	@Override
	public void setProductname(String productname) {
		_product.setProductname(productname);
	}

	/**
	* Sets the userid of this product.
	*
	* @param userid the userid of this product
	*/
	@Override
	public void setUserid(long userid) {
		_product.setUserid(userid);
	}

	/**
	* Sets the username of this product.
	*
	* @param username the username of this product
	*/
	@Override
	public void setUsername(String username) {
		_product.setUsername(username);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public String toString() {
		return _product.toString();
	}

	@Override
	public Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Objects.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _product.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _product.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private final Product _product;
}