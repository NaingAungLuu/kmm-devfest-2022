//
//  MovieListView.swift
//  MovieApp
//
//  Created by Kyaw Zay Ya Lin Tun on 11/17/22.
//

import SwiftUI

struct MovieListView: View {
    
    @StateObject var vm = MovieListVM()
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
            .onAppear(perform: vm.fetchMovies)
        }
    }
}

struct MovieListView_Previews: PreviewProvider {
    static var previews: some View {
        MovieListView()
    }
}
