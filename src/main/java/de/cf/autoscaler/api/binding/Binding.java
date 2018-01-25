package de.cf.autoscaler.api.binding;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Binding {

	/**
	 * Id of the binding to identify a specific binding
	 */
	private String id;
	/**
	 * Id of the resource needed for identifying dedicated metrics from Kafka 
	 */
	private String resourceId;
	private String scalerId;
	private long creationTime;
	private BindingContext context;
	
	
	public Binding() {
		id = null;
		resourceId = null;
		scalerId = null;
		context = null;
		creationTime = 0;
	}
	
	public Binding (Binding other) {
		id = other.getId();
		resourceId = other.getResourceId();
		scalerId = other.getScalerId();
		creationTime = other.getCreationTime();
		context = new BindingContext(other.getContext());
	}

	public Binding(String id, String resourceId, String scalerId, long creationTime, BindingContext context) {
		this.id = id;
		this.resourceId = resourceId;
		this.scalerId = scalerId;
		this.context = context;
		this.creationTime = creationTime;
	}

	@JsonIgnore
	public boolean isValid() {
		return id != null && resourceId != null && scalerId != null && creationTime > 0 && context != null
				&& !id.isEmpty() && !resourceId.isEmpty() && !scalerId.isEmpty() && context.isValid();
	}
	
	public String isValidWithReason() {
		if (id ==  null || id.isEmpty())
			return "id is not set or empty";
		if (!BindingContext.validId(id))
			return "id contains special characters";
		if (resourceId == null || resourceId.isEmpty())
			return "resourceId is not set or empty";
		if (!BindingContext.validId(resourceId))
			return "resourceId contains special characters";
		if (scalerId == null || scalerId.isEmpty())
			return "scalerId is not set or empty";
		if (creationTime < 0)
			return "creationTime is smaller than 0";
		if (!context.isValid())
			return "context is invald, make sure the guids do not have special characters and the platform is set, not empty and supported";

		return null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getScalerId() {
		return scalerId;
	}

	public void setScalerId(String scalerId) {
		this.scalerId = scalerId;
	}
	
	@JsonIgnore
	public String getIdentifierStringForLogs() {
		return 	id + " / " + resourceId;
	}
	
	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public BindingContext getContext() {
		return context;
	}

	public void setContext(BindingContext context) {
		this.context = context;
	}
	
	public boolean equals(Binding other) {
		return id.equals(other.getId()) && resourceId.equals(other.getResourceId()) && scalerId.equals(other.getScalerId()) && context.equals(other.context);
	}
}
