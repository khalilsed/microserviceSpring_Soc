package com.soc.teacher;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "teachers")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema teachersSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("TeachersPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://soc.com/teachers");
        wsdl.setSchema(teachersSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema teachersSchema() {
        return new SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("teachers.xsd"));
    }
}