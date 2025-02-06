package vip.cdms.allay4a.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch
import vip.cdms.allay4a.ui.pages.*
import vip.cdms.allay4a.ui.theme.AlwaysDarkTheme
import vip.cdms.allay4a.ui.theme.ColorError
import vip.cdms.allay4a.ui.theme.ColorSuccess

@Suppress("AnimatedContentLabel", "AnimateAsStateLabel")
@Composable
fun AllayApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var isRunningServer by remember { mutableStateOf(false) }

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { 5 })
    remember(pagerState.currentPage) { selectedTabIndex = pagerState.currentPage }

    var isShowQuickMenu by remember { mutableStateOf(false) }
    if (isShowQuickMenu) Dialog(onDismissRequest = { isShowQuickMenu = false }) {
        Column {
            val colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.onBackground)
            OutlinedButton(
                onClick = {
                    isShowQuickMenu = false
                },
                modifier = Modifier.fillMaxWidth(),
                colors = colors,
            ) {
                Icon(Icons.Default.RestartAlt, contentDescription = "Restart")
                Spacer(Modifier.size(6.dp))
                Text("Restart")
            }
            OutlinedButton(
                onClick = {
                    isShowQuickMenu = false
                    isRunningServer = false
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults. outlinedButtonColors(contentColor = ColorError),
            ) {
                Icon(Icons.Default.Pause, contentDescription = "Shutdown")
                Spacer(Modifier.size(6.dp))
                Text("Shutdown")
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerScrimColor = MaterialTheme.colors.background.copy(alpha = ContentAlpha.medium),
        drawerContent = {
            Spacer(Modifier.size(WindowInsets.statusBars.asPaddingValues().calculateTopPadding()))
            Text("Drawer content")
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            val backgroundColor by animateColorAsState(if (!isRunningServer) ColorError else ColorSuccess)
            FloatingActionButton(
                onClick = {
                    if (!isRunningServer) isRunningServer = true
                    else isShowQuickMenu = true
                },
                backgroundColor = backgroundColor,
                contentColor = Color.White,
            ) {
                AnimatedContent(
                    isRunningServer,
                ) {
                    if (it) Icon(Icons.Filled.Bolt, contentDescription = "Server Action")
                    else Icon(Icons.Filled.PlayArrow, contentDescription = "Run")
                }
            }
        },
        bottomBar = {
            AlwaysDarkTheme {
                BottomAppBar(
                    cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
                    elevation = 0.dp,
                ) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(
                            onClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = "Server List")
                        }
                    }
                    val titles = listOf("Dashboard", "Players", "Plugins", "Performance", "Settings")
                    val icons = listOf(Icons.Filled.Dashboard, Icons.Filled.People, Icons.Filled.Extension, Icons.Filled.Speed, Icons.Filled.Settings)
                    val innerShadowWidthDp = 16.dp
                    val innerShadowWidth = with(LocalDensity.current) { innerShadowWidthDp.toPx() }
                    val innerShadowColor = MaterialTheme.colors.primarySurface
                    ScrollableTabRow(
                        selectedTabIndex = selectedTabIndex,
                        modifier = Modifier.fillMaxSize()
                            .padding(start = 4.dp, end = /*FabSize*/56.dp + 32.dp - 2.dp)
                            .drawWithContent {
                                drawContent()
                                if (selectedTabIndex != 0) drawRect(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(innerShadowColor, Color.Transparent),
                                        startX = 0f,
                                        endX = innerShadowWidth,
                                    ),
                                    size = size.copy(width = innerShadowWidth),
                                )
                                if (selectedTabIndex != titles.size - 1) drawRect(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(Color.Transparent, innerShadowColor),
                                        startX = size.width - innerShadowWidth,
                                        endX = size.width,
                                    ),
                                    topLeft = Offset.Zero.copy(x = size.width - innerShadowWidth),
                                    size = size.copy(width = innerShadowWidth),
                                )
                            },
                        edgePadding = 0.dp,
                        divider = {},
                    ) {
                        titles.forEachIndexed { index, title ->
                            val selected = selectedTabIndex == index
                            LeadingIconTab(
                                modifier = Modifier.fillMaxHeight()
                                    .background(if (selected) Color.White.copy(alpha = .1f) else Color.Transparent),
                                text = { Text(title) },
                                icon = { Icon(icons[index], contentDescription = title) },
                                selected = selected,
                                onClick = {
                                    selectedTabIndex = index
                                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                                }
                            )
                        }
                    }
                }
            }
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
    ) { innerPadding ->
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> ServerDashboard(innerPadding)
                1 -> ServerPlayers()
                2 -> ServerPlugins()
                3 -> ServerPerformance()
                4 -> ServerSettings()
            }
        }
    }
}
