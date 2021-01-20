package org.clean.hexarch;

import static com.tngtech.archunit.base.DescribedPredicate.not;
import static com.tngtech.archunit.core.domain.AccessTarget.Predicates.constructor;
import static com.tngtech.archunit.core.domain.AccessTarget.Predicates.declaredIn;
import static com.tngtech.archunit.core.domain.JavaCall.Predicates.target;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.belongToAnyOf;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.clean.hexarch.util.exception.ComponentException;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import com.tngtech.archunit.library.freeze.FreezingArchRule;

@AnalyzeClasses(packages = ArchUnitTest.PREFIX)
public class ArchUnitTest {
  public static final String PREFIX = "org.clean.hexarch";

  @ArchTest
  public static final ArchRule noGenericExceptions = noClasses() //
      .should(GeneralCodingRules.THROW_GENERIC_EXCEPTIONS);

  // Code is disallowed from using System.out.
  @ArchTest
  public static final ArchRule noStdout = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

  // This rule disallows circular dependencies, either direct (A->B and B->A) or
  // indirect (A->B, B->C, and C->A).
  @ArchTest
  public static final ArchRule noPackageCycles = SlicesRuleDefinition.slices() //
      .matching(PREFIX + ".(**)") //
      .should() //
      .beFreeOfCycles();

  // All exceptions created/thrown must extend CompoentException.
  private static final ArchRule noNonComponentExceptions = //
      noClasses() //
          .that(not(belongToAnyOf(ComponentException.class))) // do not consider ComponentException itself
          .should() //
          .callCodeUnitWhere(target(constructor() //
              .and(declaredIn(assignableTo(Throwable.class))) //
              .and(not(declaredIn(assignableTo(ComponentException.class)))))) //
          .because("all exceptions thrown by this code must inherit from ComponentException");

  @ArchTest
  public static final ArchRule frozenNoNonComponentExceptions = //
      FreezingArchRule.freeze(noNonComponentExceptions);
}
