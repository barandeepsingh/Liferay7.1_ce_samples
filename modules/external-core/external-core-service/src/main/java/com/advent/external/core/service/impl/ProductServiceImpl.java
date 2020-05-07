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

package com.advent.external.core.service.impl;

import com.advent.external.core.model.Product;
import com.advent.external.core.model.impl.ProductImpl;
import com.advent.external.core.service.ProductLocalServiceUtil;
import com.advent.external.core.service.base.ProductServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The implementation of the product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.advent.external.core.service.ProductService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceBaseImpl
 * @see com.advent.external.core.service.ProductServiceUtil
 */
public class ProductServiceImpl extends ProductServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.advent.external.core.service.ProductServiceUtil} to access the product
	 * remote service.
	 */

	private final Logger _log = LoggerFactory.getLogger(this.getClass());

	public List<Product> getAllProducts() throws SystemException {
		return ProductLocalServiceUtil.getProducts(0, ProductLocalServiceUtil.getProductsCount());
	}

	public Product getProductByName(String productName) throws SystemException {
		return ProductLocalServiceUtil.getProductByName(productName);
	}

	public String sayHelloWorld(String worldName) {
		return "Hello world: " + worldName;
	}

	public Product getProductById(long productId) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ProductImpl.class, "product");
		Product product = new ProductImpl();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("product.productid", productId));
		// dynamicQuery.setProjection(PropertyFactoryUtil.forName("productname"));

		try {
			product = (Product) ProductLocalServiceUtil.dynamicQuery(dynamicQuery).get(0);
			_log.info("Found product ");
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		return product;
	}

	public List<Product> getProductsLike(String productName) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ProductImpl.class);
		List<Product> products = new ArrayList<>();

		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.like("productname", '%' + productName + '%');
		//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("productname", "%"));
		//criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("productname", "%"));
		dynamicQuery.add(criterion);

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property("productid"));
		projectionList.add(ProjectionFactoryUtil.property("productdescription"));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("productid"));
		dynamicQuery.setProjection(projectionList);

		try {
			products = ProductLocalServiceUtil.dynamicQuery(dynamicQuery);
			_log.info("Total products are " + products.size());
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		return products;
	}
}