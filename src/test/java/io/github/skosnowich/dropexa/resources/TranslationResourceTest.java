package io.github.skosnowich.dropexa.resources;

import io.github.skosnowich.dropexa.TestObjects;
import io.github.skosnowich.dropexa.api.TranslationNamespace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class TranslationResourceTest {

	@Mock
	private TestObjects testObjectsMock;

	@Mock
	private HttpServletRequest httpServletRequestMock;

	@Mock
	private TranslationNamespace translationMock;

	private TranslationResource translationResource;

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);

		translationResource = new TranslationResource(testObjectsMock);

		final Locale requestLocale = Locale.CANADA;
		when(httpServletRequestMock.getLocale()).thenReturn(requestLocale);

		when(testObjectsMock.getTranslation(requestLocale)).thenReturn(translationMock);
	}

	@Test
	void whenGetTranslationIsCalled_thenTranslationIsFetchedViaLocaleFromTestObjectsAndIsReturned() {
		final TranslationNamespace actualTranslation = translationResource.getTranslation(httpServletRequestMock);

		assertThat(actualTranslation).isEqualTo(translationMock);
	}

}
