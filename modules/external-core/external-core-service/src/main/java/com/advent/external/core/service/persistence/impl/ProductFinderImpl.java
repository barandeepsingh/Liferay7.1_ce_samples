package com.advent.external.core.service.persistence.impl;

import com.advent.external.core.model.Product;
import com.advent.external.core.model.impl.ProductImpl;
import com.advent.external.core.service.persistence.ProductFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductFinderImpl extends ProductFinderBaseImpl implements ProductFinder {
	private final Logger _log = LoggerFactory.getLogger(this.getClass());
	public static final String FIND_BY_PRODUCT_NAME_SQL = "SELECT * from Product WHERE productname=?";

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public Product findByProductName(String productName) {

		Session session = null;
		try {
			session = openSession();
			
			_log.info("Query  is : " + FIND_BY_PRODUCT_NAME_SQL);
			SQLQuery q = session.createSQLQuery(FIND_BY_PRODUCT_NAME_SQL);
			q.setCacheable(false);
			q.addEntity("Product", ProductImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(productName);

			return (Product) q.list().get(0);
			// return (List<Task>) QueryUtil.list(q,getDialect(),start, end); for pagination
			// feature

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}

}
