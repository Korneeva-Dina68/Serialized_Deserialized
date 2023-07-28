package pro.learnup.api.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhonesCartDto{

	@JsonProperty("__v")
	private int V;

	@JsonProperty("_id")
	private String id;

	@JsonProperty("user")
	private String user;

	@JsonProperty("items")
	private List<ItemsItem> items;
}