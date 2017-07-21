# Examination
一个有关考试与学习的APP,使用okhttp,mvp
## 沉浸式状态栏
* ### 设置状态栏颜色，并且不让顶部的bar进入状态栏，应设置一个主题 
<style name="AppTheme.NoActionBar">
        <item name="android:fitsSystemWindows">true</item>
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
</style>
* ###  闪屏页，登录页，指引页不需要沉浸式可以全屏显示，同样需要设置一个主题
在上面的主题中加入 </br>
<item name="android:windowFullscreen">true</item>
* ### sugarorm数据库注意点
注意包名要对
* ### 数组转List集合,不要采用数组迭代添加到集合中
List list = Arrays.asList（数组）
