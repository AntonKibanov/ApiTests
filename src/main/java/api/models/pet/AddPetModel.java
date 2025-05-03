package api.models.pet;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AddPetModel{
	private List<String> photoUrls;
	private String name;
	private Integer id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}