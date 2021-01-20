package org.clean.hexarch.adapter.addressbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SoapClientInterceptor implements ClientInterceptor {
  @Override
  public boolean handleRequest(MessageContext messageContext) {
    logMessage("Client Request Message to Uvp: {}", messageContext.getRequest());
    return true;
  }

  @Override
  public boolean handleResponse(MessageContext messageContext) {
    logMessage("Client Response Message from Uvp: {}", messageContext.getResponse());
    return true;
  }

  @Override
  public boolean handleFault(MessageContext messageContext) {
    logMessage("Client fault Message from Uvp: {}", messageContext.getResponse());
    return true;
  }

  @Override
  public void afterCompletion(MessageContext messageContext, Exception ex) {
    // No implementation required as of now
  }

  public static void logMessage(String message, WebServiceMessage webServiceMessage) {
    try {
      ByteArrayOutputStream byteArrayTransportOutputStream = new ByteArrayOutputStream();
      webServiceMessage.writeTo(byteArrayTransportOutputStream);

      String httpMessage = new String(byteArrayTransportOutputStream.toByteArray(), StandardCharsets.UTF_8);
      log.debug(message, httpMessage);
    } catch (IOException e) {
      log.error("Unable to log HTTP message: {}", e.getMessage(), e);
    }
  }
}
