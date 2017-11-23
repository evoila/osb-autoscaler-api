package de.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the latency part of the update request body. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class LatencyUpdate {

	private String thresholdPolicy;
	private int upperLimit;
	private int lowerLimit;
	private boolean latencyScalingEnabled;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	public LatencyUpdate() {
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
		setElements.add(UpdateRequest.LATENCY_THRESHOLD_POLICY_IS_SET);
	}

	public boolean isLatencyScalingEnabled() {
		return latencyScalingEnabled;
	}

	public void setLatencyScalingEnabled(boolean latencyScalingEnabled) {
		this.latencyScalingEnabled = latencyScalingEnabled;
		setElements.add(UpdateRequest.LATENCY_SCALING_ENABLED_IS_SET);
	}
	
	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
		setElements.add(UpdateRequest.LATENCY_UPPER_LIMIT_IS_SET);
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
		setElements.add(UpdateRequest.LATENCY_LOWER_LIMIT_IS_SET);
	}
}
