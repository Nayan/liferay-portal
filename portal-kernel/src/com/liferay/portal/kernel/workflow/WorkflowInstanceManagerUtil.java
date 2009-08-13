/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.kernel.workflow;

import java.util.List;
import java.util.Map;

/**
 * <a href="WorkflowInstanceManagerUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * <p>
 * The utility class supporting static access to all methods for the
 * {@link WorkflowInstanceManager} interface. The target manager object is
 * injected using the
 * {@link #setWorkflowInstanceManager(WorkflowInstanceManager)} method. Besides
 * the static method access, it is also available through
 * {@link #getWorkflowInstanceManager()}.
 * </p>
 * 
 * @author Micha Kiener
 * 
 */
public class WorkflowInstanceManagerUtil {

	
	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#addContextInformation(long,
	 *      java.util.Map)
	 */
	public static WorkflowInstanceInfo addContextInformation(
		long workflowInstanceId, Map<String, Object> context)
		throws WorkflowException {
		return _workflowInstanceManager.addContextInformation(
			workflowInstanceId, context);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getPossibleNextActivityNames(long,
	 *      long)
	 */
	public static List<String> getPossibleNextActivityNames(
		long workflowInstanceId, long userId)
		throws WorkflowException {
		return _workflowInstanceManager.getPossibleNextActivityNames(
			workflowInstanceId, userId);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceHistory(long,
	 *      boolean)
	 */
	public static List<WorkflowInstanceHistory> getWorkflowInstanceHistory(
		long workflowInstanceId, boolean includeChildren)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceHistory(
			workflowInstanceId, includeChildren);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceInfo(long,
	 *      boolean)
	 */
	public static WorkflowInstanceInfo getWorkflowInstanceInfo(
		long workflowInstanceId, boolean retrieveChildrenInfo)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceInfo(
			workflowInstanceId, retrieveChildrenInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceInfo(java.lang.String,
	 *      long, boolean)
	 */
	public static WorkflowInstanceInfo getWorkflowInstanceInfo(
		String relationType, long relationId, boolean retrieveChildrenInfo)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceInfo(
			relationType, relationId, retrieveChildrenInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceInfos(java.lang.String,
	 *      java.lang.Integer, boolean, boolean)
	 */
	public static List<WorkflowInstanceInfo> getWorkflowInstanceInfos(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		boolean finished, boolean retrieveChildrenInfo)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceInfos(
			workflowDefinitionName, workflowDefinitionVersion, finished,
			retrieveChildrenInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceInfos(java.lang.String,
	 *      java.lang.Integer, boolean)
	 */
	public static List<WorkflowInstanceInfo> getWorkflowInstanceInfos(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		boolean retrieveChildrenInfo)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceInfos(
			workflowDefinitionName, workflowDefinitionVersion,
			retrieveChildrenInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#getWorkflowInstanceInfos(java.lang.String,
	 *      long, boolean)
	 */
	public static List<WorkflowInstanceInfo> getWorkflowInstanceInfos(
		String relationType, long relationId, boolean retrieveChildrenInfo)
		throws WorkflowException {
		return _workflowInstanceManager.getWorkflowInstanceInfos(
			relationType, relationId, retrieveChildrenInfo);
	}
	
	public static WorkflowInstanceManager getWorkflowInstanceManager() {
		return _workflowInstanceManager;
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#removeWorkflowInstance(long)
	 */
	public static void removeWorkflowInstance(long workflowInstanceId)
		throws WorkflowException {
		_workflowInstanceManager.removeWorkflowInstance(workflowInstanceId);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#signalWorkflowInstance(long,
	 *      java.util.Map, long)
	 */
	public static WorkflowInstanceInfo signalWorkflowInstance(
		long workflowInstanceId, Map<String, Object> attributes,
		long callingUserId)
		throws WorkflowException {
		return _workflowInstanceManager.signalWorkflowInstance(
			workflowInstanceId, attributes, callingUserId);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#signalWorkflowInstance(long,
	 *      java.lang.String, java.util.Map, long)
	 */
	public static WorkflowInstanceInfo signalWorkflowInstance(
		long workflowInstanceId, String activityName,
		Map<String, Object> attributes, long callingUserId)
		throws WorkflowException {

		return _workflowInstanceManager.signalWorkflowInstance(
			workflowInstanceId, activityName, attributes, callingUserId);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#startWorkflowInstance(java.lang.String,
	 *      java.lang.Integer, java.util.Map, long, java.lang.String)
	 */
	public static WorkflowInstanceInfo startWorkflowInstance(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		Map<String, Object> context, long callingUserId, String activityName)
		throws WorkflowException {
		return _workflowInstanceManager.startWorkflowInstance(
			workflowDefinitionName, workflowDefinitionVersion, context,
			callingUserId, activityName);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#startWorkflowInstance(java.lang.String,
	 *      java.lang.Integer, java.util.Map, long)
	 */
	public static WorkflowInstanceInfo startWorkflowInstance(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		Map<String, Object> context, long callingUserId)
		throws WorkflowException {
		return _workflowInstanceManager.startWorkflowInstance(
			workflowDefinitionName, workflowDefinitionVersion, context,
			callingUserId);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#startWorkflowInstance(java.lang.String,
	 *      java.lang.Integer, java.lang.String, long, java.util.Map, long,
	 *      java.lang.String)
	 */
	public static WorkflowInstanceInfo startWorkflowInstance(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		String relationType, long relationId, Map<String, Object> context,
		long callingUserId, String activityName)
		throws WorkflowException {
		return _workflowInstanceManager.startWorkflowInstance(
			workflowDefinitionName, workflowDefinitionVersion, relationType,
			relationId, context, callingUserId, activityName);
	}

	/**
	 * @see com.liferay.portal.kernel.workflow.WorkflowInstanceManager#startWorkflowInstance(java.lang.String,
	 *      java.lang.Integer, java.lang.String, long, java.util.Map, long)
	 */
	public static WorkflowInstanceInfo startWorkflowInstance(
		String workflowDefinitionName, Integer workflowDefinitionVersion,
		String relationType, long relationId, Map<String, Object> context,
		long callingUserId)
		throws WorkflowException {
		return _workflowInstanceManager.startWorkflowInstance(
			workflowDefinitionName, workflowDefinitionVersion, relationType,
			relationId, context, callingUserId);
	}

	public void setWorkflowInstanceManager(
		WorkflowInstanceManager instanceManager) {
		_workflowInstanceManager = instanceManager;
	}

	private static WorkflowInstanceManager _workflowInstanceManager;
}
