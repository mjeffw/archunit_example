package org.clean.hexarch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = ArchUnitTest.PREFIX)
public class ArchUnitTest {
  public static final String PREFIX = "org.clean.hexarch";

  @ArchIgnore
  @ArchTest
  public static final ArchRule rule = Architectures.onionArchitecture()
      .domainModels(PREFIX + ".application.domain.model..").domainServices(PREFIX + ".application.domain.service..")
      .applicationServices(PREFIX + ".application").adapter("uvpcontroller", PREFIX + ".adapter.uvpcontroller..")
      .adapter("mpsclient", PREFIX + ".adapter.mpsclient..").adapter("uvpclient", PREFIX + ".adapter.uvpclient..");
}
