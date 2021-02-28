package com.dashingqi.composeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var list = arrayListOf<String>("DashingQi", "XHY", "GY", "Hello GY")
            Feed(list)
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
        ScrollableRow(Modifier.wrapContentHeight().fillMaxWidth()) {
            feedItems.forEach {
                artistCard(it)
            }
        }
    }
}