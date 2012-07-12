/*
 * Created on Oct 24, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldBeGreaterOrEqual.shouldBeGreaterOrEqual;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.assertions.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;

import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;

/**
 * Tests for <code>{@link Characters#assertGreaterThanOrEqualTo(AssertionInfo, Character, char)}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class Characters_assertGreaterThanOrEqualTo_Test extends AbstractTest_for_Characters {

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    characters.assertGreaterThanOrEqualTo(someInfo(), null, 'a');
  }

  @Test
  public void should_pass_if_actual_is_greater_than_other() {
    characters.assertGreaterThanOrEqualTo(someInfo(), 'b', 'a');
  }

  @Test
  public void should_pass_if_actual_is_equal_to_other() {
    characters.assertGreaterThanOrEqualTo(someInfo(), 'b', 'b');
  }

  @Test
  public void should_fail_if_actual_is_less_than_other() {
    AssertionInfo info = someInfo();
    try {
      characters.assertGreaterThanOrEqualTo(info, 'a', 'b');
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeGreaterOrEqual('a', 'b'));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null_according_to_custom_comparison_strategy() {
    thrown.expectAssertionError(actualIsNull());
    charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(), null, 'a');
  }

  @Test
  public void should_pass_if_actual_is_greater_than_other_according_to_custom_comparison_strategy() {
    charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(), 'B', 'a');
  }

  @Test
  public void should_pass_if_actual_is_equal_to_other_according_to_custom_comparison_strategy() {
    charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(), 'B', 'b');
  }

  @Test
  public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy() {
    AssertionInfo info = someInfo();
    try {
      charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(info, 'a', 'B');
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeGreaterOrEqual('a', 'B', caseInsensitiveComparisonStrategy));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
}
