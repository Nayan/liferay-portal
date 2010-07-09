/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.portal.cluster.cluster1.Cluster1aTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1bTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1cTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1dTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1eTests;
import com.liferay.portalweb.portal.login.LoginTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class Cluster1TestSuite extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Cluster1aTests.suite());
		testSuite.addTest(Cluster1bTests.suite());
		testSuite.addTest(Cluster1cTests.suite());
		testSuite.addTest(Cluster1dTests.suite());
		testSuite.addTest(Cluster1eTests.suite());

		return testSuite;
	}

}