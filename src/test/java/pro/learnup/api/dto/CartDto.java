package pro.learnup.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto{

	@JsonProperty("product")
	private String product;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("user")
	private String user;
}