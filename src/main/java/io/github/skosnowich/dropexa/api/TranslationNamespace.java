package io.github.skosnowich.dropexa.api;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.util.HashMap;

@Data
public class TranslationNamespace implements TranslationEntry {

	@JsonValue
	private HashMap<String, TranslationEntry> entries;

	public TranslationNamespace() {
		this.entries = new HashMap<>();
	}

	public void putNamespace(String key, TranslationNamespace namespace) {
		entries.put(key, namespace);
	}

	public void putValue(String key, String value) {
		entries.put(key, new TranslationValue(value));
	}

}
