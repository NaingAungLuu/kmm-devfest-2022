//
//  MovieListViewModel.swift
//  iosApp
//
//  Created by Naing Aung Luu M1 on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

final class MovieListViewModel: ObservableObject {
    
    @Published var movies: [MovieListItemVO] = []
    
    @MainActor
    func loadAllMovies() async throws {
        try await GetAllMoviesUseCase.companion.instance
            .execute()
            .collect(collector: Collector<[Movie]>(callback: { [weak self] movies in
                guard let self = self, let movies = movies else {
                    return
                }
                DispatchQueue.main.async {
                    self.movies = movies.map(self.mapToMovieItemVO)
                }
            }))
    }
    
    private func mapToMovieItemVO(data: Movie) -> MovieListItemVO {
        MovieListItemVO(
            id: UUID().uuidString,
            imageUrl: data.imageUrl,
            movieName: data.title,
            movieDesc: data.description(),
            rating: String(data.rating),
            categories: ["Action", "Thriller", "War/Military"]
        )
    }
    
    private func makeMockMovie() -> MovieListItemVO {
        MovieListItemVO(
            id: UUID().uuidString,
            imageUrl: "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRLeDZOOOe39EylZoDSJteMkbX8lqS4JT-SvEZ8W2M6s1DRBZMd",
            movieName: "Top Gun Maverick",
            movieDesc: "After more than thirty years of service as one of the Navy’s top aviators, Pete “Maverick” Mitchell (Tom Cruise) is where he belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that would ground him. When he finds himself training a detachment of Top Gun graduates for a specialized mission the likes of which no living pilot has ever seen, Maverick encounters Lt. Bradley Bradshaw (Miles Teller), call sign: “Rooster,” the son of Maverick’s late friend and Radar Intercept Officer Lt. Nick Bradshaw, aka “Goose”.",
            rating: "8.4/10",
            categories: ["Action", "Thriller", "War/Military"]
        )
    }
}
