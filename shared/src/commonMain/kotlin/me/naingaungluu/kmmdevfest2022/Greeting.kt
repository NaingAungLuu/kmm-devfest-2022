package me.naingaungluu.kmmdevfest2022

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import me.naingaungluu.kmmdevfest2022.data.network.KtorClient
import me.naingaungluu.kmmdevfest2022.data.network.MovieApiImpl
import me.naingaungluu.kmmdevfest2022.data.repositories.MovieRepositoryImpl
import me.naingaungluu.kmmdevfest2022.domain.usecases.GetAllMoviesUseCase

@OptIn(FlowPreview::class)
class Greeting {
    private val platform: Platform = getPlatform()

    suspend fun greeting(): Flow<String> {
        return flow {
            emit("Hello, ${platform.name}!")
        }.flatMapMerge {
            getFirstMovieName()
        }
    }

    private fun getFirstMovieName(): Flow<String> {
        val useCase = GetAllMoviesUseCase(
            MovieRepositoryImpl(
                MovieApiImpl(KtorClient.instance)
            )
        )
        return useCase().map {
            it.first().title
        }
    }
}
