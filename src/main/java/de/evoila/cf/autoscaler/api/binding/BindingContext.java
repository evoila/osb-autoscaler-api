package de.evoila.cf.autoscaler.api.binding;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BindingContext {
	
	private static final String PLATFORM_CF = "cloudfoundry";

	private String platform;
	private String space_guid;
	private String organization_guid;
	
	public BindingContext() {
		platform = null;
		space_guid = null;
		organization_guid = null;
	}
	
	public BindingContext(BindingContext other) {
		platform = other.getPlatform();
		space_guid = other.getSpace_guid();
		organization_guid = other.getOrganization_guid();
	}
	
	public BindingContext(String platform, String space_guid, String organization_guid) {
		this.platform = platform;
		this.space_guid = space_guid;
		this.organization_guid = organization_guid;
	}

	@JsonIgnore
	public boolean isValid() {
		return platform != null && space_guid != null && organization_guid != null && platform.equals(PLATFORM_CF) && validId(space_guid) && validId(organization_guid);
	}
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSpace_guid() {
		return space_guid;
	}

	public void setSpace_guid(String space_guid) {
		this.space_guid = space_guid;
	}

	public String getOrganization_guid() {
		return organization_guid;
	}

	public void setOrganization_guid(String organization_guid) {
		this.organization_guid = organization_guid;
	}
	
	public boolean equals(BindingContext other) {
		return platform.equals(other.platform) && space_guid.equals(other.space_guid) && organization_guid.equals(other.organization_guid);
	}
	
	@Override
	public String toString() {
		return "BindingContext [platform=" + platform + ", space_guid=" + space_guid + ", organization_guid="
				+ organization_guid + "]";
	}

	@JsonIgnore
	/**
	 * Checks the given String for any other characters than [a-zA-Z] or '-'
	 * @param id id as a String to check for special characters
	 * @return true, if no special characters were found
	 */
	public static boolean validId(String id) {
		if (!id.matches("\\w+")) {
			for (int i = 0; i < id.length(); i++) {
				if (String.valueOf(id.charAt(i)).matches("\\W+") && id.charAt(i) != '-' ) {
					return false;	
				}
			}
		}
		return true;
	}
}
