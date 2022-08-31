package eu.deadbread.eventures.ui.foundation.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.theme.EShape
import eu.deadbread.eventures.ui.theme.ETypography
import eu.deadbread.eventures.ui.theme.EventuresTheme

@Composable
fun ETextButton(
    text: String,
    onClick: () -> Unit,
) = TextButton(
    onClick = onClick,
    shape = EShape.TextButtonShape,
) {
    Text(text = text, style = ETypography.PrimaryTextBold)
}

@Composable
@Preview
fun ETextButtonPreview() = EventuresTheme {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center) {
        ETextButton(text = "Request Location Permissions", onClick = {})
    }
}
