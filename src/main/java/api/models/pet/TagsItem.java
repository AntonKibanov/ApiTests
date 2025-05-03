package api.models.pet;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TagsItem{
	private String name;
	private Integer id;
}
