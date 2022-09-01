package eu.deadbread.eventures.ui.foundation.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.theme.ETypography
import eu.deadbread.eventures.ui.theme.EventuresTheme

@Composable
fun EPrimaryTextBold(
    text: String,
    modifier: Modifier = Modifier,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.PrimaryTextBold,
)

@Composable
@Preview
fun EPrimaryTextBoldPreview() = EventuresTheme {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            EPrimaryTextBold(text = "Primary Text Bold")
        }
    }
}
