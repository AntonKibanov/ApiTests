package api.models.pet;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Category{
	private String name;
	private Integer id;
}
