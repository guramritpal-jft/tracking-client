package com.com.excercise.tracking;

import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;

import org.testng.annotations.Test;

import com.excercise.tracking.client.ActivityTrackerClient;
import com.excercise.tracking.model.Activity;

public class clientTest {
	ActivityTrackerClient activityTrackerClient =  new ActivityTrackerClient();

	@Test
	public void test_getActivity() {
		Activity activity = activityTrackerClient.getActivity("walking");
		System.out.println(activity);
	}

	@Test(expectedExceptions = HTTPException.class)
	public void test_getActivityWithNull() {
		Activity activity = activityTrackerClient.getActivity(null);
		System.out.println(activity);
	}

	@Test(expectedExceptions = HTTPException.class)
	public void test_getActivityWithInvalidAcitivy() {
		Activity activity = activityTrackerClient.getActivity("TeST");
		System.out.println(activity);
	}

	@Test
	public void test_createActivity() {
		Activity activity = new Activity();
		activity.setDuration(1);
		activity.setDescription("walking");
		Activity response = activityTrackerClient.createActivity(activity);
		System.out.println(response);
	}

	@Test
	public void test_createOrUpdateActivity_using_PUT() {
		Activity activity = new Activity();
		activity.setDuration(1);
		activity.setDescription("walking");
		Activity response = activityTrackerClient.createOrUpdateActivity("1",activity);
		System.out.println(response);
	}

	@Test
	public void test_deleteActiviy() {
		Response.Status response = activityTrackerClient.deleteActivity("1");
		System.out.println(response);
	}

}
