package de.evoila.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the scaling part of the update request body. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class ScalingUpdate {

	
	private boolean scalingEnabled;
	private boolean predictionScalingEnabled;
	private boolean billingIntervalConsidered;
	
	private int scalingIntervalMultiplier;
	private int minInstances;
	private int maxInstances;
	private int cooldownTime;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	public ScalingUpdate() {
		setElements = new HashSet<Integer>();
	}
	
	public Set<Integer> getSetElements() {
		return setElements;
	}

	public void setSetElements(Set<Integer> setElements) {
		this.setElements = setElements;
	}

	public boolean isScalingEnabled() {
		return scalingEnabled;
	}

	public void setScalingEnabled(boolean scalingEnabled) {
		this.scalingEnabled = scalingEnabled;
		setElements.add(UpdateRequest.SCALING_ENABLED_IS_SET);
	}

	public boolean isPredictionScalingEnabled() {
		return predictionScalingEnabled;
	}

	public void setPredictionScalingEnabled(boolean predictionScalingEnabled) {
		this.predictionScalingEnabled = predictionScalingEnabled;
		setElements.add(UpdateRequest.PREDICTION_SCALING_ENABLED_IS_SET);
	}
	
	public boolean isBillingIntervalConsidered() {
		return billingIntervalConsidered;
	}

	public void setBillingIntervalConsidered(boolean billingIntervalConsidered) {
		this.billingIntervalConsidered = billingIntervalConsidered;
		setElements.add(UpdateRequest.BILLING_INTERVAL_CONSIDERED_IS_SET);
	}

	public int getScalingIntervalMultiplier() {
		return scalingIntervalMultiplier;
	}

	public void setScalingIntervalMultiplier(int scalingIntervalMultiplier) {
		this.scalingIntervalMultiplier = scalingIntervalMultiplier;
		setElements.add(UpdateRequest.SCALING_INTERVAL_MULTIPLIER_IS_SET);
	}

	public int getMinInstances() {
		return minInstances;
	}

	public void setMinInstances(int minInstances) {
		this.minInstances = minInstances;
		setElements.add(UpdateRequest.MIN_INSTANCES_IS_SET);
	}

	public int getMaxInstances() {
		return maxInstances;
	}

	public void setMaxInstances(int maxInstances) {
		this.maxInstances = maxInstances;
		setElements.add(UpdateRequest.MAX_INSTANCES_IS_SET);
	}

	public int getCooldownTime() {
		return cooldownTime;
	}

	public void setCooldownTime(int cooldownTime) {
		this.cooldownTime = cooldownTime;
		setElements.add(UpdateRequest.COOLDOWN_TIME_IS_SET);
	}
}
