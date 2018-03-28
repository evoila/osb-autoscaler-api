package de.evoila.cf.autoscaler.api.update;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the body of an update request. A set is given to indicate which fields have to be updated.
 * Using a setter adds the dedicated field to the set.
 * @author Marius Berger
 *
 */
public class UpdateRequest {

	public static final int REQUEST_THRESHOLD_POLICY_IS_SET = 0;
	public static final int CPU_THRESHOLD_POLICY_IS_SET = 1;
	public static final int RAM_THRESHOLD_POLICY_IS_SET = 2;
	public static final int LATENCY_THRESHOLD_POLICY_IS_SET = 3;
	public static final int SCALING_ENABLED_IS_SET = 4;
	public static final int CPU_SCALING_ENABLED_IS_SET = 5;
	public static final int RAM_SCALING_ENABLED_IS_SET = 6;
	public static final int LATENCY_SCALING_ENABLED_IS_SET = 7;
	public static final int QUOTIENT_SCALING_ENABLED_IS_SET = 8;
	public static final int PREDICTION_SCALING_ENABLED_IS_SET = 9;
	public static final int LEARNING_ENABLED_IS_SET = 10;
	public static final int BILLING_INTERVAL_CONSIDERED_IS_SET = 11;
	public static final int MIN_REQUEST_QUOTIENT_IS_SET = 12;
	public static final int CPU_UPPER_LIMIT_IS_SET = 13;
	public static final int CPU_LOWER_LIMIT_IS_SET = 14;
	public static final int RAM_UPPER_LIMIT_IS_SET = 15;
	public static final int RAM_LOWER_LIMIT_IS_SET = 16;
	public static final int LATENCY_UPPER_LIMIT_IS_SET = 17;
	public static final int LATENCY_LOWER_LIMIT_IS_SET = 18;
	public static final int MIN_INSTANCES_IS_SET = 19;
	public static final int MAX_INSTANCES_IS_SET = 20;
	public static final int COOLDOWN_TIME_IS_SET = 21;
	public static final int LEARNING_TIME_MULTIPLIER_IS_SET = 22;
	public static final int SCALING_INTERVAL_MULTIPLIER_IS_SET = 23;

	@JsonProperty("scaling")
	private ScalingUpdate scaling;
	@JsonProperty("cpu")
	private CpuUpdate cpu;
	@JsonProperty("ram")
	private RamUpdate ram;
	@JsonProperty("latency")
	private LatencyUpdate latency;
	@JsonProperty("requests")
	private RequestUpdate requests;
	@JsonProperty("learning")
	private LearningUpdate learning;
	
	/**
	 * {@code Set} of integers to specify, which fields are supposed to be updated.
	 */
	@JsonIgnore
	private Set<Integer> setElements;
	
	/**
	 * Default Constructor with set initialization.
	 */
	public UpdateRequest() {
		setElements = new HashSet<Integer>();
		scaling = new ScalingUpdate();
		cpu = new CpuUpdate();
		ram = new RamUpdate();
		latency = new LatencyUpdate();
		requests = new RequestUpdate();
		learning = new LearningUpdate();
	}
	
	public ScalingUpdate getScaling() {
		return scaling;
	}

	public void setScaling(ScalingUpdate scaling) {
		this.scaling = scaling;
	}

	public CpuUpdate getCpu() {
		return cpu;
	}

	public void setCpu(CpuUpdate cpu) {
		this.cpu = cpu;
	}

	public RamUpdate getRam() {
		return ram;
	}

	public void setRam(RamUpdate ram) {
		this.ram = ram;
	}

	public LatencyUpdate getLatency() {
		return latency;
	}

	public void setLatency(LatencyUpdate latency) {
		this.latency = latency;
	}

	public RequestUpdate getRequests() {
		return requests;
	}

	public void setRequests(RequestUpdate requests) {
		this.requests = requests;
	}

	public LearningUpdate getLearning() {
		return learning;
	}

	public void setLearning(LearningUpdate learning) {
		this.learning = learning;
	}

	public Set<Integer> getSetElements() {
		return setElements;
	}
	
	public Set<Integer> getAllSetElements() {
		Set<Integer> set = getSetElements();
		List<Set<Integer>> innerSets = getInnerSets();
		for (int i = 0; i < innerSets.size(); i++) {
			set.addAll(innerSets.get(i));
		}
		return set;
	}
	
	/**
	 * Adds all sets of inner objects to a List.
	 * @return list of sets of inner objects.
	 */
	public List<Set<Integer>> getInnerSets() {
		List<Set<Integer>> innerSets = new LinkedList<Set<Integer>>();
		if (scaling.getSetElements() != null)
			innerSets.add(scaling.getSetElements());
		if (cpu.getSetElements() != null)
			innerSets.add(cpu.getSetElements());
		if (ram.getSetElements() != null)
			innerSets.add(ram.getSetElements());
		if (latency.getSetElements() != null)
			innerSets.add(latency.getSetElements());
		if (requests.getSetElements() != null)
			innerSets.add(requests.getSetElements());
		if (learning.getSetElements() != null)
			innerSets.add(learning.getSetElements());
		
		return innerSets;
	}

	@Override
	public String toString() {
		return "UpdateRequest [scaling=" + scaling + ", cpu=" + cpu + ", ram=" + ram + ", latency=" + latency
				+ ", requests=" + requests + ", learning=" + learning + ", setElements=" + setElements + "]";
	}
}
