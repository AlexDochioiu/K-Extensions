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
package com.github.alexdochioiu.extensions.universal

import java.util.concurrent.atomic.AtomicInteger
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val atomicInteger: ReadWriteProperty<Any?, Int>
    get() = atomicInteger(0)

fun atomicInteger(initialValue: Int): ReadWriteProperty<Any?, Int> =
    AtomicIntegerDelegate(initialValue)

private class AtomicIntegerDelegate(initialValue: Int) : ReadWriteProperty<Any?, Int> {
    private val atomicIntegerValue = AtomicInteger(initialValue)

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Int =
        atomicIntegerValue.get()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        atomicIntegerValue.set(value)
    }
}