package com.example.nlwpocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaInstance
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.nlwpocket.data.model.domain.NearbyMarket
import com.example.nlwpocket.ui.screen.HomeScreen
import com.example.nlwpocket.ui.screen.MarketDetailsScreen
import com.example.nlwpocket.ui.screen.SplashScreen
import com.example.nlwpocket.ui.screen.WelcomeScreen
import com.example.nlwpocket.ui.screen.route.Home
import com.example.nlwpocket.ui.screen.route.Splash
import com.example.nlwpocket.ui.screen.route.Welcome
import com.example.nlwpocket.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = {
                                navController.navigate(it)
                            })
                    }
                    composable<NearbyMarket> {
                        val selectedMarket = it.toRoute<NearbyMarket>()
                        MarketDetailsScreen(
                            market = selectedMarket
                        )
                    }
                }
            }
        }
    }
}
