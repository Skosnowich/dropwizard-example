package io.github.skosnowich.dropexa;

import io.github.skosnowich.dropexa.api.TranslationNamespace;

import java.util.HashMap;
import java.util.Locale;

public class TestObjects {

	private static final String APPLICATION_NAMESPACE_KEY = "application";
	private static final String APP_NAME_KEY = "name";
	private static final String HOME_NAMESPACE_KEY = "home";
	private static final String HOME_TITLE_KEY = "title";
	private static final String HOME_TEXT_KEY = "text";

	private static final HashMap<Locale, TranslationNamespace> translations;

	static {
		translations = new HashMap<>();
		translations.put(Locale.GERMANY, createGermanTranslation());
		translations.put(Locale.UK, createEnglishTranslation());
	}

	private TestObjects() {
	}

	public static TranslationNamespace getTranslation(Locale locale) {
		return translations.get(locale);
	}

	private static TranslationNamespace createGermanTranslation() {
		final TranslationNamespace homeNamespace = createHomeNamespace("Startseite", "Hallo, dies ist die Startseite.");
		final TranslationNamespace applicationNamespace = createApplicationNamespace(homeNamespace, "Dropwizard Beispiel");
		return createRootNamespace(applicationNamespace);
	}

	private static TranslationNamespace createEnglishTranslation() {
		final TranslationNamespace homeNamespace = createHomeNamespace("Home", "Hello, this is the home-page.");
		final TranslationNamespace applicationNamespace = createApplicationNamespace(homeNamespace, "Dropwizard Example");
		return createRootNamespace(applicationNamespace);
	}

	private static TranslationNamespace createHomeNamespace(String title, String text) {
		final TranslationNamespace homeNamespace = new TranslationNamespace();
		homeNamespace.putValue(HOME_TITLE_KEY, title);
		homeNamespace.putValue(HOME_TEXT_KEY, text);
		return homeNamespace;
	}

	private static TranslationNamespace createApplicationNamespace(TranslationNamespace homeNamespace, String applicationName) {
		final TranslationNamespace applicationNamespace = new TranslationNamespace();
		applicationNamespace.putValue(APP_NAME_KEY, applicationName);
		applicationNamespace.putNamespace(HOME_NAMESPACE_KEY, homeNamespace);
		return applicationNamespace;
	}

	private static TranslationNamespace createRootNamespace(TranslationNamespace applicationNamespace) {
		final TranslationNamespace rootNamespace = new TranslationNamespace();
		rootNamespace.putNamespace(APPLICATION_NAMESPACE_KEY, applicationNamespace);
		return rootNamespace;
	}

}
