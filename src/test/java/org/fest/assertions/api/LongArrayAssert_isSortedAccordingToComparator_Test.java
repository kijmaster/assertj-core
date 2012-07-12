/*
 * Created on Dec 2, 2010
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

import static org.fest.assertions.test.LongArrayFactory.emptyArray;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.fest.assertions.internal.LongArrays;

/**
 * Tests for <code>{@link LongArrayAssert#isSortedAccordingTo(Comparator)}</code>.
 * 
 * @author Joel Costigliola
 */
public class LongArrayAssert_isSortedAccordingToComparator_Test {

  @Mock
  private Comparator<Long> comparator;

  @Before
  public void before() {
    initMocks(this);
  }

  @Test
  public void should_verify_that_assertIsSorted_is_called() {
    LongArrays arrays = mock(LongArrays.class);
    LongArrayAssert assertions = new LongArrayAssert(emptyArray());
    assertions.arrays = arrays;
    assertions.isSortedAccordingTo(comparator);
    verify(arrays).assertIsSortedAccordingToComparator(assertions.info, assertions.actual, comparator);
  }

  @Test
  public void should_return_this() {
    LongArrayAssert objectArrayAssert = new LongArrayAssert(new long[] { 1, 2 });
    assertSame(objectArrayAssert, objectArrayAssert.isSortedAccordingTo(comparator));
  }

}
