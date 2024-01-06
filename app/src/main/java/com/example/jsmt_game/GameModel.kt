package com.example.jsmt_game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

var heart = 3
var isFailed: Boolean = false
var isWin: Boolean = false
var tempClickedList = Array(level.size) { Array(level.size) { 0 } }

fun createHint(level: List<List<Int>>): Pair<MutableList<MutableList<Int>>, MutableList<MutableList<Int>>> {
    val rowHints: MutableList<MutableList<Int>> = mutableListOf()
    val colHints: MutableList<MutableList<Int>> = MutableList(level[0].size) { mutableListOf() }

    // Calculate hints for rows
    for (i in level.indices) {
        var rowCount = 0
        val rowTempList: MutableList<Int> = mutableListOf()

        for (j in level[i].indices) {
            if (level[i][j] == 1) {
                rowCount++
            } else if (rowCount > 0) {
                rowTempList.add(rowCount)
                rowCount = 0
            }
        }
        if (rowCount > 0) {
            rowTempList.add(rowCount)
        }
        rowHints.add(rowTempList)
    }

    for (i in level[0].indices) {
        var colCount = 0
        val colTempList: MutableList<Int> = mutableListOf()

        for (j in level.indices) {
            if (level[j][i] == 1) {
                colCount++
            } else if (colCount > 0) {
                colTempList.add(colCount)
                colCount = 0
            }
        }
        if (colCount > 0) {
            colTempList.add(colCount)
        }
        colHints[i] = colTempList
    }

    return Pair(rowHints, colHints)
}

public fun gameReset() {
    heart = 3
    isFailed = false
    isWin = false
}
@Composable
public fun GameSetup() {
    CreateBoard(level)
}

@Composable
fun Filled() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        drawRect(
            color = Color(0xFFFFFedc2efB),
            size = Size(size.width, size.height),
            topLeft = Offset(0f, 0f),
        )
    }
}

@Composable
fun CreateCell(
    idx: String,
    ans: Int
) {
    var isClicked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clickable {
                isClicked = !isFailed && !isWin
            }
            .background(
                color = if (isClicked) Color.Transparent else Color.LightGray
            )
            .aspectRatio(1f)
    ) {
        if (isClicked && !isFailed && !isWin) {
            tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(idx[1])] =
                1

            if (ans == 0 && tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(
                    idx[1]
                )] == 1
            ) {
                Cross()
                heart -= 1
            } else if (ans == 1 && tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(
                    idx[1]
                )] == 1
            ) {
                Filled()
            }
            if (heart <= 0) {
                tempClickedList = Array(level.size) { Array(level.size) { 0 } }
                isFailed = true
            }

            if (checkWin()) {
                isWin = true
            }
        }

        for (i in 0..level.size-1) {
            var horizontalScore = 0
            var verticalScore = 0

            for (j in 0..level.size - 1){
                if (level[i][j] == 1 && tempClickedList[i][j] == 0){
                    horizontalScore -= 1
                }

                if (level[j][i] == 1 && tempClickedList[j][i] == 0){
                    verticalScore -= 1
                }
            }

            if (horizontalScore >= 0) {
                tempClickedList[i] = Array(level.size) { 1 }
            }
            if (verticalScore >= 0){
                for (j in 0..level.size-1){
                    tempClickedList[j][i] = 1
                }
            }
        }

    }
}
fun checkWin():Boolean {
    if(heart != 0){
        for (i in 0..level.size-1){
            for (j in 0..level.size-1){
                if (level[i][j] == 1 &&level[i][j] != tempClickedList[i][j]) {
                    return false
                }
            }
        }
        return true
    }
    else{
        return false
    }
}
@Composable
fun CreateBoard(
    level: List<List<Int>>,
    modifier: Modifier = Modifier
) {
    val hintsPair = createHint(level)

    val rowHints = hintsPair.first
    val colHints = hintsPair.second

    Column (
        modifier = Modifier
            .border(1.dp, Color.Black)
    ){
        Row (
            modifier = Modifier
                .border(1.dp, Color(0xFFFFFedc2ef))
        ) {
            Column(
                modifier = Modifier
                    .width(300.dp / level.size)
            )
            {

            }
            Column (
                modifier = Modifier
            ){
                LazyRow(
                    modifier = Modifier
                ) {
                    items(colHints) { col ->
                        LazyColumn(
                            modifier = Modifier
                                .border(1.dp, Color(0xFFFFFedc2ef))
                                .width(300.dp / level.size)
                                .padding(5.dp)
                                .offset(x = 25.dp)
                        ){
                            items(col) { item ->
                                Text(text = "$item")
                            }
                        }


                    }
                }
            }
        }
        Row (
            modifier = Modifier
                .border(1.dp, Color.Black)
        ){
            LazyColumn (
                modifier = Modifier
                    .width(300.dp / level.size)
            ){
                items(rowHints) { row ->
                    LazyRow (
                        modifier = Modifier
                            .height(300.dp / level.size)
                            .offset(x = 20.dp)
                            .offset(y = 15.dp)

                    ){
                        items(row) { item ->
                            Text(text="$item")
                        }
                    }

                }
            }
            //ตาราง
            Column (
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .height(300.dp)

            ){
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.Red)
                        .size(width = 300.dp, height = 300.dp)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(level.size),
                        modifier = modifier,
                        contentPadding = PaddingValues(5.dp),
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        itemsIndexed(level.flatten()) { index, cell ->
                            CreateCell(
                                idx = (index / level.size).toString() + (index % level.size).toString(),
                                ans = cell
                            )
                        }
                    }
                }
            }
        }
    }
}