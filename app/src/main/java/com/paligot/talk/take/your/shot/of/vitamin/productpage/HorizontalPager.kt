@file:OptIn(ExperimentalFoundationApi::class)

package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Composable
fun HorizontalPager(
    index: Int,
    count: Int,
    modifier: Modifier = Modifier,
    state: PagerState = rememberPagerState(),
    pageContent: @Composable (page: Int) -> Unit
) {
    Box {
        androidx.compose.foundation.pager.HorizontalPager(
            pageCount = count,
            modifier = modifier,
            state = state,
            pageContent = pageContent
        )
        Indicator(
            index = index,
            count = count,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp, end = 16.dp)
        )
    }
}

@Preview
@Composable
internal fun HorizontalPagerPreview() {
    VitaminTheme {
        HorizontalPager(
            index = 0,
            count = 5,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = ColorPainter(VitaminTheme.colors.vtmnActivePrimary),
                contentDescription = null
            )
        }
    }
}
