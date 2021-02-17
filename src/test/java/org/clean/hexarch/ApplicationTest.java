package org.clean.hexarch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.GeneralCodingRules;

class ApplicationTest {
  private static final String PREFIX = "org.clean.hexarch";
  private static JavaClasses importedClasses;

  @BeforeAll
  public static void scanClasses() {
    importedClasses = new ClassFileImporter().importPackages(PREFIX);
  }

  @Test
  public void noGenericExceptions() {
    GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(importedClasses);
  }
}
