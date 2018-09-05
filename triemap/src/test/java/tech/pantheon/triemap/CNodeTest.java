/*
 * (C) Copyright 2018 Pantheon Technologies, s.r.o. and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.pantheon.triemap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CNodeTest {
    @Test
    public void testTrySize() {
        assertEquals(MainNode.NO_SIZE, new CNode<>(new Gen()).trySize());
    }

    @Test(expected = VerifyException.class)
    public void testInvalidElement() {
        CNode.invalidElement(null);
    }
}
