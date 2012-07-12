/*
 * Created on Dec 20, 2010
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
package org.fest.assertions.api;

import static org.fest.assertions.test.LongArrayFactory.emptyArray;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.LongArrays;
import org.junit.*;

/**
 * Tests for <code>{@link LongArrayAssert#isNullOrEmpty()}</code>.
 * 
 * @author Alex Ruiz
 */
public class LongArrayAssert_isNullOrEmpty_Test {

  private LongArrays arrays;
  private LongArrayAssert assertions;

  @Before
  public void setUp() {
    arrays = mock(LongArrays.class);
    assertions = new LongArrayAssert(emptyArray());
    assertions.arrays = arrays;
  }

  @Test
  public void should_verify_actual_is_null_or_empty() {
    assertions.isNullOrEmpty();
    verify(arrays).assertNullOrEmpty(assertions.info, assertions.actual);
  }
}
