package me.naingaungluu.kmmdevfest2022.data.network

import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClient {
    companion object {
        val instance = HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Auth) {
                bearer {
                    this.loadTokens {
                        BearerTokens(
                            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNWI4MzMyMjEwNDY1ZWM2ZjM5ZDdkMmIzMGI0ZDRhOSIsInN1YiI6IjVkOGYwNTU1MTA5Y2QwMDAwZjQyMDFjNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ir8IdUuaf9n73XFCbqdHBcwrMNLykucEq_TyO8MMrsI",
                            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNWI4MzMyMjEwNDY1ZWM2ZjM5ZDdkMmIzMGI0ZDRhOSIsInN1YiI6IjVkOGYwNTU1MTA5Y2QwMDAwZjQyMDFjNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ir8IdUuaf9n73XFCbqdHBcwrMNLykucEq_TyO8MMrsI"
                        )
                    }
                }
            }
        }
    }
}
