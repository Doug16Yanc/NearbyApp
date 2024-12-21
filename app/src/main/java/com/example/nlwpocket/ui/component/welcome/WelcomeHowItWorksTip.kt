package com.example.nlwpocket.ui.component.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nlwpocket.ui.theme.Gray500
import com.example.nlwpocket.ui.theme.RedBase
import com.example.nlwpocket.ui.theme.Typography


@Composable
fun WelcomeHowItWorksTip(modifier: Modifier = Modifier, title : String, subtitle : String, @DrawableRes iconRes : Int) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(modifier = Modifier.size(34.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "Como funciona o ícone."
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = title, style = Typography.headlineSmall)
            Text(text = subtitle, color = Gray500, style = Typography.bodyLarge)
        }
    }
}
