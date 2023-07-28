package pro.learnup.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.learnup.api.serializers.LocalDateDeserializer;
import pro.learnup.api.serializers.LocalDateSerializer;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order{

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonProperty("dateCreated")
	private LocalDateTime dateCreated;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("price")
	private int price;

	@JsonProperty("name")
	private String name;
}