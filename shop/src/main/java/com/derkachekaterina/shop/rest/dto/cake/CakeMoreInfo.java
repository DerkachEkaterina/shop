package com.derkachekaterina.shop.rest.dto.cake;


import com.derkachekaterina.shop.goods.AvailabilityOfCake;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Schema(description = "Full info about cake")
@Validated
public class CakeMoreInfo {
    @Null
    @Schema(description = "id of the cake", required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "Name of the cake", required = true)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "Calories in cake", required = true)
    @JsonProperty("calories")
    private BigDecimal calories;

    @NotNull
    @Schema(description = "Url of cake's image", required = true)
    @JsonProperty("image")
    private String image;

    @NotNull
    @Schema(description = "Price of the cake", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Schema(description = "Weight of the cake", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;

    @NotNull
    @Schema(description = "Composition of the cake", required = true)
    @JsonProperty("composition")
    private String composition;

    @NotNull
    @Schema(description = "Product shelf life", required = true)
    @JsonProperty("shelf-life")
    private String shelfLife;

    @NotNull
    @Schema(description = "Cake availability", required = true)
    @JsonProperty("availability-of-cake")
    private AvailabilityOfCake availabilityOfCake;
}
