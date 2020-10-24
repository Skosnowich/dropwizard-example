package io.github.skosnowich.dropexa;

import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import io.github.skosnowich.dropexa.configuration.DropExaConfiguration;
import io.github.skosnowich.dropexa.resources.TranslationResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class DropExaApplicationTest {

	private static final String APPLICATION_NAME = "drop-exa";

	@Mock
	private DropExaConfiguration configurationMock;

	@Mock
	private Environment environmentMock;

	@Mock
	private JerseyEnvironment jerseyEnvironmentMock;

	private DropExaApplication dropExaApplication;

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);

		dropExaApplication = new DropExaApplication();

		when(environmentMock.jersey()).thenReturn(jerseyEnvironmentMock);
	}

	@Test
	void whenGetNameIsCalled_thenCorrectApplicationNameIsReturned() {
		assertThat(dropExaApplication.getName()).isEqualTo(APPLICATION_NAME);
	}

	@Test
	void whenRunIsCalled_thenTranslationResourceIsInitializedCorrectlyAndIsRegisteredToJerseyEnvironment() {
		dropExaApplication.run(configurationMock, environmentMock);

		verify(jerseyEnvironmentMock).register(new TranslationResource(new TestObjects()));
	}

}
