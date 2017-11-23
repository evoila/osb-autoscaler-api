package de.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the ram part of the update request body. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class RamUpdate {

	private String thresholdPolicy;
	private long upperLimit;
	private long lowerLimit;
	private boolean ramScalingEnabled;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	public RamUpdate() {
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
		setElements.add(UpdateRequest.RAM_THRESHOLD_POLICY_IS_SET);
	}
	
	public boolean isRamScalingEnabled() {
		return ramScalingEnabled;
	}

	public void setRamScalingEnabled(boolean ramScalingEnabled) {
		this.ramScalingEnabled = ramScalingEnabled;
		setElements.add(UpdateRequest.RAM_SCALING_ENABLED_IS_SET);
	}
	
	public long getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(long upperLimit) {
		this.upperLimit = upperLimit;
		setElements.add(UpdateRequest.RAM_UPPER_LIMIT_IS_SET);
	}

	public long getLowerLimit() {
		return lowerLimit;
	}

	public void setlowerLimit(long lowerLimit) {
		this.lowerLimit = lowerLimit;
		setElements.add(UpdateRequest.RAM_LOWER_LIMIT_IS_SET);
	}
}
