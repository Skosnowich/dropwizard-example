package io.github.skosnowich.dropexa.api;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslationValue implements TranslationEntry {

	@JsonValue
	private String content;

}
