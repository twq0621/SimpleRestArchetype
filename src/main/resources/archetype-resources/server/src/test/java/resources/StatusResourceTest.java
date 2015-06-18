#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.resources;

import ${package}.config.IntegrationTestContext;
import ${package}.status.model.StatusDTO;

import org.junit.Test;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StatusResourceTest extends IntegrationTestContext {

  @Test
  public void statusHeadIsSuccessful() {
    Response response = target("status").request().head();

    assertThat(response.getStatus(), is(OK.getStatusCode()));
  }

  @Test
  public void statusIsOk(){
    StatusDTO status = target("status").request().get(StatusDTO.class);

    assertThat(status.getStatus(), is(("OK")));
  }
}