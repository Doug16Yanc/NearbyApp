package com.example.nlwpocket.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nlwpocket.data.model.domain.NearbyRule
import com.example.nlwpocket.data.model.mock.mockMarkets
import com.example.nlwpocket.data.model.mock.mockRules
import com.example.nlwpocket.ui.theme.Gray400
import com.example.nlwpocket.ui.theme.Gray500
import com.example.nlwpocket.ui.theme.Typography

@Composable
fun NearbyMarketDetailsRules(modifier : Modifier = Modifier, rules : List<NearbyRule>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = rules.joinToString(separator = "\n", transform = { "• ${it.description}" }),
            style = Typography.labelMedium,
            lineHeight = 24.sp,
            color = Gray500
        )
    }
}

@Preview
@Composable
private fun MarketDetailsRulesPreview() {
    NearbyMarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = mockRules
    )
}