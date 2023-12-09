package fr.upjv.tonmarmi.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.upjv.tonmarmi.ui.theme.TonmarmiTheme

@Composable
fun AuthScreen()
{
    Text(text = "Auth")
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    TonmarmiTheme{
        AuthScreen()
    }
}