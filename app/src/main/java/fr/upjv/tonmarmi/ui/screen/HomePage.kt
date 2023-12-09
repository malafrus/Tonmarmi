package fr.upjv.tonmarmi.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.upjv.tonmarmi.R
import fr.upjv.tonmarmi.ui.theme.TonmarmiTheme

@Composable
fun HomeScreen(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit
){
    val mainteners: Array<String> = stringArrayResource(id = R.array.mainteners)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp)
    ){
        item {
            Text(
                text = stringResource(id = R.string.home_page),
                modifier = Modifier.padding(bottom = 100.dp)
            )
        }
        items(count = mainteners.size ){
            Text(text = mainteners[it],
                modifier = Modifier.padding(10.dp))
        }
        item(
        )
        { Row (modifier = Modifier.padding(top = 400.dp)){
            Button(
                modifier = Modifier
                    .padding(end = 10.dp),
                content = {
                    Text(stringResource(id = R.string.API))
                },
                onClick = { onButtonClick() }
            )
            Button(
                content = {
                    Text(text = stringResource(id = R.string.Auth))
                },
                onClick = { onButton2Click() }
            )
        } }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TonmarmiTheme{
        HomeScreen({},{})
    }
}