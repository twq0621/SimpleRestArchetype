#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import ${package}.application.feature.JacksonFeature;

import org.glassfish.jersey.${artifactId}.ResourceConfig;

import static org.glassfish.jersey.${artifactId}.ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE;

public class ApplicationResourceConfig extends ResourceConfig {

  public static final String ROOT_PACKAGE = "${package}";

  public ApplicationResourceConfig() {
    packages(true, ROOT_PACKAGE);

    // Features
    register(JacksonFeature.class);

    property(METAINF_SERVICES_LOOKUP_DISABLE, true);

  }

}
