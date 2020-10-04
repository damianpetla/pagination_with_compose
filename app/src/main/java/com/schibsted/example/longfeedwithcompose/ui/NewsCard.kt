package com.schibsted.example.longfeedwithcompose.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.coil.CoilImageWithCrossfade


@Composable
fun NewsCard(newsItem: NewsItem, onClick: () -> Unit) {
    Card(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp).clickable(onClick = onClick)) {
        Column {
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
            Box {
                CoilImageWithCrossfade(
                    data = newsItem.imageUrl,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                if (newsItem.caption.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                            .background(shape = RoundedCornerShape(8.dp), color = Color.White.copy(alpha = 0.8f))
                    ) {
                        Text(text = newsItem.caption, style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))
                    }
                }
            }

            Column(Modifier.padding(8.dp)) {
                Text(text = newsItem.title, style = MaterialTheme.typography.h6)
                Text(text = newsItem.category, style = MaterialTheme.typography.body2)
                Text(text = newsItem.date, style = MaterialTheme.typography.caption)
            }

        }
    }

}

@Preview
@Composable
fun DefaultPreview() {
    NewsCard(newsItem = NewsItem("Title title title", "", "28-08-2020", "Category", "Mr. T")) {

    }
}

@Preview
@Composable
fun DefaultDarkPreview() {
    MaterialTheme(colors = darkColors(primary = Color.Blue)) {
        NewsCard(newsItem = NewsItem("Title title title", "", "28-08-2020", "Category", "Mr. T")) {

        }
    }

}