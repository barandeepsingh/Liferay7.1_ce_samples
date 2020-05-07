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

package com.advent.external.core.service.http;

import aQute.bnd.annotation.ProviderType;

import com.advent.external.core.service.ProductServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ProductServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceSoap
 * @see HttpPrincipal
 * @see ProductServiceUtil
 * @generated
 */
@ProviderType
public class ProductServiceHttp {
	public static java.util.List<com.advent.external.core.model.Product> getAllProducts(
		HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getAllProducts", _getAllProductsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.advent.external.core.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.advent.external.core.model.Product getProductByName(
		HttpPrincipal httpPrincipal, String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProductByName", _getProductByNameParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					productName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.advent.external.core.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static String sayHelloWorld(HttpPrincipal httpPrincipal,
		String worldName) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"sayHelloWorld", _sayHelloWorldParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, worldName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.advent.external.core.model.Product getProductById(
		HttpPrincipal httpPrincipal, long productId) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProductById", _getProductByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, productId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.advent.external.core.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.advent.external.core.model.Product> getProductsLike(
		HttpPrincipal httpPrincipal, String productName) {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProductsLike", _getProductsLikeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					productName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.advent.external.core.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceHttp.class);
	private static final Class<?>[] _getAllProductsParameterTypes0 = new Class[] {
			
		};
	private static final Class<?>[] _getProductByNameParameterTypes1 = new Class[] {
			String.class
		};
	private static final Class<?>[] _sayHelloWorldParameterTypes2 = new Class[] {
			String.class
		};
	private static final Class<?>[] _getProductByIdParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getProductsLikeParameterTypes4 = new Class[] {
			String.class
		};
}