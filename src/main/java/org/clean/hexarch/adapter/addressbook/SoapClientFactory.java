package org.clean.hexarch.adapter.addressbook;

import java.time.Duration;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.webservices.client.HttpWebServiceMessageSenderBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

@Lazy
@Component
class SoapClientFactory implements FactoryBean<SoapClient> {
  @Autowired
  private Jaxb2Marshaller marshaller;

  @Value("${uvp.addressbook.url:#{null}}")
  private String endPointUrl;

  @Value("${uvp.read.timeout.inmillis:30000}")
  private Long readTimeout;

  @Value("${uvp.connect.timeout.inmillis:30000}")
  private Long connectTimeout;

  @Override
  public SoapClient getObject() throws Exception {
    SoapClientImpl client = new SoapClientImpl();

    client.setDefaultUri("http://localhost:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    client.setInterceptors(new ClientInterceptor[] { new SoapClientInterceptor() });
    client.setEndpointUrl(endPointUrl);
    client.setMessageSender(new HttpWebServiceMessageSenderBuilder().setReadTimeout(Duration.ofMillis(readTimeout))
        .setConnectTimeout(Duration.ofMillis(connectTimeout)).build());

    return client;
  }

  @Override
  public Class<?> getObjectType() {
    return SoapClient.class;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}
