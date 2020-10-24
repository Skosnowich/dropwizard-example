package io.github.skosnowich.dropexa;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.github.skosnowich.dropexa.configuration.DropExaConfiguration;
import io.github.skosnowich.dropexa.resources.TranslationResource;

public class DropExaApplication extends Application<DropExaConfiguration> {

	public static void main(String[] args) throws Exception {
		new DropExaApplication().run(args);
	}

	@Override
	public String getName() {
		return "drop-exa";
	}

	@Override
	public void run(DropExaConfiguration configuration, Environment environment) {
		environment.jersey().register(createTranslationResource());
	}

	private TranslationResource createTranslationResource() {
		return new TranslationResource();
	}

}
