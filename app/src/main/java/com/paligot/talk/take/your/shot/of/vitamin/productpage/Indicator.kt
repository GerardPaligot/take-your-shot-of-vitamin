package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Composable
fun Indicator(
    index: Int,
    count: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = VitaminTheme.colors.vtmnBackgroundTertiary.copy(alpha = .5f),
    contentSelectedColor: Color = VitaminTheme.colors.vtmnContentPrimary,
    contentUnselectedColor: Color = VitaminTheme.colors.vtmnContentInactive
) {
    require(index in 0 until count) {
        "index is out of range"
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .background(color = containerColor, shape = VitaminTheme.shapes.radius400)
            .padding(12.dp)
    ) {
        for (i in 0 until count) {
            IndicatorPoint(
                color = if (i == index) contentSelectedColor else contentUnselectedColor
            )
        }
    }
}

@Composable
internal fun IndicatorPoint(
    modifier: Modifier = Modifier,
    color: Color = VitaminTheme.colors.vtmnContentPrimary,
    shape: Shape = CircleShape
) {
    Box(
        modifier = modifier
            .size(10.dp)
            .background(color = color, shape = shape)
    )
}

@Preview
@Composable
internal fun IndicatorPreview() {
    VitaminTheme {
        Indicator(index = 4, count = 5)
    }
}
