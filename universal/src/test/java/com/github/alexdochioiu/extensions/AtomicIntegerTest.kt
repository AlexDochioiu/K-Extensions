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

import com.github.alexdochioiu.extensions.universal.atomicInteger
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@Suppress("ClassName")
@RunWith(Enclosed::class)
class AtomicIntegerTest {
    class `With Initial Value` {
        private var atomicInt: Int by atomicInteger(INITIAL_VALUE)

        @Test
        fun `initial value is correct`() {
            assertEquals(INITIAL_VALUE, atomicInt)
        }

        @Test
        fun `value can be changed`() {
            val expected = 910

            atomicInt = expected
            assertEquals(expected, atomicInt)
        }

        companion object {
            private const val INITIAL_VALUE = 11;
        }
    }

    class `Without Initial Value` {
        private var atomicInt: Int by atomicInteger

        @Test
        fun `initial value is 0`() {
            assertEquals(0, atomicInt)
        }

        @Test
        fun `value can be changed`() {
            val expected = 910

            atomicInt = expected
            assertEquals(expected, atomicInt)
        }
    }
}