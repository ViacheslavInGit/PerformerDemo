package com.viapp.b.performer.app.ui.screen.goal.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.viapp.b.domain.entity.Goal

@Composable
fun ViewGoalItem(
    goal: Goal,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 15.dp,
    topRightCutSize: Dp = 30.dp,
    onDeleteClick: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {

        CreateCanvas(
            color = goal.color,
            cornerRadius = cornerRadius,
            topRightCutSize = topRightCutSize,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {
            Text(
                text = goal.name,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        CreateDeleteButton(
            onDeleteClick = onDeleteClick,
        )
    }
}

@Composable
private fun BoxScope.CreateCanvas(
    color: Int,
    cornerRadius: Dp = 15.dp,
    topRightCutSize: Dp = 30.dp,
) {
    Canvas(modifier = Modifier.matchParentSize()) {
        val clipPath = Path().apply {
            lineTo(size.width - topRightCutSize.toPx(), 0f)
            lineTo(size.width, topRightCutSize.toPx())
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        clipPath(clipPath) {
            drawRoundRect(
                color = Color(color),
                size = size,
                cornerRadius = CornerRadius(cornerRadius.toPx())
            )
            drawRoundRect(
                color = Color(
                    ColorUtils.blendARGB(color, 0x000000, 0.2f)
                ),
                topLeft = Offset(size.width - topRightCutSize.toPx(), -100f),
                size = Size(topRightCutSize.toPx() + 100f, topRightCutSize.toPx() + 100f),
                cornerRadius = CornerRadius(cornerRadius.toPx())
            )
        }
    }
}

@Composable
private fun BoxScope.CreateDeleteButton(
    onDeleteClick: () -> Unit,
) {
    IconButton(
        onClick = onDeleteClick,
        modifier = Modifier.align(Alignment.BottomEnd),
        content = {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colors.onSurface
            )
        }
    )
}
