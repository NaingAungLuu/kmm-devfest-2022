package me.naingaungluu.kmmdevfest2022.utils // ktlint-disable filename

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun <T, R> Flow<List<T>>.mapList(transform: (T) -> R) = this.transform {
    emit(it.map(transform))
}
