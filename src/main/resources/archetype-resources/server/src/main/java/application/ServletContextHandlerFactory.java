#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ServletContextHandlerFactory {

  public static ServletContextHandler createServletContext(String pathToSpringContext) {
    ApplicationResourceConfig applicationResourceConfig = new ApplicationResourceConfig();

    ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(applicationResourceConfig));

    ServletContextHandler context = new ServletContextHandler();

    context.setContextPath("/");
    context.addServlet(jerseyServlet, "/*");

    context.addEventListener(new ContextLoaderListener());
    context.addEventListener(new RequestContextListener());

    context.setInitParameter("contextClass",
                             AnnotationConfigWebApplicationContext.class.getName());
    context.setInitParameter("contextConfigLocation", pathToSpringContext);

    return context;
  }
}
