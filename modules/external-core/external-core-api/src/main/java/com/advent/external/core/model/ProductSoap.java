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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.advent.external.core.service.http.ProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.advent.external.core.service.http.ProductServiceSoap
 * @generated
 */
@ProviderType
public class ProductSoap implements Serializable {
	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setProductid(model.getProductid());
		soapModel.setGroupid(model.getGroupid());
		soapModel.setCompanyid(model.getCompanyid());
		soapModel.setUserid(model.getUserid());
		soapModel.setUsername(model.getUsername());
		soapModel.setProductname(model.getProductname());
		soapModel.setProductdescription(model.getProductdescription());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _productid;
	}

	public void setPrimaryKey(long pk) {
		setProductid(pk);
	}

	public long getProductid() {
		return _productid;
	}

	public void setProductid(long productid) {
		_productid = productid;
	}

	public long getGroupid() {
		return _groupid;
	}

	public void setGroupid(long groupid) {
		_groupid = groupid;
	}

	public long getCompanyid() {
		return _companyid;
	}

	public void setCompanyid(long companyid) {
		_companyid = companyid;
	}

	public long getUserid() {
		return _userid;
	}

	public void setUserid(long userid) {
		_userid = userid;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getProductname() {
		return _productname;
	}

	public void setProductname(String productname) {
		_productname = productname;
	}

	public String getProductdescription() {
		return _productdescription;
	}

	public void setProductdescription(String productdescription) {
		_productdescription = productdescription;
	}

	private long _productid;
	private long _groupid;
	private long _companyid;
	private long _userid;
	private String _username;
	private String _productname;
	private String _productdescription;
}