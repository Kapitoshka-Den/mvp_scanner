import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun ValidateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit),
    isError: Boolean,
    errorMessage: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column() {
        OutlinedTextField(
            isError = isError,
            value = value,
            onValueChange = { onValueChange(it) },
            label = label,
            visualTransformation = visualTransformation,
        )
        if (isError) Text(text = errorMessage, style = TextStyle(color = Color.Red))
    }
}