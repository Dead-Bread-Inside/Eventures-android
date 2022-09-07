package eu.deadbread.eventures.ui.foundation.button

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.foundation.text.EPrimaryTextBold
import eu.deadbread.eventures.ui.theme.EDimension
import eu.deadbread.eventures.ui.theme.EShape
import eu.deadbread.eventures.ui.theme.ETheme
import eu.deadbread.eventures.ui.theme.EventuresTheme
import eu.deadbread.eventures.ui.theme.transparent

@Composable
fun EFillButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) = Button(
    modifier = modifier,
    enabled = enabled,
    onClick = onClick,
    content = content,
    shape = EShape.ButtonShape,
    colors = ButtonDefaults.buttonColors(
        containerColor = ETheme.colors.accent,
        contentColor = ETheme.colors.onAccent,
        disabledContainerColor = ETheme.colors.opaque,
        disabledContentColor = ETheme.colors.background
    ),
    elevation = ButtonDefaults.buttonElevation(
        EDimension.elevationNone,
        EDimension.elevationNone,
        EDimension.elevationNone,
        EDimension.elevationNone,
        EDimension.elevationNone
    ),
)

@Composable
fun ETextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) = TextButton(
    modifier = modifier,
    enabled = enabled,
    onClick = onClick,
    content = content,
    shape = EShape.TextButtonShape,
    colors = ButtonDefaults.textButtonColors(
        containerColor = ETheme.colors.transparent,
        contentColor = ETheme.colors.accent,
        disabledContainerColor = ETheme.colors.transparent,
        disabledContentColor = ETheme.colors.opaque
    ),
)

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun EButtonPreview() = EventuresTheme {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Center) {
            EFillButton(modifier = Modifier.fillMaxWidth(), onClick = {}, enabled = true) {
                EPrimaryTextBold(text = "Enabled Fill Button")
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Center) {
            EFillButton(modifier = Modifier.fillMaxWidth(), onClick = {}, enabled = false) {
                EPrimaryTextBold(text = "Disabled Fill Button")
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Center) {
            ETextButton(modifier = Modifier.fillMaxWidth(), onClick = {}, enabled = true) {
                EPrimaryTextBold(text = "Enabled Text Button")
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Center) {
            ETextButton(modifier = Modifier.fillMaxWidth(), onClick = {}, enabled = false) {
                EPrimaryTextBold(text = "Disabled Text Button")
            }
        }
    }
}
