package com.example.movieapp.movie_popular_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.R

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    voteAverage: Double,
    imageUrl: String,
    id: Int,
    onClick: (id: Int) -> Unit
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .heightIn(200.dp)
                .padding(8.dp)
                .clickable {
                    onClick(id)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

        ) {
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .error(R.drawable.ic_error_image)
                        .placeholder(R.drawable.ic_placeholder)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                        .background(Color.Black)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)) {
                    MovieRate(
                        rate = voteAverage,
                    )
                }
            }
        }

    }
}


@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
        voteAverage = 7.2,
        imageUrl = "",
        id = 1,
        onClick = {},
    )
}

