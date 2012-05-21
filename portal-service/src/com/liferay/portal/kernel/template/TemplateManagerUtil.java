/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.template;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tina Tian
 * @author Raymond Augé
 */
public class TemplateManagerUtil {

	public static void clearCache(String templateManagerName)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		templateManager.clearCache();
	}

	public static void clearCache(String templateManagerName, String templateId)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		templateManager.clearCache(templateId);
	}

	public static void destroy() {
		for (TemplateManager templateManager :
				_getTemplateManagers().values()) {

			templateManager.destroy();
		}

		_getTemplateManagers().clear();
	}

	public static Template getTemplate(
			String templateManagerName, String templateId,
			String templateContent, String errorTemplateId,
			String errorTemplateContent,
			TemplateContextType templateContextType)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		return templateManager.getTemplate(
			templateId, templateContent, errorTemplateId, errorTemplateContent,
			templateContextType);
	}

	public static Template getTemplate(
			String templateManagerName, String templateId,
			String templateContent, String errorTemplateId,
			TemplateContextType templateContextType)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		return templateManager.getTemplate(
			templateId, templateContent, errorTemplateId, templateContextType);
	}

	public static Template getTemplate(
			String templateManagerName, String templateId,
			String templateContent, TemplateContextType templateContextType)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		return templateManager.getTemplate(
			templateId, templateContent, templateContextType);
	}

	public static Template getTemplate(
			String templateManagerName, String templateId,
			TemplateContextType templateContextType)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		return templateManager.getTemplate(templateId, templateContextType);
	}

	public static TemplateManager getTemplateManager(
		String templateManagerName) {

		return _getTemplateManagers().get(templateManagerName);
	}

	public static Set<String> getTemplateManagerNames(
		String templateManagerName) {

		return _getTemplateManagers().keySet();
	}

	public static Map<String, TemplateManager> getTemplateManagers() {
		return Collections.unmodifiableMap(_getTemplateManagers());
	}

	public static boolean hasTemplate(
			String templateManagerName, String templateId)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManager(
			templateManagerName);

		return templateManager.hasTemplate(templateId);
	}

	public static boolean hasTemplateManager(String templateManagerName) {
		return _getTemplateManagers().containsKey(templateManagerName);
	}

	public static void init() throws TemplateException {
		for (TemplateManager templateManager :
				_getTemplateManagers().values()) {

			templateManager.init();
		}
	}

	public static void registerTemplateManager(TemplateManager templateManager)
		throws TemplateException {

		templateManager.init();

		_getTemplateManagers().put(
			templateManager.getTemplateManagerName(), templateManager);
	}

	public static void unregisterTemplateManager(String templateManagerName) {
		TemplateManager templateManager = _getTemplateManagers().remove(
			templateManagerName);

		if (templateManager != null) {
			templateManager.destroy();
		}
	}

	public void setTemplateManagers(List<TemplateManager> templateManagers) {
		PortalRuntimePermission.checkSetBeanProperty(getClass());

		Map<String, TemplateManager> _templateManagers = _getTemplateManagers();

		for (TemplateManager templateManager : templateManagers) {
			_templateManagers.put(
				templateManager.getTemplateManagerName(), templateManager);
		}
	}

	private static TemplateManager _getTemplateManager(
			String templateManagerName)
		throws TemplateException {

		TemplateManager templateManager = _getTemplateManagers().get(
			templateManagerName);

		if (templateManager == null) {
			throw new TemplateException(
				"Unsupported template manager " + templateManagerName);
		}

		return templateManager;
	}

	private static Map<String, TemplateManager> _getTemplateManagers() {
		PortalRuntimePermission.checkGetBeanProperty(TemplateManagerUtil.class);

		return _templateManagers;
	}

	private static Map<String, TemplateManager> _templateManagers =
		new ConcurrentHashMap<String, TemplateManager>();

}