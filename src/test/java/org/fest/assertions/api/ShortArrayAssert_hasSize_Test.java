/*
 * Created on Dec 21, 2010
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

import static junit.framework.Assert.assertSame;
import static org.fest.assertions.test.ShortArrayFactory.emptyArray;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.ShortArrays;
import org.junit.*;

/**
 * Tests for <code>{@link ShortArrayAssert#hasSize(int)}</code>.
 * 
 * @author Alex Ruiz
 */
public class ShortArrayAssert_hasSize_Test {

  private ShortArrays arrays;
  private ShortArrayAssert assertions;

  @Before
  public void setUp() {
    arrays = mock(ShortArrays.class);
    assertions = new ShortArrayAssert(emptyArray());
    assertions.arrays = arrays;
  }

  @Test
  public void should_verify_that_actual_has_expected_size() {
    assertions.hasSize(6);
    verify(arrays).assertHasSize(assertions.info, assertions.actual, 6);
  }

  @Test
  public void should_return_this() {
    ShortArrayAssert returned = assertions.hasSize(0);
    assertSame(assertions, returned);
  }
}
