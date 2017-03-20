package com.com.excercise.tracking;

import java.util.List;

import org.testng.annotations.Test;

import com.excercise.tracking.client.ActivityTrackerSpringRestTemplateClient;
import com.excercise.tracking.model.Activity;

public class RestTemplateTest {

	ActivityTrackerSpringRestTemplateClient activityTrackerSpringRestTemplateClient = new ActivityTrackerSpringRestTemplateClient();

	@Test
	public void test_findActiviyByDescription() {
		List<Activity> response = activityTrackerSpringRestTemplateClient.searchActivity("description", "walking");
		System.out.println(response);
	}


}
