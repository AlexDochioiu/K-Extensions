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

import java.util.concurrent.atomic.AtomicBoolean
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val atomicBoolean: ReadWriteProperty<Any?, Boolean>
    get() = AtomicBooleanDelegate(false)

fun atomicBoolean(initialValue: Boolean): ReadWriteProperty<Any?, Boolean> =
    AtomicBooleanDelegate(initialValue)

private class AtomicBooleanDelegate(initialValue: Boolean) : ReadWriteProperty<Any?, Boolean> {
    private val atomicBooleanValue = AtomicBoolean(initialValue)

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean =
        atomicBooleanValue.get()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        atomicBooleanValue.set(value)
    }
}