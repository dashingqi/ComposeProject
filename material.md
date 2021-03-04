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

#### 声明式UI和命令式UI
功能角度的定义
###### 声明式UI
把界面手动声明出来，而数据不需要手动更新
Compose界面会随着数据自定去更新页面显示
采取的是自动订阅的模式，Compose会自动订阅数据，当数据更新时就会自动更新界面显示
val text by mutableStateOf("data"); 采用的是属性委托的机制来实现的

###### 命令式UI
findViewById() ----> setText()
命令式布局不在于xml布局 而在于我们上述的Java代码，当我们拿到新数据的时候Java会命令xml更新数据的。


