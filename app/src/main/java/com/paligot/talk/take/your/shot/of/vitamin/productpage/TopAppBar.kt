package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.appbars.topbars.ActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.vitaminicons.Fill
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.fill.Heart
import com.decathlon.vitamin.compose.vitaminicons.line.Heart
import com.decathlon.vitamin.compose.vitaminicons.line.Share

@Composable
fun TopAppBar(
    onNavigationClick: () -> Unit,
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false
) {
    VitaminTopBars.Primary(
        title = "Product page",
        modifier = modifier,
        navigationIcon = {
            Context(
                onClick = onNavigationClick,
                contentDescription = "Back to product list"
            )
        },
        actions = listOf(
            ActionItem(
                icon = rememberVectorPainter(image = VitaminIcons.Line.Share),
                contentDescription = "Share product",
                onClick = onShareClick
            ),
            ActionItem(
                icon = rememberVectorPainter(
                    image = if (isFavorite) VitaminIcons.Fill.Heart else VitaminIcons.Line.Heart
                ),
                contentDescription = "Favorite",
                onClick = onFavoriteClick
            )
        )
    )
}

@Preview
@Composable
fun TopAppBarPreview() {
    VitaminTheme {
        TopAppBar(
            onNavigationClick = { /*TODO*/ },
            onShareClick = { /*TODO*/ },
            onFavoriteClick = { /*TODO*/ })
    }
}
