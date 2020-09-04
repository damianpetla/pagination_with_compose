package com.schibsted.example.longfeedwithcompose.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
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
            Stack {
                CoilImageWithCrossfade(
                    data = newsItem.imageUrl,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                if (newsItem.caption.isNotEmpty()) {
                    Box(shape = RoundedCornerShape(4.dp), padding = 2.dp, modifier = Modifier.background(
                        Color.White.copy(alpha = 0.8f)).gravity(
                        Alignment.BottomEnd)) {
                        Text(text = newsItem.caption, style = MaterialTheme.typography.caption)
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
    Column(Modifier.padding(16.dp)) {
        NewsCard(newsItem = NewsItem("Title title title", "", "28-08-2020", "Category", "Mr. T")) {

        }
    }
}