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

package com.advent.external.core.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.advent.external.core.model.Product;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
@ProviderType
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductCacheModel)) {
			return false;
		}

		ProductCacheModel productCacheModel = (ProductCacheModel)obj;

		if (productid == productCacheModel.productid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{productid=");
		sb.append(productid);
		sb.append(", groupid=");
		sb.append(groupid);
		sb.append(", companyid=");
		sb.append(companyid);
		sb.append(", userid=");
		sb.append(userid);
		sb.append(", username=");
		sb.append(username);
		sb.append(", productname=");
		sb.append(productname);
		sb.append(", productdescription=");
		sb.append(productdescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setProductid(productid);
		productImpl.setGroupid(groupid);
		productImpl.setCompanyid(companyid);
		productImpl.setUserid(userid);

		if (username == null) {
			productImpl.setUsername("");
		}
		else {
			productImpl.setUsername(username);
		}

		if (productname == null) {
			productImpl.setProductname("");
		}
		else {
			productImpl.setProductname(productname);
		}

		if (productdescription == null) {
			productImpl.setProductdescription("");
		}
		else {
			productImpl.setProductdescription(productdescription);
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productid = objectInput.readLong();

		groupid = objectInput.readLong();

		companyid = objectInput.readLong();

		userid = objectInput.readLong();
		username = objectInput.readUTF();
		productname = objectInput.readUTF();
		productdescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(productid);

		objectOutput.writeLong(groupid);

		objectOutput.writeLong(companyid);

		objectOutput.writeLong(userid);

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (productname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productname);
		}

		if (productdescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productdescription);
		}
	}

	public long productid;
	public long groupid;
	public long companyid;
	public long userid;
	public String username;
	public String productname;
	public String productdescription;
}