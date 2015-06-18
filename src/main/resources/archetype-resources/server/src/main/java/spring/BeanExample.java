#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.spring;

import org.springframework.stereotype.Component;

@Component
public class BeanExample {

  public void doSomething(){
    System.out.println("HelloWorld");
  }
}
