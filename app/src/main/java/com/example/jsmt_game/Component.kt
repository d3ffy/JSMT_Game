package com.example.jsmt_game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoardBaseEazy() {
    val COLOR = Color.Gray
    val STROKEWIDTH = 8f

    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
            .border(5.dp, Color.Gray)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val cellSize = size.width / 3
            repeat(2) {
                val x = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height)
                )
            }

            repeat(2) {
                val y = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(0f, y),
                    end = Offset(size.width, y)
                )
            }
        }
    }
}

@Composable
fun BoardBaseNormal() {
    val COLOR = Color.Gray
    val STROKEWIDTH = 8f

    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
            .border(5.dp, COLOR)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val cellSize = size.width / 4
            repeat(3) {
                val x = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height)
                )
            }

            repeat(3) {
                val y = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(0f, y),
                    end = Offset(size.width, y)
                )
            }
        }
    }
}

@Composable
fun BoardBaseHard() {
    val COLOR = Color.Gray
    val STROKEWIDTH = 8f

    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
            .border(5.dp, Color.Gray)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val cellSize = size.width / 5
            repeat(4) {
                val x = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height)
                )
            }

            repeat(4) {
                val y = (it + 1) * cellSize
                drawLine(
                    color = COLOR,
                    strokeWidth = STROKEWIDTH,
                    cap = StrokeCap.Round,
                    start = Offset(0f, y),
                    end = Offset(size.width, y)
                )
            }
        }
    }
}

@Composable
fun Cross() {
    val COLOR = Red
    val STROKEWIDTH = 20f

    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawLine(
            color = COLOR,
            strokeWidth = STROKEWIDTH,
            cap = StrokeCap.Round,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height)
        )
        drawLine(
            color = COLOR,
            strokeWidth = STROKEWIDTH,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun Circle() {
    val COLOR = Blue
    val STROKEWIDTH = 20f

    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color = COLOR,
            style = Stroke(width = STROKEWIDTH)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoardBaseEazyPreview() {
    Box {
        BoardBaseEazy()
    }
}

@Preview(showBackground = true)
@Composable
fun BoardBaseNormalPreview() {
    Box {
        BoardBaseNormal()
    }
}

@Preview(showBackground = true)
@Composable
fun BoardBaseHardPreview() {
    Box {
        BoardBaseHard()
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