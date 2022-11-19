//
//  MovieListItemVO.swift
//  MovieApp
//
//  Created by Kyaw Zay Ya Lin Tun on 11/17/22.
//

import Foundation

struct MovieListItemVO: Identifiable {
    let id: String
    let imageUrl: String
    let movieName: String
    let movieDesc: String
    let rating: String
    let categories: [String]
    var isFavorite: Bool = false
    
    static let mock = MovieListItemVO(
        id: UUID().uuidString,
        imageUrl: "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRLeDZOOOe39EylZoDSJteMkbX8lqS4JT-SvEZ8W2M6s1DRBZMd",
        movieName: "Top Gun Maverick",
        movieDesc: "After more than thirty years of service as one of the Navy’s top aviators, Pete “Maverick” Mitchell (Tom Cruise) is where he belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that would ground him. When he finds himself training a detachment of Top Gun graduates for a specialized mission the likes of which no living pilot has ever seen, Maverick encounters Lt. Bradley Bradshaw (Miles Teller), call sign: “Rooster,” the son of Maverick’s late friend and Radar Intercept Officer Lt. Nick Bradshaw, aka “Goose”.",
        rating: "8.4/10",
        categories: ["Action", "Thriller", "War/Military"]
    )
}
