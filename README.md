SVG格式, 适应屏幕, 图片较小, 还有很多优点, [参考](https://zh.wikipedia.org/wiki/%E5%8F%AF%E7%B8%AE%E6%94%BE%E5%90%91%E9%87%8F%E5%9C%96%E5%BD%A2). 本文讲解如何使用SVG格式.

> SVG: Scalable Vector Graphics, 可缩放矢量图形.
> IRI: Internationalized Resource Identifiers, 国际化资源标识符.

下载SVG格式的图片.

新建项目, 空白项目显示图片.

Android Studio 2.0
路径: File -> New -> Vector Asset -> Local SVG file

![加载](http://img.blog.csdn.net/20151228093456904)
> 勾选**重置图片大小**和**左右布局适配**.

在``drawable``文件夹中, 就会发现``.xml``格式的图片.

代码中导入图片.
```
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:contentDescription="@null"
        android:src="@drawable/homer_simpson"/>
```

显示
![显示](http://img.blog.csdn.net/20151228093517967)

如果是``非AS2.0``版本, 我们可以使用在线网站转换.
网址: http://inloop.github.io/svg2android/

上传SVG图片, 生成代码.
![Online](http://img.blog.csdn.net/20151228093535314)

> 勾选**删除空组**和**添加变换**.

可以下载在线图片, 也可以在``drawable``文件夹中, 创建``.xml``文件, 粘贴代码.
使用方式与自动生成的类似, 直接添加即可.

通过观察发现, 均是500x500的图片:
自动生成的SVG图片是20KB, 在线生成的SVG图片是29KB.
而PNG(放大的系统图片)要732KB, 由此得知SVG图片还是非常节省内存的.
对于一些较大的App, 使用SVG图片有很大的吸引力.

Github[下载地址](https://github.com/SpikeKing/TestSVG)

OK, Enjoy It.
