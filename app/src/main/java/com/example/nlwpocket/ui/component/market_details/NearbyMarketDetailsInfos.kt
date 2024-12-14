package com.example.nlwpocket.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nlwpocket.R
import com.example.nlwpocket.data.model.domain.NearbyMarket
import com.example.nlwpocket.data.model.mock.mockMarkets
import com.example.nlwpocket.ui.theme.Gray400
import com.example.nlwpocket.ui.theme.Gray500
import com.example.nlwpocket.ui.theme.Typography

@Composable
fun NearbyMarketDetailsInfos(modifier : Modifier = Modifier, market: NearbyMarket) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Informações", style = Typography.headlineSmall, color = Gray400)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_ticket),
                    tint = Gray500,
                    contentDescription = "Ícones de cupons"
                )
                Text(
                    text = "${market.coupons} cupons disponíveis",
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    tint = Gray500,
                    contentDescription = "Ícone de endereço"
                )
                Text(text = market.address,
                    style = Typography.labelMedium,
                    color = Gray500)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.ic_phone),
                    tint = Gray500,
                    contentDescription = "Ícone de telefone"
                )
                Text(text = market.phone,
                    style = Typography.labelMedium,
                    color = Gray500)
            }
        }
   }
}

@Preview
@Composable
private fun MarketDetailsInfosPreview() {
    NearbyMarketDetailsInfos(
        modifier = Modifier.fillMaxWidth(),
        market = mockMarkets.first()
    )
}