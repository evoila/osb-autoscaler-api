package de.evoila.cf.autoscaler.api;

import de.evoila.cf.autoscaler.api.binding.BindingContext;

public class ScalingRequest {

	private int scale;
	private BindingContext context;
	
	public ScalingRequest() {
		context = null;
		scale = -1;
	}
	
	public ScalingRequest(int scale, BindingContext context) {
		this.scale = scale;
		this.context = new BindingContext(context);
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public BindingContext getContext() {
		return context;
	}

	public void setContext(BindingContext context) {
		this.context = context;
	}
	
	@Override
	public String toString() {
		return "ScalingRequest [scale=" + scale + ", context=" + context + "]";
	}

	/**
	 * Generates a JSON String out of the fields. Is needed for controller communication beside spring.
	 * @return JSON String filled with the fields
	 */
	public String getJSON() {
		return "{"
				+ "\"scale\" : "+scale
				+ ", "
				+ "\"context\" : {"
					+ "\"platform\" : \""+context.getPlatform()+"\""
					+ ", "
					+ "\"organization_guid\" : \""+context.getOrganization_guid()+"\""
					+ ", "
					+ "\"space_guid\" : \""+context.getSpace_guid()+"\""
					+ "}"
				+ "}";
	}
}
