package com.github.alexdochioiu.extensions

import com.github.alexdochioiu.extensions.universal.atomicReference
import org.junit.Test

import org.junit.Assert.*
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("ClassName")
@RunWith(Enclosed::class)
class AtomicExtensionsTest {

    @RunWith(Enclosed::class)
    class Nullable {

        class `Initialised With Value` {
            private var atomicString: String? by atomicReference(INITIAL_VALUE)

            @Test
            fun `initial value is correct`() {
                assertEquals(INITIAL_VALUE, atomicString)
            }

            @Test
            fun `value can be changed`() {
                val expected = ":exp"

                atomicString = expected
                assertEquals(expected, atomicString)
            }

            companion object {
                private const val INITIAL_VALUE = ":init2"
            }
        }

        @RunWith(Enclosed::class)
        abstract class `Initialised Without Value` {

            @Suppress("unused")
            class `Initialised With Null` : `Initialised Without Value`() {
                override var atomicString: String? by atomicReference(null)
            }

            @Suppress("unused")
            class `Initialised Without No Arg` : `Initialised Without Value`() {
                override var atomicString: String? by atomicReference()
            }

            protected abstract var atomicString: String?

            @Test
            fun `initial value is null`() {
                assertNull(atomicString)
            }

            @Test
            fun `value can be changed`() {
                val expected = ":exp"

                atomicString = expected
                assertEquals(expected, atomicString)
            }

            @Test
            fun `value can be set back to null`() {
                val expected = ":exp"

                atomicString = expected
                assertEquals(expected, atomicString)

                atomicString = null
                assertNull(atomicString)
            }
        }
    }

    class `Non Nullable` {

        private var atomicString: String by atomicReference(INITIAL_VALUE)

        @Test
        fun `initial value is correct`() {
            assertEquals(INITIAL_VALUE, atomicString)
        }

        @Test
        fun `value can be changed`() {
            val expected = ":exp"

            atomicString = expected
            assertEquals(expected, atomicString)
        }

        companion object {
            private const val INITIAL_VALUE = ":init"
        }
    }
}