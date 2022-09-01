package eu.deadbread.eventures.ui.foundation.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.foundation.text.EPrimaryTextBold
import eu.deadbread.eventures.ui.theme.EDimension
import eu.deadbread.eventures.ui.theme.EShape
import eu.deadbread.eventures.ui.theme.ETheme
import eu.deadbread.eventures.ui.theme.EventuresTheme

@Composable
internal fun EButton(
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
        containerColor = ETheme.colors.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,

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
@Preview
fun EButtonPreview() = EventuresTheme {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center) {
            EButton(onClick = {}, enabled = true) {
                EPrimaryTextBold(text = "Enabled Button Text")
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center) {
            EButton(onClick = {}, enabled = false) {
                EPrimaryTextBold(text = "Disabled Button Text")
            }
        }

    }
}
