//
//  MovieListView.swift
//  iosApp
//
//  Created by Naing Aung Luu M1 on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct MovieListView: View {
    
    @StateObject var vm = MovieListViewModel()
    private let gridItems: [GridItem] = Array(repeating: .init(.flexible(), spacing: 12), count: 2)
    
    var body: some View {
        NavigationStack {
            ScrollView(showsIndicators: false) {
                LazyVGrid(columns: gridItems, spacing: 20) {
                    ForEach($vm.movies, id: \.id) { item in
                        NavigationLink {
                            MovieDetailView(vo: item)
                        } label: {
                            MovieListItemView(vo: item)
                        }
                    }
                }
            }
            .padding(.horizontal)
            .background(Color(uiColor: .systemBackground))
            .navigationTitle("Movies")
            .task {
                do {
                    try await vm.loadAllMovies()
                } catch {}
            }
        }
    }
}

struct MovieListView_Previews: PreviewProvider {
    static var previews: some View {
        MovieListView()
    }
}
