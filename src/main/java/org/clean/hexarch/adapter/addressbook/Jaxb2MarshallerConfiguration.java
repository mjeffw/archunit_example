package org.clean.hexarch.adapter.addressbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
class Jaxb2MarshallerConfiguration {
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPaths(/* "com.att.cio.commonheader.v3", */ "org.clean.hexarch.adapter.uvp.data",
        "org.clean.hexarch.adapter.uvp.data.types");
    return marshaller;
  }
}
