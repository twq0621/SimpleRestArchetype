#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.resources;

import ${package}.spring.BeanExample;
import ${package}.status.model.StatusDTO;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("status")
public class StatusResource {

  private final BeanExample beanExample;

  @Autowired
  public StatusResource(BeanExample beanExample) {
    this.beanExample = beanExample;
  }

  @HEAD
  public Response head() {
    return Response.ok().build();
  }

  @GET
  @Produces("application/json")
  public Response test() {
    StatusDTO statusDTO = new StatusDTO();
    statusDTO.setStatus("OK");

    return Response.ok(statusDTO).build();
  }

}
