package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.buttons.VitaminButtons
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.line.Flashlight
import com.decathlon.vitamin.compose.vitaminicons.line.ShoppingCart

@Composable
fun ProductActions(
    onBasketClick: (ProductPageUi) -> Unit,
    onOneClick: (ProductPageUi) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        VitaminButtons.Conversion(
            text = "Add to basket",
            modifier = Modifier.fillMaxWidth(),
            onClick = { onBasketClick(productUi) },
            icon = rememberVectorPainter(image = VitaminIcons.Line.ShoppingCart)
        )
        VitaminButtons.PrimaryReversed(
            text = "Buy in one click",
            modifier = Modifier.fillMaxWidth(),
            onClick = { onOneClick(productUi) },
            icon = rememberVectorPainter(image = VitaminIcons.Line.Flashlight)
        )
    }
}

@Preview
@Composable
fun ProductActionsPreview() {
    VitaminTheme {
        ProductActions(onBasketClick = {}, onOneClick = {})
    }
}
