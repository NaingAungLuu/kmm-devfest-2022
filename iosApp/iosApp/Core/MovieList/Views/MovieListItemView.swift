//
//  MovieListItemView.swift
//  MovieApp
//
//  Created by Kyaw Zay Ya Lin Tun on 11/17/22.
//

import SwiftUI

struct MovieListItemView: View {
    @Binding var vo: MovieListItemVO
    
    var body: some View {
        VStack(alignment: .leading, spacing: 0) {
            ZStack(alignment: .topLeading) {
                AsyncImage(url: URL(string: vo.imageUrl)) { image in
                    image
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                        .frame(height: 240)
                        .clipped()
                } placeholder: {
                    ZStack {
                        Color.gray
                            .frame(height: 240)
                        
                        ProgressView()
                            .scaleEffect(1.4)
                    }
                }
                
                LinearGradient(colors: [Color.black, Color.black.opacity(0.2), Color.black.opacity(0), Color.black.opacity(0)], startPoint: .topLeading, endPoint: .bottomTrailing)
                
                Button {
                    vo.isFavorite.toggle()
                } label: {
                    Image(systemName: vo.isFavorite ? "heart.fill" : "heart")
                        .font(.title)
                        .foregroundColor(vo.isFavorite ? .pink : .white)
                        .padding(12)
                }
            }
            
            VStack(alignment: .leading) {
                Text(vo.movieName)
                    .multilineTextAlignment(.leading)
                    .font(.headline)
                
                Text(vo.rating)
                    .multilineTextAlignment(.leading)
                    .font(.footnote)
            }
            .padding()
        }
        .background(Color(uiColor: .systemFill))
        .clipShape(RoundedRectangle(cornerRadius: 12))
    }
}

struct MovieListItemView_Previews: PreviewProvider {
    static var previews: some View {
        MovieListView()
    }
}
