package luyao.wanandroid.adapter

import androidx.core.text.HtmlCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import luyao.util.ktx.ext.fromN
import luyao.wanandroid.R
import luyao.wanandroid.model.bean.Article

/**
 * Created by luyao
 * on 2018/3/14 15:52
 */
@Suppress("DEPRECATION")
class HomeArticleAdapter(layoutResId: Int = R.layout.item_article) : BaseQuickAdapter<Article, BaseViewHolder>(layoutResId) {

    private var showStar = true

    fun showStar(showStar: Boolean) {
        this.showStar = showStar
    }

    override fun convert(helper: BaseViewHolder, item: Article) {
        helper.setText(R.id.articleTitle, HtmlCompat.fromHtml(item.title,HtmlCompat.FROM_HTML_MODE_LEGACY))
                .setText(R.id.articleAuthor, item.author)
                .setText(R.id.articleTag, "${item.superChapterName ?: ""} ${item.chapterName}")
                .setText(R.id.articleTime, item.niceDate)
                .addOnClickListener(R.id.articleStar)

        if (showStar) helper.setImageResource(R.id.articleStar, if (item.collect) R.drawable.timeline_like_pressed else R.drawable.timeline_like_normal)
        else helper.setVisible(R.id.articleStar, false)
    }
}
