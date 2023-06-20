@file:OptIn(ExperimentalLayoutApi::class)

package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.prices.VitaminPrices
import com.decathlon.vitamin.compose.ratings.VitaminRatingSizes
import com.decathlon.vitamin.compose.ratings.VitaminRatings
import com.decathlon.vitamin.compose.tags.VitaminTags

@Composable
fun ProductInfo(
    productUi: ProductPageUi,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            productUi.tags.forEach { tag ->
                VitaminTags.DecorativeGravel(label = tag)
            }
        }
        Text(
            text = productUi.title,
            style = VitaminTheme.typography.h4
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            VitaminRatings.ReadOnlyCompact(
                number = productUi.ratingNote,
                maxValue = productUi.ratingMax,
                nbComments = productUi.nbComments,
                sizes = VitaminRatingSizes.small()
            )
            VitaminPrices.Accent(
                text = productUi.price
            )
        }
    }
}

@Preview
@Composable
fun ProductInfoPreview() {
    VitaminTheme {
        ProductInfo(productUi = productUi)
    }
}
