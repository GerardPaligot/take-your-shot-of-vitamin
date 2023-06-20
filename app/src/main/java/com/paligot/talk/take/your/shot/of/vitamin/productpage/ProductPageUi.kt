@file:OptIn(ExperimentalFoundationApi::class)

package com.paligot.talk.take.your.shot.of.vitamin.productpage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.decathlon.vitamin.compose.foundation.VitaminTheme

data class ProductPageUi(
    val title: String,
    val isFavorite: Boolean,
    val selectedPicture: Int = 0,
    val tags: List<String>,
    val pictures: List<String>,
    val ratingNote: Float,
    val ratingMax: Int,
    val nbComments: Int,
    val price: String
)

@Composable
fun ProductPage(
    productUi: ProductPageUi,
    onNavigationClick: () -> Unit,
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onBasketClick: (ProductPageUi) -> Unit,
    onOneClick: (ProductPageUi) -> Unit,
    picturePagersState: PagerState = rememberPagerState()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                onNavigationClick = onNavigationClick,
                onShareClick = onShareClick,
                onFavoriteClick = onFavoriteClick,
                isFavorite = productUi.isFavorite
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            if (productUi.pictures.isNotEmpty()) {
                item {
                    HorizontalPager(
                        index = productUi.selectedPicture,
                        count = productUi.pictures.size,
                        state = picturePagersState,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                    ) { index ->
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = productUi.pictures[index],
                                placeholder = ColorPainter(VitaminTheme.colors.vtmnBackgroundBrandPrimary)
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            item {
                ProductInfo(productUi = productUi)
            }
        }
    }
}

internal val productUi = ProductPageUi(
    title = "Domyos 100 Cardio Workout T-Shirt Women's",
    isFavorite = false,
    tags = listOf("DOMYOS"),
    pictures = listOf(
        "https://cdn.shopify.com/s/files/1/1330/6287/products/8380104-product_image-1705600_960x.jpg?v=1686425220",
        "https://cdn.shopify.com/s/files/1/1330/6287/products/8380104-product_image-1705612_960x.jpg?v=1686425220",
        "https://cdn.shopify.com/s/files/1/1330/6287/products/8380104-product_image-1705603_960x.jpg?v=1686425220"
    ),
    ratingNote = 4.5f,
    ratingMax = 5,
    nbComments = 4951,
    price = "$9.99"
)

@Preview
@Composable
internal fun ProfilePreview() {
    var productUi by remember { mutableStateOf(value = productUi) }
    val state = rememberPagerState()
    LaunchedEffect(key1 = state.currentPage) {
        productUi = productUi.copy(selectedPicture = state.currentPage)
    }
    VitaminTheme {
        ProductPage(
            productUi = productUi,
            onNavigationClick = {},
            onShareClick = {},
            onFavoriteClick = {
                productUi = productUi.copy(isFavorite = !productUi.isFavorite)
            },
            onBasketClick = {},
            onOneClick = {},
            picturePagersState = state
        )
    }
}
