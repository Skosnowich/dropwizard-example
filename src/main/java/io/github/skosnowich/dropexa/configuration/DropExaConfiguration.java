package io.github.skosnowich.dropexa.configuration;

import io.dropwizard.Configuration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class DropExaConfiguration extends Configuration {

	private String someValue;

}
