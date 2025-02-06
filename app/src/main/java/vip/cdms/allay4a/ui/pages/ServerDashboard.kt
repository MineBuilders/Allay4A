package vip.cdms.allay4a.ui.pages

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.ViewCompat
import vip.cdms.allay4a.ui.components.ConsoleView
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ServerDashboard(
    innerPadding: PaddingValues,
) {
    val scrollState = rememberScrollState()

    Column(
        Modifier.fillMaxSize()
            .verticalScroll(scrollState)
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
    ) {
        val titleVisualBalance = 2.dp
        Text(
            "Default Server",
            modifier = Modifier.padding(top = 32.dp).offset(x = titleVisualBalance),
            style = MaterialTheme.typography.h4
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Row(Modifier.offset(x = (-3).dp).offset(x = titleVisualBalance)) {
                Icon(Icons.Filled.Timelapse, contentDescription = null, modifier = Modifier.scale(.7f))
                Text("114514 hours ago.", style = MaterialTheme.typography.subtitle1)
            }
        }

        Spacer(Modifier.size(16.dp))

        var consoleView by remember { mutableStateOf<ConsoleView?>(null) }
        val consoleScrollableState = rememberScrollableState {
            consoleView?.scrollBy(0, -it.roundToInt())
            it
        }
        Card(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .scrollable(consoleScrollableState, Orientation.Vertical)
                .height(400.dp),
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context -> ConsoleView(context).also { consoleView = it } }
            )
            val textSize = with(LocalDensity.current) { 4.sp.toPx() }
            val textPadding = with(LocalDensity.current) { 8.dp.toPx() }.roundToInt()
            var i by remember { mutableStateOf(0) }  // TODO: delete me
            LaunchedEffect(consoleView) {
                if (consoleView == null) return@LaunchedEffect
                consoleView!!.textView.setOnClickListener { consoleView!!.writeLine("Hello" + ++i) }
                consoleView!!.textView.textSize = textSize
                consoleView!!.textView.setPadding(textPadding, textPadding, textPadding, textPadding)
                consoleView!!.writeLine("2025-02-06T08:01:29.459241600Z main WARN Advanced terminal features are not available in this environment")
                consoleView!!.writeLine("[[36m16:01:29 INFO[m] [[33mmain[m] [[34mAllayAPI[m] Server language was set to English (United States)")
                consoleView!!.writeLine("[[36m16:01:49 INFO[m] [[33mmain[m] [[34mAllay[m] Starting up Minecraft: Bedrock Edition server, version [0;32;1m1.21.50[m (protocol version [0;32;1m766[m)[m")
                consoleView!!.writeLine("[[36m16:01:49 INFO[m] [[33mmain[m] [[34mAllay[m] This server is running [0;36;1mallay[m [0;32;1m0.1.3-dev[m with [0;36;1mallay-api[m [0;32;1m0.4.0[m")
                consoleView!!.writeLine("[[36m16:01:49 WARN[m] [[33mmain[m] [[34mAllay[m] [0;33;1mYou are running a development version. The development version may have unexpected bugs, please do not use it in a production environment![m")
                consoleView!!.writeLine("[[36m16:01:49 INFO[m] [[33mmain[m] [[34mEnchantmentTypeRegistryPopulator[m] Loading enchantment types...")
                consoleView!!.writeLine("[[36m16:01:49 INFO[m] [[33mmain[m] [[34mEnchantmentTypeRegistryPopulator[m] Loaded 41 enchantment types")
                consoleView!!.writeLine("[[36m16:01:49 INFO[m] [[33mmain[m] [[34mItemTypeRegistryPopulator[m] Loading item types...")
                consoleView!!.writeLine("[[36m16:01:50 INFO[m] [[33mmain[m] [[34mItemTypeRegistryPopulator[m] Loaded 1788 item types")
                consoleView!!.writeLine("[[36m16:01:50 INFO[m] [[33mmain[m] [[34mBlockEntityTypeRegistryPopulator[m] Loading block entity types...")
                consoleView!!.writeLine("[[36m16:01:50 INFO[m] [[33mmain[m] [[34mBlockEntityTypeRegistryPopulator[m] Loaded 7 block entity types")
                consoleView!!.writeLine("[[36m16:01:50 INFO[m] [[33mmain[m] [[34mBlockTypeRegistryPopulator[m] Loading block types...")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mBlockTypeRegistryPopulator[m] Loaded 1253 block types")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mEffectTypeRegistryPopulator[m] Loading effect types...")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mEffectTypeRegistryPopulator[m] Loaded 36 effect types")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mEntityTypeRegistryPopulator[m] Loading entity types...")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mEntityTypeRegistryPopulator[m] Loaded 129 entity types")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mCreativeItemRegistryLoader[m] Loading creative items...")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mCreativeItemRegistryLoader[m] Creative items is loaded")
                consoleView!!.writeLine("[[36m16:01:51 INFO[m] [[33mmain[m] [[34mRecipeRegistryLoader[m] Loading recipes...")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mRecipeRegistryLoader[m] Loaded 2127 recipes")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mFurnaceRecipeRegistryLoader[m] Loading furnace recipes...")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mFurnaceRecipeRegistryLoader[m] Loaded 220 furnace recipes")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mPackRegistryLoader[m] Pack auto encrypting is enabled, encryption is starting...")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mPackRegistryLoader[m] Loading packs...")
                consoleView!!.writeLine("[[36m16:01:52 INFO[m] [[33mmain[m] [[34mPackRegistryLoader[m] Loaded 0 packs")
                consoleView!!.writeLine("[[36m16:01:54 INFO[m] [[33mmain[m] [[34mAllayWorldPool[m] Loading world world")
                consoleView!!.writeLine("[[36m16:01:54 INFO[m] [[33mmain[m] [[34mAllayWorldPool[m] World world is loaded")
                consoleView!!.writeLine("[[36m16:01:54 INFO[m] [[33mmain[m] [[34mAllayServer[m] Starting up network interface...")
                consoleView!!.writeLine("[[36m16:01:54 INFO[m] [[33mmain[m] [[34mAllayServer[m] Network interface started at 127.0.0.1:19132 (27656 ms)")
                consoleView!!.writeLine("[[36m16:02:01 INFO[m] [[33mmain[m] [[34mAllayServer[m] [0;31;1mUnknown command: awa. Please check that the command exists and that you have permission to use it.[m")
            }
        }
        Spacer(Modifier.fillMaxWidth().height(999.dp))
    }
}
