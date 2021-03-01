#### Compose的学习资料

###### 官方文档资料

```
https://developer.android.google.cn/jetpack/compose/mental-model?authuser=0
```

#### 标准布局组件

###### Column
- 使用Column可以将多个控件垂直放置在屏幕上。

###### Row
- 使用Row可以将多个项目水平地放置在屏幕上。

###### Box
- 使用Box可以将一个元素放置在另外一个元素上。

###### 修饰符

- Modifier

###### 布局的滚动

- 横向滚动
ScrollableRow
LazyRowFor：适合用于大数据量，仅仅展示屏幕上可见的部分

- 垂直滚动
ScrollableColumn
LazyColumnFor:适合用于大数据量，仅仅展示屏幕上可见的部分
```
    Surface(Modifier.fillMaxSize()) {
            LazyColumnFor(feedItems) { item ->
                artistCard(item)

            }
        }
```

#### Material

Material 支持的最高级别的可组合项是 Scaffold
