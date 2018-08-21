package pl.edu.amu.wmi.students.mario.suncodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@SpringBootApplication
public class SuncodeDemoApplication implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SuncodeDemoApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new FacesServlet(), "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }
}
