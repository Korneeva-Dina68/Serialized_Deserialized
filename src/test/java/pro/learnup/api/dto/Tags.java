package pro.learnup.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags{

	@JsonProperty("color")
	private String color;

	@JsonProperty("os")
	private String os;

	@JsonProperty("displayResolution")
	private String displayResolution;

	@JsonProperty("cpu")
	private String cpu;

	@JsonProperty("internalMemory")
	private String internalMemory;

	@JsonProperty("camera")
	private String camera;

	@JsonProperty("priceRange")
	private String priceRange;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("displaySize")
	private String displaySize;

	@JsonProperty("ram")
	private String ram;
}