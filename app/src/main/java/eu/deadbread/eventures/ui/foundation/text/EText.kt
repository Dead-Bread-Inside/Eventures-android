package eu.deadbread.eventures.ui.foundation.text

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.theme.ETypography
import eu.deadbread.eventures.ui.theme.EventuresTheme

@Composable
fun EPrimaryTextBold(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.PrimaryTextBold,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun EPrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.PrimaryText,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun ETitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.TitleText,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun ETitleTextBold(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.TitleTextBold,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun ESecondaryText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.SecondaryText,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun ESecondaryTextBold(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.SecondaryTextBold,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
fun ESmallText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    text = text,
    modifier = modifier,
    style = ETypography.SmallText,
    color = color,
    textAlign = textAlign,
    maxLines = maxLines,
)

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
private fun ETextPreview() = EventuresTheme {
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                ETitleText(text = "Title Text")
            }
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                ETitleTextBold(text = "Title Text Bold")
            }
        }

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                EPrimaryText(text = "Primary Text")
            }
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                EPrimaryTextBold(text = "Primary Text Bold")
            }
        }

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                ESecondaryText(text = "Secondary Text")
            }
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                ESecondaryTextBold(text = "Secondary Text Bold")
            }
        }

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                ESmallText(text = "Small Text")
            }
        }
    }
}
