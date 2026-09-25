package ir.polaris.test.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright

/**
 * Recreates the celestial geometric art from the reference website:
 * - Moon/sphere with atmospheric radial gradient
 * - Overlapping mountain polygons with sharp diagonal facets
 * - Concentric celestial orbits/arcs
 * - Sparkling 4-point golden Polaris star
 */
@Composable
fun PolarisHeroArt(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val centerX = canvasWidth * 0.42f
            val centerY = canvasHeight * 0.45f

            // 1. Concentric orbital geometric rings
            val orbitColor = Color(0x22F4F4F6)
            val orbitGoldColor = Color(0x33D8B468)

            drawCircle(
                color = orbitColor,
                radius = canvasHeight * 0.55f,
                center = Offset(centerX, centerY),
                style = Stroke(width = 1.2f)
            )

            drawCircle(
                color = orbitGoldColor,
                radius = canvasHeight * 0.72f,
                center = Offset(centerX - 20f, centerY + 15f),
                style = Stroke(width = 1f)
            )

            // 2. The Celestial Moon / Sphere
            val moonRadius = canvasHeight * 0.34f
            val moonCenter = Offset(centerX, centerY - 15f)
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF5A5D66),
                        Color(0xFF383A42),
                        Color(0xFF1E2026),
                        Color(0xFF101115)
                    ),
                    center = Offset(moonCenter.x - moonRadius * 0.3f, moonCenter.y - moonRadius * 0.3f),
                    radius = moonRadius * 1.2f
                ),
                radius = moonRadius,
                center = moonCenter
            )

            // Subtle crater/surface highlights on the moon
            drawCircle(
                color = Color(0x1AFFFFFF),
                radius = moonRadius * 0.22f,
                center = Offset(moonCenter.x + moonRadius * 0.15f, moonCenter.y - moonRadius * 0.2f)
            )
            drawCircle(
                color = Color(0x12FFFFFF),
                radius = moonRadius * 0.14f,
                center = Offset(moonCenter.x - moonRadius * 0.25f, moonCenter.y + moonRadius * 0.1f)
            )

            // 3. Overlapping dark mountain polygon facets
            // Back Mountain Peak
            val backMountain = Path().apply {
                moveTo(canvasWidth * 0.05f, canvasHeight)
                lineTo(centerX + 60f, canvasHeight * 0.28f)
                lineTo(canvasWidth * 0.95f, canvasHeight)
                close()
            }
            drawPath(
                path = backMountain,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF2A2C35),
                        Color(0xFF181A20),
                        Color(0xFF0C0D10)
                    ),
                    start = Offset(centerX + 60f, canvasHeight * 0.28f),
                    end = Offset(canvasWidth * 0.5f, canvasHeight)
                )
            )

            // Front Mountain Peak
            val frontMountain = Path().apply {
                moveTo(0f, canvasHeight)
                lineTo(centerX - 40f, canvasHeight * 0.42f)
                lineTo(canvasWidth * 0.85f, canvasHeight)
                close()
            }
            drawPath(
                path = frontMountain,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF1E2028),
                        Color(0xFF14151B),
                        Color(0xFF08080A)
                    ),
                    start = Offset(centerX - 40f, canvasHeight * 0.42f),
                    end = Offset(canvasWidth * 0.4f, canvasHeight)
                )
            )

            // Diagonal crisp mountain ridge light line
            drawLine(
                color = Color(0x33FFFFFF),
                start = Offset(centerX - 40f, canvasHeight * 0.42f),
                end = Offset(0f, canvasHeight),
                strokeWidth = 1f
            )

            // 4. Sparkling 4-point Golden Polaris Star
            val starCenter = Offset(centerX + 72f, canvasHeight * 0.50f)
            val starSize = 22f

            // Golden star glow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0x66D8B468),
                        Color(0x00D8B468)
                    ),
                    center = starCenter,
                    radius = starSize * 2.5f
                ),
                radius = starSize * 2.5f,
                center = starCenter
            )

            // 4-pointed diamond star path
            val starPath = Path().apply {
                moveTo(starCenter.x, starCenter.y - starSize)
                quadraticTo(starCenter.x, starCenter.y, starCenter.x + starSize, starCenter.y)
                quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y + starSize)
                quadraticTo(starCenter.x, starCenter.y, starCenter.x - starSize, starCenter.y)
                quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y - starSize)
                close()
            }
            drawPath(
                path = starPath,
                color = PolarisGoldBright
            )

            // Star center intense core
            drawCircle(
                color = Color.White,
                radius = 2.5f,
                center = starCenter
            )
        }
    }
}
