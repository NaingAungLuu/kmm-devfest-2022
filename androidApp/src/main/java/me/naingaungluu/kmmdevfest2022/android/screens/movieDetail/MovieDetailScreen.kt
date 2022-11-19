package me.naingaungluu.kmmdevfest2022.android.screens.movieDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import me.naingaungluu.kmmdevfest2022.domain.models.Movie

@Destination
@Composable
fun MovieDetailScreen(
    data: Movie
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(
            text = "Movie Details",
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(20.dp)
        )
        AsyncImage(
            model = data.imageUrl,
            contentDescription = "Cover Art",
            modifier = Modifier.fillMaxWidth()
        )
        Text(data.title)
        Text(data.description)
        Text(
            text = data.rating.toString(),
            modifier = Modifier.align(Alignment.End)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xffffcc33))
                .padding(horizontal = 4.dp, vertical = 2.dp)

        )
        Spacer(Modifier.height(16.dp))
    }
}
