package com.excercise.tracking.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;

import com.excercise.tracking.model.Activity;

/**
 * Created by guramritpal on 18/3/17.
 */
public class ActivityTrackerClient {
	private Client client;
	WebTarget target ;

	public ActivityTrackerClient() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/tracking-web/");
	}

	/*public Activity getActivity(String name) {
		Activity response = target.path("activites/"+name)
				.request()
				.get(Activity.class);
		return response;
	}
*/

	public Activity getActivity(String name) {
		Response response = target.path("activities/"+name)
				.request()
				.get(Response.class);
		if (Response.Status.BAD_REQUEST.getStatusCode() ==response.getStatus()) {
			throw new HTTPException(Response.Status.BAD_REQUEST.getStatusCode());
		}
		if (Response.Status.NOT_FOUND.getStatusCode() == response.getStatus()) {
			throw new HTTPException(Response.Status.NOT_FOUND.getStatusCode());

		}
		return response.readEntity(Activity.class);
	}

	public Activity createActivity(Activity activity) {
		Response response = target.path("activities/create")
				.request()
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		return response.readEntity(Activity.class);
	}

	public Activity createOrUpdateActivity(String id, Activity activity) {
		Response response = target.path("activities/create/"+id)
				.request()
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		return response.readEntity(Activity.class);
	}


	public Response.Status deleteActivity(String activityId) {
		Response response = target.path("activities/delete/"+activityId)
				.request()
				.delete();
		if (response.getStatus() == 200) {
			return Response.Status.OK;
		}
		return Response.Status.NOT_MODIFIED;
	}

}
