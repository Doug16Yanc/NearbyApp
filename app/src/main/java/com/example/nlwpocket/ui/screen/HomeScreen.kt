package com.example.nlwpocket.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nlwpocket.data.model.domain.NearbyMarket
import com.example.nlwpocket.data.model.mock.mockCategories
import com.example.nlwpocket.data.model.mock.mockMarkets
import com.example.nlwpocket.ui.component.category.NearbyCategoryFilterChipList
import com.example.nlwpocket.ui.component.market.NearbyMarketCardList
import com.example.nlwpocket.ui.theme.Gray100
import com.google.android.gms.maps.GoogleMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToMarketDetails : (NearbyMarket) -> Unit) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    var isBottomSheetOpened by remember { mutableStateOf(true) }

    val configuration = LocalConfiguration.current

    if (isBottomSheetOpened) {
        BottomSheetScaffold(
            modifier = modifier,
            scaffoldState = bottomSheetState,
            sheetContainerColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                NearbyMarketCardList(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    markets = mockMarkets,
                    onMarketClick = { selectedMarket ->
                        onNavigateToMarketDetails(selectedMarket)
                    }
                )
            },
           content = {
               Box(modifier = Modifier.fillMaxSize()
                   .padding(it)) {
                   //GoogleMap(modifier = Modifier.fillMaxSize())
               }
                NearbyCategoryFilterChipList(modifier = Modifier.fillMaxWidth()
                    .padding(top = 25.dp),
                    categories = mockCategories,
                    onSelectedCategoryChanged = {

                    })
            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(onNavigateToMarketDetails = {})
}