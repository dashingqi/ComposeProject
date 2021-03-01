package com.dashingqi.composeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ScaffoldDemo()
        }
    }


    @Preview
    @Composable
    fun artistCard(name: String) {
        val padding = 16.dp
        //图片
        val headerImg = imageResource(id = R.drawable.ic)
        //头像图片的修饰符
        val headerModifier = Modifier
            // 设置图片的高
            .preferredHeight(48.dp)
            //设置图片的宽
            .preferredWidth(48.dp)
            //设置图片的圆角
            .clip(RoundedCornerShape(24.dp))

        //banner的图片资源
        val bannerImg = imageResource(id = R.drawable.banner)
        //banner的修饰符
        val bannerModifier = Modifier
            .preferredHeight(128.dp)
            //让宽度填充布局
            .fillMaxWidth()

        Column(Modifier.padding(padding).fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    bitmap = headerImg,
                    modifier = headerModifier,
                    contentScale = ContentScale.Crop
                )
                //加入间距
                Spacer(Modifier.preferredSize(8.dp))

                Column(horizontalAlignment = Alignment.Start) {
                    Text(name, color = Color.Blue, fontSize = 15.sp)
                    Spacer(Modifier.preferredSize(4.dp))
                    Text("3 minutes ago", color = Color.Black, fontSize = 12.sp)
                }
            }
            Spacer(Modifier.preferredSize(padding))

            // 卡片的布局
            Card(elevation = 4.dp) {
                Image(
                    modifier = bannerModifier,
                    bitmap = bannerImg,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

    @Composable
    fun Feed(feedItems: List<String>) {
//        ScrollableRow(Modifier.wrapContentHeight().fillMaxWidth()) {
//            feedItems.forEach {
//                artistCard(it)
//            }
//        }
        Surface(Modifier.fillMaxSize()) {
            LazyColumnFor(feedItems) { item ->
                artistCard(item)

            }
        }
    }


    /**
     * Scaffold使用Demo
     */
    @ExperimentalMaterialApi
    @Composable
    fun ScaffoldDemo() {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,

            //抽屉控件的你内容绘制
            drawerContent = {
                drawerContentFun()
            },

            //顶部标题栏
            topBar = {
                topAppBarFun(scaffoldState)
            },

            //屏幕内容绘制
            bodyContent = {
                bodyContentFun()
            },

            //悬浮按钮
            floatingActionButton = {
                floatingButtonFun(scope, scaffoldState)
            },

            //悬浮按钮的位置
            floatingActionButtonPosition = FabPosition.End
        )
    }

    /**
     * 顶部标题栏
     */
    @Composable
    private fun topAppBarFun(scaffoldState: ScaffoldState) {
        TopAppBar(
            title = { Text("这是脚手架项目") },
            navigationIcon = {
                IconButton(onClick = { scaffoldState.drawerState.open() }) {
                    Icon(imageVector = Icons.Filled.Menu)
                }
            }
        )
    }

    /**
     * 抽屉内容
     */
    @Composable
    private fun drawerContentFun() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "抽屉组件中的内容")
        }
    }

    /**
     * 屏幕绘制内容
     */
    @Composable
    private fun bodyContentFun() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            var list = arrayListOf<String>("DashingQi", "XHY", "HaHaHa", "HeiHeiHei", "DashingQi")
            //Text(text = "屏幕内容绘制区域")
            Feed(list)
        }
    }

    /**
     * 悬浮按钮
     */
    @ExperimentalMaterialApi
    @Composable
    private fun floatingButtonFun(scope: CoroutineScope, state: ScaffoldState) {
        ExtendedFloatingActionButton(
            text = { Text("悬浮按钮") },
            onClick = {
                scope.launch {
                    state.snackbarHostState.showSnackbar(message = "点击了悬浮按钮")
                }
            })
    }
}