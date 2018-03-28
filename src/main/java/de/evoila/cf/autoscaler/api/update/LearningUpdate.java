package de.evoila.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the learning part of the update request body. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class LearningUpdate {

	private boolean learningEnabled;
	private int learningTimeMultiplier;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	public LearningUpdate() {
		setElements = new HashSet<Integer>();
	}
	
	public Set<Integer> getSetElements() {
		return setElements;
	}

	public void setSetElements(Set<Integer> setElements) {
		this.setElements = setElements;
	}
	
	public boolean isLearningEnabled() {
		return learningEnabled;
	}
	
	public void setLearningEnabled(boolean learningEnabled) {
		this.learningEnabled = learningEnabled;
		setElements.add(UpdateRequest.LEARNING_ENABLED_IS_SET);
	}

	public int getLearningTimeMultiplier() {
		return learningTimeMultiplier;
	}

	public void setLearningTimeMultiplier(int learningTimeMultiplier) {
		this.learningTimeMultiplier = learningTimeMultiplier;
		setElements.add(UpdateRequest.LEARNING_TIME_MULTIPLIER_IS_SET);
	}
}
