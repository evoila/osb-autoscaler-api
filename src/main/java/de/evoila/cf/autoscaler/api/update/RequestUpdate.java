package de.evoila.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the requests part of the update request body. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class RequestUpdate {

	private String thresholdPolicy;
	private int minRequestQuotient;
	private boolean quotientScalingEnabled;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	public RequestUpdate() {
		setElements = new HashSet<Integer>();
	}
	
	public Set<Integer> getSetElements() {
		return setElements;
	}

	public void setSetElements(Set<Integer> setElements) {
		this.setElements = setElements;
	}
	
	public String getThresholdPolicy() {
		return thresholdPolicy;
	}

	public void setThresholdPolicy(String thresholdPolicy) {
		this.thresholdPolicy = thresholdPolicy;
		setElements.add(UpdateRequest.REQUEST_THRESHOLD_POLICY_IS_SET);
	}

	public int getMinRequestQuotient() {
		return minRequestQuotient;
	}

	public void setMinRequestQuotient(int minRequestQuotient) {
		this.minRequestQuotient = minRequestQuotient;
		setElements.add(UpdateRequest.MIN_REQUEST_QUOTIENT_IS_SET);
	}
	public boolean isQuotientScalingEnabled() {
		return quotientScalingEnabled;
	}

	public void setQuotientScalingEnabled(boolean quotientScalingEnabled) {
		this.quotientScalingEnabled = quotientScalingEnabled;
		setElements.add(UpdateRequest.QUOTIENT_SCALING_ENABLED_IS_SET);
	}
}
