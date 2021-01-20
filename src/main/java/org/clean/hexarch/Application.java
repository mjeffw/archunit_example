package org.clean.hexarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.att.bbnmsls.ol.uvp", "com.att.bbnmsls.ol.uverseserviceorder",
    "com.att.bbnmsls.ol.servicebridge" })
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
