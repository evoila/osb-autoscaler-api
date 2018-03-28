package de.evoila.cf.autoscaler.api.binding;

public class InvalidBindingException extends Exception {
	
	private static final long serialVersionUID = 5790255118030286993L;
	private String message;
	
	public InvalidBindingException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
