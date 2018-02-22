package de.cf.autoscaler.api;

import de.cf.autoscaler.api.binding.BindingContext;

/**
 * POJO for serialization of a request body and the answer body of a request for the name of an application
 * @author Marius Berger
 *
 */
public class ApplicationNameRequest {

	private String id;
	private String name;
	private BindingContext context;
	
	public ApplicationNameRequest() {  }

	public ApplicationNameRequest(String id, String name, BindingContext context) {
		this.id = id;
		this.name = name;
		this.context = context;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BindingContext getContext() {
		return context;
	}

	public void setContext(BindingContext context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "ApplicationNameRequest [id=" + id + ", name=" + name + ", context=" + context + "]";
	}
}