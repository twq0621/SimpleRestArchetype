#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.feature;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

public class JacksonFeature implements Feature {

  private static final ObjectMapper mapper =
      new ObjectMapper(){{
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
      }};

  private static final JacksonJaxbJsonProvider provider =
      new JacksonJaxbJsonProvider(){{
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        setMapper(mapper);

      }};

  @Override
  public boolean configure(FeatureContext context) {
    context.register(provider);
    return true;
  }
}