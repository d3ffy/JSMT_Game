package com.example.jsmt_game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Cross() {
    val color = Red
    val strokeWidth = 20f

    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawLine(
            color = color,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height)
        )
        drawLine(
            color = color,
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun Circle() {
    val color = Blue
    val strokeWidth = 20f

    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color = color,
            style = Stroke(width = strokeWidth)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CrossPreview() {
    Cross()
}

@Preview(showBackground = true)
@Composable
fun CirclePreview() {
    Circle()
}