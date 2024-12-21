package com.example.nlwpocket.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nlwpocket.R
import com.example.nlwpocket.data.model.domain.NearbyMarket
import com.example.nlwpocket.data.model.mock.mockMarkets
import com.example.nlwpocket.ui.component.button.NearbyButton
import com.example.nlwpocket.ui.component.market_details.NearbyMarketDetailsCoupons
import com.example.nlwpocket.ui.component.market_details.NearbyMarketDetailsInfos
import com.example.nlwpocket.ui.component.market_details.NearbyMarketDetailsRules
import com.example.nlwpocket.ui.theme.Typography

@Composable
fun MarketDetailsScreen(modifier : Modifier = Modifier, market : NearbyMarket) {
    Box(modifier = modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Imagem de local",
            contentScale = ContentScale.Crop,
            model = market.cover
        )

        Box(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
            .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
            .align(Alignment.BottomCenter)
            .background(Color.White)
        ) {
            Column(modifier = modifier.fillMaxHeight()
                .padding(36.dp)) {
                Column {
                    Text(text = market.name, style = Typography.headlineLarge)
                    Spacer(modifier = modifier.height(16.dp))
                    Text(text = market.description, style = Typography.bodyLarge)
                }
                Spacer(modifier = modifier.height(49.dp))

                Column(modifier = modifier.weight(1f)
                    .verticalScroll(rememberScrollState())) {

                    NearbyMarketDetailsInfos(market = market)
                    HorizontalDivider(modifier = modifier.fillMaxWidth().padding(vertical = 24.dp))
                    /* if(market.rules.isNotEmpty()) {
                        NearbyMarketDetailsRules(rules = market.rules)
                    HorizontalDivider(modifier = modifier.fillMaxWidth().padding(vertical = 24.dp))
                } */

                    NearbyMarketDetailsCoupons(coupons = listOf("ABC12345"))
                }

                NearbyButton(modifier = modifier.fillMaxWidth()
                    .padding(top = 25.dp),
                    text = "Ler QR Code",
                    onClick = {})
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailsScreen(market = mockMarkets.first())
}