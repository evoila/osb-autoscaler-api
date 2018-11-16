package de.evoila.cf.autoscaler.api.binding;

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

	/**
	 * Name of the resource only used for displaying issues and not for scaling.
	 */
	private String resourceName;

	/**
	 * Id of the scaler this binding is bound to.
	 */
	private String scalerId;

	/**
	 * Id of the specific service.
	 * In the CF context, this would be the service instance id.
	 */
	private String serviceId;

	private long creationTime;

	/**
	 * Context of this binding.
	 */
	private BindingContext context;

	public Binding() {
		id = null;
		resourceId = null;
		resourceName = null;
		scalerId = null;
		serviceId = null;
		context = null;
		creationTime = 0;
	}
	
	public Binding (Binding other) {
		id = other.getId();
		resourceId = other.getResourceId();
		resourceName = other.getResourceName();
		scalerId = other.getScalerId();
		serviceId = other.getServiceId();
		creationTime = other.getCreationTime();
		context = new BindingContext(other.getContext());
	}

	public Binding(String id, String resourceId, String resourceName, String scalerId, String serviceId,
			long creationTime, BindingContext context) {
		this.id = id;
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.scalerId = scalerId;
		this.serviceId = serviceId;
		this.creationTime = creationTime;
		this.context = context;
	}

	@JsonIgnore
	public boolean isValid() {
		return id != null && resourceId != null && scalerId != null && serviceId != null && creationTime > 0 && context != null
				&& !id.isEmpty() && !resourceId.isEmpty() && !scalerId.isEmpty() && !serviceId.isEmpty() && context.isValid();
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
		if (serviceId == null || serviceId.isEmpty())
			return "serviceId is not set or empty";
		if (creationTime < 0)
			return "creationTime is smaller than 0";
		if (!context.isValid())
			return "context is invalid, make sure the guids do not have special characters and the platform is set, not empty and supported";

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
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	@JsonIgnore
	public String getIdentifierStringForLogs() {
		return 	resourceName + " / resourceId: '" + resourceId + "'";
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
	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public boolean equals(Binding other) {
		return id.equals(other.getId()) && resourceId.equals(other.getResourceId()) && scalerId.equals(other.getScalerId()) 
				&& serviceId.equals(other.getServiceId()) && context.equals(other.context);
	}
}
