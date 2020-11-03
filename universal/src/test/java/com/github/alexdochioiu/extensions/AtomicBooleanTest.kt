/*
 * Copyright 2020 Alexandru Iustin Dochioiu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.alexdochioiu.extensions

import com.github.alexdochioiu.extensions.universal.atomicBoolean
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@Suppress("ClassName")
@RunWith(Enclosed::class)
class AtomicBooleanTest {

    class `With Initial Value` {
        private var atomicBool: Boolean by atomicBoolean(true)

        @Test
        fun `initial value is correct`() {
            assertTrue(atomicBool)
        }

        @Test
        fun `value can be changed`() {
            atomicBool = false
            assertFalse(atomicBool)
        }
    }

    class `Without Initial Value` {
        private var atomicBool: Boolean by atomicBoolean

        @Test
        fun `initial value is false`() {
            assertFalse(atomicBool)
        }

        @Test
        fun `value can be changed`() {
            atomicBool = true
            assertTrue(atomicBool)
        }
    }

}