package com.github.alexdochioiu.extensions.universal

import java.util.concurrent.atomic.AtomicReference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@JvmName("atomicReferenceNullable")
fun <T> atomicReference(): ReadWriteProperty<Any?, T?> =
    AtomicReferenceDelegate(null)

@JvmName("atomicReferenceNonNullable")
fun <T> atomicReference(initialValue: T): ReadWriteProperty<Any?, T> =
    AtomicReferenceDelegate(initialValue)

private class AtomicReferenceDelegate<T>(initialValue: T) : ReadWriteProperty<Any?, T> {
    private val atomicReferenceValue = AtomicReference<T>(initialValue)

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
        atomicReferenceValue.get()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        atomicReferenceValue.set(value)
    }
}