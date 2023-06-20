@file:OptIn(ExperimentalFoundationApi::class)

package com.paligot.talk.take.your.shot.of.vitamin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.paligot.talk.take.your.shot.of.vitamin.productpage.ProductPage
import com.paligot.talk.take.your.shot.of.vitamin.productpage.productUi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    }
}
