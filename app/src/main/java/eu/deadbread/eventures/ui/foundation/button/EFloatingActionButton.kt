package eu.deadbread.eventures.ui.foundation.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.deadbread.eventures.ui.theme.EventuresTheme

@Composable
fun EFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) = FloatingActionButton(
    modifier = modifier,
    onClick = onClick,
    shape = RoundedCornerShape(100),
    content = content,
    elevation = FloatingActionButtonDefaults.elevation(2.dp, 2.dp)
)

@Composable
@Preview
fun EFloatingActionButtonsPreview() = EventuresTheme {
    Row(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        EFloatingActionButton(onClick = {}, content = {})
    }
}