//
//  MovieDetailView.swift
//  iosApp
//
//  Created by Naing Aung Luu M1 on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 15.0, *)
struct ChipView: View {
    let title: String
    
    var body: some View {
        Text(title)
            .padding(12)
            .padding(.horizontal, 14)
            .font(.caption.bold())
            .background(Color.primary)
            .foregroundColor(.init(uiColor: .systemBackground))
            .clipShape(RoundedRectangle(cornerRadius: 16))
    }
}

@available(iOS 16.0, *)
struct MovieDetailView: View {
    @Binding var vo: MovieListItemVO
    
    var body: some View {
        NavigationStack {
            GeometryReader { proxy in
                ScrollView {
                    let size = proxy.size
                    VStack(spacing: 0) {
                        ZStack {
                            AsyncImage(url: URL(string: vo.imageUrl)) { image in
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: size.width)
                            } placeholder: {
                                ZStack {
                                    Color.gray
                                        .frame(width: size.width, height: size.width * 1.5)
                                    ProgressView()
                                        .scaleEffect(1.4)
                                }
                            }
                            
                            LinearGradient(colors: [.black, .black.opacity(0), .black.opacity(0), .black.opacity(0)], startPoint: .top, endPoint: .bottom)
                        }
                        
                        HStack(alignment: .top) {
                            VStack(alignment: .leading, spacing: 6) {
                                Text(vo.movieName)
                                    .font(.title.bold())
                                    .foregroundColor(.primary)
                                
                                Group {
                                    Text("Rating: ") + Text(vo.rating).fontWeight(.bold)
                                }
                                .foregroundColor(.secondary)
                                .font(.body)
                            }
                            .frame(maxWidth: .infinity, alignment: .leading)
                            
                            Button {
                                vo.isFavorite.toggle()
                            } label: {
                                Image(systemName: vo.isFavorite ? "heart.fill" : "heart")
                                    .font(.title)
                                    .foregroundColor(vo.isFavorite ? .pink : .primary)
                                    .padding(12)
                            }
                        }
                        .padding()
                        
                        ScrollView(.horizontal, showsIndicators: false) {
                            LazyHStack {
                                ForEach(vo.categories, id: \.self) { category in
                                    ChipView(title: category)
                                }
                            }
                            .padding()
                        }
                        
                        VStack(alignment: .leading, spacing: 8) {
                            Text("Summary")
                                .font(.title2.bold())
                            Text(vo.movieDesc)
                                .foregroundColor(.secondary)
                        }
                        .padding()

                    }
                }
                .ignoresSafeArea()
                
            }
        }
    }
}

@available(iOS 16.0, *)
struct MovieDetailView_Previews: PreviewProvider {
    static var previews: some View {
        MovieDetailView(vo: .constant(.mock))
    }
}
